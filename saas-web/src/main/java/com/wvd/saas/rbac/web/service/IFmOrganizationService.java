package com.wvd.saas.rbac.web.service;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wvd.saas.rbac.web.entity.FmOrganization;

import java.util.Map;

/**
 * <p>
 * 组织表 服务类
 * </p>
 *
 * @author author
 * @since 2019-11-07
 */
public interface IFmOrganizationService extends IService<FmOrganization> {
    IPage<FmOrganization> searchPage(Map map);
    JSONArray findOrgTree(Map map);
    void deleteOrgs(Long id);
}
