package com.wvd.saas.rbac.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wvd.saas.rbac.web.entity.FmMenuResource;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单资源表 服务类
 * </p>
 *
 * @author author
 * @since 2019-12-08
 */
public interface IFmMenuResouceService extends IService<FmMenuResource> {
    List<FmMenuResource> list(Map map);
}
