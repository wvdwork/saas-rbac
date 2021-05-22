package com.wvd.saas.rbac.web.controller.out;


import com.wvd.saas.rbac.web.entity.FmMenu;
import com.wvd.saas.rbac.web.entity.FmMenuResource;
import com.wvd.saas.rbac.web.service.IFmMenuResouceService;
import com.wvd.saas.rbac.web.service.IFmMenuService;
import com.wvd.saas.rbac.web.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author author
 * @since 2019-11-23
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    IFmMenuService service;

    @Autowired
    IFmMenuResouceService resouceService;

    @RequestMapping(value = "application/{applicationId}", method = RequestMethod.GET)
    public ResponseVo add(@PathVariable Long applicationId) {
        return new ResponseVo(service.findByApplication(applicationId));
    }
}

