package com.wvd.saas.rbac.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wvd.saas.rbac.web.entity.FmRole;

import java.util.Map;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author author
 * @since 2019-11-23
 */
public interface IFmRoleService extends IService<FmRole> {
    IPage<FmRole> searchPage(Map map);
}
