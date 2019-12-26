package com.wvd.saas.rbac.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wvd.saas.rbac.web.entity.FmCompany;
import com.wvd.saas.rbac.web.entity.FmData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 数据主表 服务类
 * </p>
 *
 * @author author
 * @since 2019-12-09
 */
public interface IFmDataService extends IService<FmData> {
    IPage<FmData> searchPage(Map map);

    void deleteData(Long orgId);
}
