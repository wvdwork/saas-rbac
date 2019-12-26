package com.wvd.saas.rbac.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wvd.saas.rbac.web.entity.FmCompany;
import com.wvd.saas.rbac.web.entity.FmData;
import com.wvd.saas.rbac.web.entity.FmDataDetail;
import com.wvd.saas.rbac.web.mapper.FmDataDetailMapper;
import com.wvd.saas.rbac.web.service.IFmDataDetailService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据主明细表 服务实现类
 * </p>
 *
 * @author author
 * @since 2019-12-09
 */
@Service
public class FmDataDetailServiceImpl extends ServiceImpl<FmDataDetailMapper, FmDataDetail> implements IFmDataDetailService {
    public IPage<FmDataDetail> searchPage(Map map) {
        Long current = Long.parseLong(map.get("current").toString());
        Long size = Long.parseLong(map.get("size").toString());
        Page page = new Page(current, size);
        QueryWrapper wrapper = commonQueryPara(map);
        wrapper.orderByDesc("create_time");
        return this.page(page, wrapper);
    }

    public List<FmDataDetail> getDetailsByDataId(Long dataId) {
        Map paraMap = new HashMap();
        paraMap.put("dataId", dataId);
        return this.list(commonQueryPara(paraMap));
    }

    private QueryWrapper commonQueryPara(final Map map) {
        final QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_del", 0);
        queryWrapper.eq(MapUtils.getString(map, "dataId") != null, "data_id", MapUtils.getString(map, "dataId"));
        return queryWrapper;
    }
}
