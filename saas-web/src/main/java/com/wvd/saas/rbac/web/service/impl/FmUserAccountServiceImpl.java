package com.wvd.saas.rbac.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wvd.saas.rbac.web.entity.FmUserAccount;
import com.wvd.saas.rbac.web.mapper.FmUserAccountMapper;
import com.wvd.saas.rbac.web.service.IFmUserAccountService;
import org.springframework.stereotype.Service;

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

}
