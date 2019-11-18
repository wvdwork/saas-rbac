package com.wvd.saas.rbac.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wvd.saas.rbac.web.dto.UserAddDto;
import com.wvd.saas.rbac.web.entity.FmApplication;
import com.wvd.saas.rbac.web.entity.FmUser;

import java.util.Map;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author author
 * @since 2019-11-10
 */
public interface IFmUserService extends IService<FmUser> {
    IPage<FmUser> searchPage(Map map);
    void save(UserAddDto userAddDto);
    Map userOrgTreeSearch(Long userId);
}
