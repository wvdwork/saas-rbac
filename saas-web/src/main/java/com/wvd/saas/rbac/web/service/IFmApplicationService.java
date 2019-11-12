package com.wvd.saas.rbac.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wvd.saas.rbac.web.entity.FmApplication;

import java.util.Map;

/**
 * <p>
 * 项目信息 服务类
 * </p>
 *
 * @author author
 * @since 2019-11-10
 */
public interface IFmApplicationService extends IService<FmApplication> {
    IPage<FmApplication> searchPage(Map map);
}
