package com.wvd.saas.rbac.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wvd.saas.rbac.web.entity.FmCompany;

import java.util.Map;

/**
 * <p>
 * 公司信息表 服务类
 * </p>
 *
 * @author author
 * @since 2019-11-03
 */
public interface IFmCompanyService extends IService<FmCompany> {
    IPage<FmCompany> searchPage(Map map);
}
