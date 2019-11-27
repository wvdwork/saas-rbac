package com.wvd.saas.rbac.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wvd.saas.rbac.web.entity.FmRole;
import com.wvd.saas.rbac.web.entity.FmUser;
import com.wvd.saas.rbac.web.mapper.FmRoleMapper;
import com.wvd.saas.rbac.web.service.IFmRoleService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author author
 * @since 2019-11-23
 */
@Service
public class FmRoleServiceImpl extends ServiceImpl<FmRoleMapper, FmRole> implements IFmRoleService {
    @Override
    public IPage<FmRole> searchPage(Map map) {
        Long current = MapUtils.getLong(map, "current", 1l) ;
        Long size = MapUtils.getLong(map, "size", 10l) ;
        return this.page(new Page(current, size), commonQueryPara(map));
    }

    private QueryWrapper commonQueryPara(final Map map) {
        final QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_del", 0);
        queryWrapper.like(StringUtils.isNotEmpty(MapUtils.getString(map, "roleName")), "role_name", MapUtils.getString(map, "roleName"));
        queryWrapper.eq(StringUtils.isNotEmpty(MapUtils.getString(map, "applicationId")), "application_id", MapUtils.getString(map, "applicationId"));
        return queryWrapper;
    }
}
