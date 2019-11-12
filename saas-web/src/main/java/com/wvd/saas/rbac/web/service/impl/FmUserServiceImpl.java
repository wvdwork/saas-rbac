package com.wvd.saas.rbac.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wvd.saas.rbac.web.dto.UserAddDto;
import com.wvd.saas.rbac.web.entity.FmUser;
import com.wvd.saas.rbac.web.mapper.FmUserMapper;
import com.wvd.saas.rbac.web.service.IFmUserService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author author
 * @since 2019-11-10
 */
@Service
public class FmUserServiceImpl extends ServiceImpl<FmUserMapper, FmUser> implements IFmUserService {

    @Override
    public IPage<FmUser> searchPage(Map map) {
        Long current = Long.parseLong(map.get("current").toString());
        Long size = Long.parseLong(map.get("size").toString());
        return this.page(new Page(current, size), commonQueryPara(map));
    }

    public void save(UserAddDto userAddDto) {

        this.getOne(commonQueryPara("userName", userAddDto.getUserName()));
        FmUser fmUser = new FmUser();
        BeanUtils.copyProperties(userAddDto, fmUser);



    }

    private QueryWrapper commonQueryPara(final Map map) {
        final QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("is_del", 0);
        queryWrapper.like(StringUtils.isNotEmpty(MapUtils.getString(map, "userName")), "user_name", MapUtils.getString(map, "userName"));
        queryWrapper.like(StringUtils.isNotEmpty(MapUtils.getString(map, "userNickName")), "user_nick_name", MapUtils.getString(map, "userNickName"));
        return queryWrapper;
    }

    private QueryWrapper commonQueryPara(String property, Object value) {
        Map map = new HashMap();
        map.put(property, value);
        return this.commonQueryPara(map);
    }
}
