package com.wvd.saas.rbac.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wvd.saas.rbac.web.common.SystemResponseStatus;
import com.wvd.saas.rbac.web.common.exception.RuntimeBusinessException;
import com.wvd.saas.rbac.web.entity.FmApplication;
import com.wvd.saas.rbac.web.mapper.FmApplicationMapper;
import com.wvd.saas.rbac.web.service.IFmApplicationService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 项目信息 服务实现类
 * </p>
 *
 * @author author
 * @since 2019-11-10
 */
@Service
public class FmApplicationServiceImpl extends ServiceImpl<FmApplicationMapper, FmApplication> implements IFmApplicationService {
    public IPage<FmApplication> searchPage(Map map) {
        Long current = Long.parseLong(map.get("current").toString());
        Long size = Long.parseLong(map.get("size").toString());
        return this.page(new Page(current, size), commonQueryPara(map));
    }

    public List<FmApplication> list(Map map) {
        return this.list(commonQueryPara(map));
    }

    private QueryWrapper commonQueryPara(final Map map) {
        final QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_del", 0);
        queryWrapper.eq(StringUtils.isNotEmpty(MapUtils.getString(map, "applicationCode")), "application_code", MapUtils.getString(map, "applicationCode"));
        queryWrapper.like(StringUtils.isNotEmpty(MapUtils.getString(map, "applicationName")), "application_name", MapUtils.getString(map, "applicationName"));
        return queryWrapper;
    }

    private QueryWrapper commonQueryPara(String property, Object value) {
        Map map = new HashMap();
        map.put(property, value);
        return this.commonQueryPara(map);
    }

    public boolean save(FmApplication fmApplication) {

        FmApplication existApplication = this.getOne(commonQueryPara("applicationCode", fmApplication.getApplicationCode()));
        if (existApplication != null) {
            throw new RuntimeBusinessException(SystemResponseStatus.E_4001000);
        }
        this.baseMapper.insert(fmApplication);
        return true;
    }
}
