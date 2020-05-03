package com.wvd.saas.rbac.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wvd.saas.rbac.web.entity.FmMenuResource;
import com.wvd.saas.rbac.web.mapper.FmMenuResourceMapper;
import com.wvd.saas.rbac.web.service.IFmMenuResouceService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单资源表 服务实现类
 * </p>
 *
 * @author author
 * @since 2019-12-08
 */
@Service
public class FmMenuResouceServiceImpl extends ServiceImpl<FmMenuResourceMapper, FmMenuResource> implements IFmMenuResouceService {

    public List<FmMenuResource> list(Map map) {
        QueryWrapper wrapper = commonQueryPara(map);
        wrapper.orderByDesc("update_time", "create_time");
        return this.list(wrapper);
    }

    private QueryWrapper commonQueryPara(final Map map) {
        final QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_del", 0);
        queryWrapper.eq(StringUtils.isNotEmpty(MapUtils.getString(map, "menuId")), "menu_id", MapUtils.getString(map, "menuId"));
        return queryWrapper;
    }
}
