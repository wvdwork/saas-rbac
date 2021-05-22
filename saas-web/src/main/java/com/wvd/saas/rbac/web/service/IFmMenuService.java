package com.wvd.saas.rbac.web.service;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wvd.saas.rbac.web.entity.FmMenu;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author author
 * @since 2019-12-03
 */
public interface IFmMenuService extends IService<FmMenu> {
    JSONArray treeByAppId(Long applicationId);
    FmMenu addMenu(Long parentId);
    void removeById(Long id);
    JSONArray findByApplication(Long applicationId);
}
