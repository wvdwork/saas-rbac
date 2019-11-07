package com.wvd.saas.rbac.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wvd.saas.rbac.web.entity.FmCompany;
import com.wvd.saas.rbac.web.mapper.FmCompanyMapper;
import com.wvd.saas.rbac.web.service.IFmCompanyService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 公司信息表 服务实现类
 * </p>
 *
 * @author author
 * @since 2019-11-03
 */
@Service
public class FmCompanyServiceImpl extends ServiceImpl<FmCompanyMapper, FmCompany> implements IFmCompanyService {

    public IPage<FmCompany> searchPage(Map map) {
        Long current = Long.parseLong(map.get("current").toString());
        Long size = Long.parseLong(map.get("size").toString());
        Page page = new Page(current, size);
        Wrapper wrapper = commonQueryPara(map);
        return this.page(page, wrapper);
    }

    private QueryWrapper commonQueryPara(final Map map) {
        final QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_del", 0);
        queryWrapper.eq(MapUtils.getString(map, "companyCode") != null, "company_code", MapUtils.getString(map, "companyCode"));
        queryWrapper.like(MapUtils.getString(map, "companyName") != null, "company_name", MapUtils.getString(map, "companyName"));
        return queryWrapper;
    }
}
