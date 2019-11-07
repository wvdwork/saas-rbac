package com.wvd.saas.rbac.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wvd.saas.rbac.web.entity.FmOrganization;
import com.wvd.saas.rbac.web.mapper.FmOrganizationMapper;
import com.wvd.saas.rbac.web.service.IFmOrganizationService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 组织表 服务实现类
 * </p>
 *
 * @author author
 * @since 2019-11-07
 */
@Service
public class FmOrganizationServiceImpl extends ServiceImpl<FmOrganizationMapper, FmOrganization> implements IFmOrganizationService {
    public IPage<FmOrganization> searchPage(Map map) {
        Long current = Long.parseLong(map.get("current").toString());
        Long size = Long.parseLong(map.get("size").toString());
        Page page = new Page(current, size);
        Wrapper wrapper = commonQueryPara(map);
        return this.page(page, wrapper);
    }

    private QueryWrapper commonQueryPara(final Map map) {
        final QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_del", 0);
        queryWrapper.eq(MapUtils.getString(map, "orgCode") != null, "org_code", MapUtils.getString(map, "orgCode"));
        queryWrapper.like(MapUtils.getString(map, "companyName") != null, "company_name", MapUtils.getString(map, "companyName"));
        return queryWrapper;
    }
}
