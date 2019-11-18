package com.wvd.saas.rbac.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wvd.saas.rbac.web.entity.FmOrgUser;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author author
 * @since 2019-11-10
 */
public interface IFmOrgUserService extends IService<FmOrgUser> {
    List<FmOrgUser> listByUserId(Long userId);
    List<FmOrgUser> listByOrgId(Long orgId);
}
