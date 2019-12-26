package com.wvd.saas.rbac.web.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wvd.saas.rbac.web.common.SystemResponseStatus;
import com.wvd.saas.rbac.web.common.exception.RuntimeBusinessException;
import com.wvd.saas.rbac.web.entity.FmApplication;
import com.wvd.saas.rbac.web.entity.FmMenu;
import com.wvd.saas.rbac.web.mapper.FmMenuMapper;
import com.wvd.saas.rbac.web.service.IFmApplicationService;
import com.wvd.saas.rbac.web.service.IFmMenuService;
import com.wvd.saas.rbac.web.util.TreeUtils;
import com.wvd.saas.rbac.web.vo.MenuTreeNode;
import com.wvd.saas.rbac.web.vo.TreeNode;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author author
 * @since 2019-12-03
 */
@Service
public class FmMenuServiceImpl extends ServiceImpl<FmMenuMapper, FmMenu> implements IFmMenuService {
    @Autowired
    IFmApplicationService applicationService;

    public FmMenu addMenu(Long parentId) {
        FmMenu parentMenu = this.getById(parentId);
        FmMenu addMenu = new FmMenu();
        addMenu.setMenuName("新节点");
        addMenu.setApplicationId(parentMenu.getApplicationId());
        addMenu.setCompanyId(parentMenu.getCompanyId());
        addMenu.setParentId(parentId);
        this.save(addMenu);
        return addMenu;
    }

    public JSONArray treeByAppId(Long applicationId) {
        Map paraMap = new HashMap();
        paraMap.put("applicationId", applicationId);
        List<FmMenu> menuList = this.list(commonQueryPara(paraMap));
        if (CollectionUtils.isEmpty(menuList)) {
            FmApplication application = applicationService.getById(applicationId);
            FmMenu fmMenu = new FmMenu();
            fmMenu.setApplicationId(applicationId);
            fmMenu.setCompanyId(application.getCompanyId());
            fmMenu.setMenuName(application.getApplicationName());
            fmMenu.setPath("/");
            this.save(fmMenu);
            menuList = this.list(commonQueryPara(paraMap));
        }

        Map<Long, TreeNode> nodeMap = new LinkedHashMap<>();
        for (FmMenu menu : menuList) {
            MenuTreeNode menuTreeNode = new MenuTreeNode();
            BeanUtils.copyProperties(menu, menuTreeNode);
            nodeMap.put(menuTreeNode.getId(), menuTreeNode);
        }

        return TreeUtils.getNodeJson(0l, nodeMap);
    }

    @Transactional
    public void removeById(Long id) {
        Map paraMap = new HashMap();
        paraMap.put("parentId", id);
        List list = this.list(commonQueryPara(paraMap));
        if (CollectionUtils.isNotEmpty(list)) {
            throw new RuntimeBusinessException(SystemResponseStatus.E_4004000);
        }
        FmMenu menu = this.getById(id);
        if (menu != null && menu.getParentId() == 0) {
            throw new RuntimeBusinessException(SystemResponseStatus.E_4004001);
        }
        this.baseMapper.deleteById(id);
    }

    private QueryWrapper commonQueryPara(final Map map) {
        final QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_del", 0);
        queryWrapper.eq(StringUtils.isNotEmpty(MapUtils.getString(map, "applicationId")), "application_id", MapUtils.getString(map, "applicationId"));
        queryWrapper.eq(StringUtils.isNotEmpty(MapUtils.getString(map, "parentId")), "parent_id", MapUtils.getString(map, "parentId"));
        return queryWrapper;
    }
}
