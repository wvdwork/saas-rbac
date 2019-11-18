package com.wvd.saas.rbac.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wvd.saas.rbac.web.entity.FmUserAccount;
import com.wvd.saas.rbac.web.mapper.FmUserAccountMapper;
import com.wvd.saas.rbac.web.service.IFmOrganizationService;
import com.wvd.saas.rbac.web.service.IFmUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户账号表 服务实现类
 * </p>
 *
 * @author author
 * @since 2019-11-10
 */
@Service
public class FmUserAccountServiceImpl extends ServiceImpl<FmUserAccountMapper, FmUserAccount> implements IFmUserAccountService {

    @Autowired
    IFmOrganizationService organizationService;

    public FmUserAccount getByAccount(String account) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_account", account);
        return this.getOne(queryWrapper);
    }

    public List<FmUserAccount> getByUserId(Long userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);
        return this.list(queryWrapper);
    }


}
