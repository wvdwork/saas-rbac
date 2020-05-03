package com.wvd.saas.rbac.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wvd.saas.rbac.web.entity.FmDataDetail;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据主明细表 服务类
 * </p>
 *
 * @author author
 * @since 2019-12-09
 */
public interface IFmDataDetailService extends IService<FmDataDetail> {
    List<FmDataDetail> getDetailsByDataId(Long dataId);
    IPage<FmDataDetail> searchPage(Map map);
}
