package com.wvd.saas.rbac.web.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.x.json.JsonArray;
import com.wvd.saas.rbac.web.common.SystemResponseStatus;
import com.wvd.saas.rbac.web.common.enums.LoginAccountTypeEnums;
import com.wvd.saas.rbac.web.common.exception.RuntimeBusinessException;
import com.wvd.saas.rbac.web.dto.UserAddDto;
import com.wvd.saas.rbac.web.entity.FmOrgUser;
import com.wvd.saas.rbac.web.entity.FmPassword;
import com.wvd.saas.rbac.web.entity.FmUser;
import com.wvd.saas.rbac.web.entity.FmUserAccount;
import com.wvd.saas.rbac.web.mapper.FmUserMapper;
import com.wvd.saas.rbac.web.service.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
public class FmUserServiceImpl extends ServiceImpl<FmUserMapper, FmUser> implements IFmUserService {

    @Autowired
    IFmUserAccountService accountService;

    @Autowired
    IFmPasswordService passwordService;

    @Autowired
    IFmOrgUserService orgUserService;

    @Autowired
    IFmOrganizationService organizationService;

    @Override
    public IPage<FmUser> searchPage(Map map) {
        Long current = Long.parseLong(map.get("current").toString());
        Long size = Long.parseLong(map.get("size").toString());
        return this.page(new Page(current, size), commonQueryPara(map));
    }

    @Transactional
    public void save(UserAddDto userAddDto) {
        FmUser fmUser = new FmUser();
        BeanUtils.copyProperties(userAddDto, fmUser);
        this.save(fmUser);
        FmUserAccount userAccount = accountService.getByAccount(userAddDto.getLoginAccount());
        if (userAccount != null) {
            throw new RuntimeBusinessException(SystemResponseStatus.E_4002000);
        }
        userAccount = new FmUserAccount();
        userAccount.setAccountType(LoginAccountTypeEnums.ACCOUNT.getCode());
        userAccount.setUserAccount(userAddDto.getLoginAccount());
        userAccount.setUserId(fmUser.getId());
        this.accountService.save(userAccount);

        FmPassword password = new FmPassword();
        password.setAccountId(String.valueOf(userAccount.getId()));
        password.setUserId(fmUser.getId());
        passwordService.save(password);
    }

    private QueryWrapper commonQueryPara(final Map map) {
        final QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_del", 0);
        queryWrapper.like(StringUtils.isNotEmpty(MapUtils.getString(map, "userName")), "user_name", MapUtils.getString(map, "userName"));
        queryWrapper.like(StringUtils.isNotEmpty(MapUtils.getString(map, "userNickName")), "user_nick_name", MapUtils.getString(map, "userNickName"));
        return queryWrapper;
    }

    private QueryWrapper commonQueryPara(String property, Object value) {
        Map map = new HashMap();
        map.put(property, value);
        return this.commonQueryPara(map);
    }

    public Map userOrgTreeSearch(Long userId) {
        List<FmOrgUser> orgUsers = orgUserService.listByUserId(userId);
        JSONArray orgTree = organizationService.findOrgTree(new HashMap());
        Map retMap = new HashMap();
        if (CollectionUtils.isNotEmpty(orgUsers)) {
            List<String> selected = new ArrayList();
            orgUsers.forEach(e -> {
                selected.add(String.valueOf(e.getOrgId()));
            });
            retMap.put("selected", selected);
        }
        retMap.put("orgTree", orgTree);
        return retMap;
    }

    @Transactional
    public void saveUserOrg(Long userId, Long orgId) {
        FmOrgUser fmOrgUser = new FmOrgUser();
        fmOrgUser.setOrgId(orgId);
        fmOrgUser.setUserId(userId);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);
        this.orgUserService.remove(queryWrapper);
        this.orgUserService.save(fmOrgUser);
    }
}
