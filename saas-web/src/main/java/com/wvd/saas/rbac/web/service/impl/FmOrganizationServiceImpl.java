package com.wvd.saas.rbac.web.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wvd.saas.rbac.web.common.SystemResponseStatus;
import com.wvd.saas.rbac.web.common.exception.RuntimeBusinessException;
import com.wvd.saas.rbac.web.entity.FmOrganization;
import com.wvd.saas.rbac.web.mapper.FmOrganizationMapper;
import com.wvd.saas.rbac.web.service.IFmOrganizationService;
import com.wvd.saas.rbac.web.util.TreeUtils;
import com.wvd.saas.rbac.web.vo.OrgTreeNode;
import com.wvd.saas.rbac.web.vo.TreeNode;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.*;

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

        QueryWrapper queryWrapper = commonQueryPara(map);
        queryWrapper.orderByAsc("seq", "id");

        List<FmOrganization> orgList = this.list(queryWrapper);
        if (CollectionUtils.isEmpty(orgList)) {
            return new JSONArray();
        }

        if (MapUtils.isNotEmpty(map)) {
            List<FmOrganization> parentList = this.list(queryWrapper);
            List<FmOrganization> childList = this.list(queryWrapper);

            List<FmOrganization> parentListE = findParentList(parentList);
            List<FmOrganization> childListE = findChildList(childList);

            orgList.addAll(parentListE);
            orgList.addAll(childListE);
        }

        Map<Long, TreeNode> nodeMap = new LinkedHashMap<>();
        for (FmOrganization organization : orgList) {
            OrgTreeNode orgTreeNode = new OrgTreeNode();
            orgTreeNode.setId(organization.getId());
            orgTreeNode.setOrgCode(organization.getOrgCode());
            orgTreeNode.setOrgLevel(organization.getOrgLevel());
            orgTreeNode.setOrgName(organization.getOrgName());
            orgTreeNode.setParentId(organization.getParentId());
            orgTreeNode.setSeq(organization.getSeq());
            nodeMap.put(organization.getId(), orgTreeNode);
        }

        return TreeUtils.getNodeJson(0l, nodeMap);
    }

    private List findParentList(List<FmOrganization> orgList) {
        if(CollectionUtils.isEmpty(orgList)) {
            return new ArrayList();
        }
        List<Long> ids = new ArrayList();
        orgList.forEach(o -> {
            if (o.getParentId() != 0) {
                ids.add(o.getParentId());
            }
        });
        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList();
        }
        List<FmOrganization> parentList = (List<FmOrganization>) this.listByIds(ids);
        if (CollectionUtils.isNotEmpty(parentList)) {
            findParentList(parentList);
            orgList.addAll(parentList);
        }
        return orgList;
    }

    private List findChildList(List<FmOrganization> orgList) {
        if(CollectionUtils.isEmpty(orgList)) {
            return new ArrayList();
        }
        List<Long> ids = new ArrayList();
        orgList.forEach(o -> {
                ids.add(o.getId());
        });
        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList();
        }

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.in("parent_id", ids);
        List<FmOrganization> childList = (List<FmOrganization>) this.list(wrapper);
        if (CollectionUtils.isNotEmpty(childList)) {
            findChildList(childList);
            orgList.addAll(childList);
        }
        return orgList;
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
        queryWrapper.eq(MapUtils.getString(map, "orgId") != null, "id", MapUtils.getLong(map, "orgId"));
        queryWrapper.like(MapUtils.getString(map, "orgName") != null, "org_name", MapUtils.getString(map, "orgName"));
        return queryWrapper;
    }

    public void deleteOrgs(Long id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("parent_id", id);
        List<FmOrganization> childOrgs = this.list(wrapper);
        if (CollectionUtils.isNotEmpty(childOrgs)) {
            throw new RuntimeBusinessException(SystemResponseStatus.E_4003000);
        }

        this.baseMapper.deleteById(id);
    }
}
