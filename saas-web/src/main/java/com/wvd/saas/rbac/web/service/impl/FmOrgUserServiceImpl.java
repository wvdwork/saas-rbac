package com.wvd.saas.rbac.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wvd.saas.rbac.web.common.SystemResponseStatus;
import com.wvd.saas.rbac.web.common.enums.LoginAccountTypeEnums;
import com.wvd.saas.rbac.web.common.exception.RuntimeBusinessException;
import com.wvd.saas.rbac.web.dto.UserAddDto;
import com.wvd.saas.rbac.web.entity.FmOrgUser;
import com.wvd.saas.rbac.web.entity.FmPassword;
import com.wvd.saas.rbac.web.entity.FmUser;
import com.wvd.saas.rbac.web.entity.FmUserAccount;
import com.wvd.saas.rbac.web.mapper.FmOrgUserMapper;
import com.wvd.saas.rbac.web.mapper.FmUserMapper;
import com.wvd.saas.rbac.web.service.IFmOrgUserService;
import com.wvd.saas.rbac.web.service.IFmPasswordService;
import com.wvd.saas.rbac.web.service.IFmUserAccountService;
import com.wvd.saas.rbac.web.service.IFmUserService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author author
 * @since 2019-11-10
 */
@Service
public class FmOrgUserServiceImpl extends ServiceImpl<FmOrgUserMapper, FmOrgUser> implements IFmOrgUserService {

    public List<FmOrgUser> listByUserId(Long userId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id", userId);
        return this.list(wrapper);
    }

    public List<FmOrgUser> listByOrgId(Long orgId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("org_id", orgId);
        return this.list(wrapper);
    }
}
