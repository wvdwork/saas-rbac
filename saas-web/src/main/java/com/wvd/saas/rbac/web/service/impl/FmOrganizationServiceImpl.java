package com.wvd.saas.rbac.web.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wvd.saas.rbac.web.entity.FmOrganization;
import com.wvd.saas.rbac.web.mapper.FmOrganizationMapper;
import com.wvd.saas.rbac.web.service.IFmOrganizationService;
import com.wvd.saas.rbac.web.util.OrgTree;
import com.wvd.saas.rbac.web.vo.OrgTreeNode;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 组织表 服务实现类
 * </p>
 *
 * @author author
 * @since 2019-11-07
 */
@Service
public class FmOrganizationServiceImpl extends ServiceImpl<FmOrganizationMapper, FmOrganization> implements IFmOrganizationService {

    public JSONArray findOrgTree(Map map) {
        List<FmOrganization> orgList = this.list();
        if (CollectionUtils.isEmpty(orgList)) {
            return new JSONArray();
        }
        Map<Long, OrgTreeNode> nodeMap = new HashMap();
        for (FmOrganization organization : orgList) {
            OrgTreeNode orgTreeNode = new OrgTreeNode();
            orgTreeNode.setId(organization.getId());
            orgTreeNode.setOrgCode(organization.getOrgCode());
            orgTreeNode.setOrgLevel(organization.getOrgLevel());
            orgTreeNode.setOrgName(organization.getOrgName());
            orgTreeNode.setParentId(organization.getParentId());
            nodeMap.put(organization.getId(), orgTreeNode);
        }

        return OrgTree.getNodeJson(0l, nodeMap);
    }

    public IPage<FmOrganization> searchPage(Map map) {
        Long current = Long.parseLong(map.get("current").toString());
        Long size = Long.parseLong(map.get("size").toString());
        Page page = new Page(current, size);
        map.put("orgLevel", 1);
        Wrapper wrapper = commonQueryPara(map);
        return this.page(page, wrapper);
    }

    private QueryWrapper commonQueryPara(final Map map) {
        final QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_del", 0);
        queryWrapper.eq(MapUtils.getString(map, "orgCode") != null, "org_code", MapUtils.getString(map, "orgCode"));
        queryWrapper.eq(MapUtils.getString(map, "orgLevel") != null, "org_level", MapUtils.getString(map, "orgLevel"));
        return queryWrapper;
    }
}
