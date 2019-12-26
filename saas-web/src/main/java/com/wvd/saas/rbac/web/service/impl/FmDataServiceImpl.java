package com.wvd.saas.rbac.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wvd.saas.rbac.web.common.SystemResponseStatus;
import com.wvd.saas.rbac.web.common.exception.RuntimeBusinessException;
import com.wvd.saas.rbac.web.config.BusinessExceptionHandler;
import com.wvd.saas.rbac.web.entity.FmCompany;
import com.wvd.saas.rbac.web.entity.FmData;
import com.wvd.saas.rbac.web.entity.FmDataDetail;
import com.wvd.saas.rbac.web.mapper.FmDataMapper;
import com.wvd.saas.rbac.web.service.IFmDataDetailService;
import com.wvd.saas.rbac.web.service.IFmDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据主表 服务实现类
 * </p>
 *
 * @author author
 * @since 2019-12-09
 */
@Service
public class FmDataServiceImpl extends ServiceImpl<FmDataMapper, FmData> implements IFmDataService {
    @Autowired
    IFmDataDetailService detailService;


    public IPage<FmData> searchPage(Map map) {
        Long current = Long.parseLong(map.get("current").toString());
        Long size = Long.parseLong(map.get("size").toString());
        Page page = new Page(current, size);
        QueryWrapper wrapper = commonQueryPara(map);
        wrapper.orderByDesc("create_time");
        return this.page(page, wrapper);
    }

    @Override
    public void deleteData(Long dataId) {
        List<FmDataDetail> details = detailService.getDetailsByDataId(dataId);
        if (CollectionUtils.isNotEmpty(details)) {
            throw new RuntimeBusinessException(SystemResponseStatus.E_4005001);
        }
        this.removeById(dataId);
    }

    private QueryWrapper commonQueryPara(final Map map) {
        final QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_del", 0);
        queryWrapper.eq(MapUtils.getString(map, "companyCode") != null, "company_code", MapUtils.getString(map, "companyCode"));
        queryWrapper.like(MapUtils.getString(map, "companyName") != null, "company_name", MapUtils.getString(map, "companyName"));
        return queryWrapper;
    }
}
