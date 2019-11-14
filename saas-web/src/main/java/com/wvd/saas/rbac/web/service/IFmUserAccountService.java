package com.wvd.saas.rbac.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wvd.saas.rbac.web.entity.FmUserAccount;

import java.util.List;

/**
 * <p>
 * 用户账号表 服务类
 * </p>
 *
 * @author author
 * @since 2019-11-10
 */
public interface IFmUserAccountService extends IService<FmUserAccount> {
    FmUserAccount getByAccount(String account);
    List<FmUserAccount> getByUserId(Long userId);
}
