package com.wvd.saas.rbac.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wvd.saas.rbac.web.entity.FmPassword;
import com.wvd.saas.rbac.web.mapper.FmPasswordMapper;
import com.wvd.saas.rbac.web.service.IFmPasswordService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户密码表 服务实现类
 * </p>
 *
 * @author author
 * @since 2019-11-10
 */
@Service
public class FmPasswordServiceImpl extends ServiceImpl<FmPasswordMapper, FmPassword> implements IFmPasswordService {

}
