package com.wvd.saas.rbac.web.controller;


import com.wvd.saas.rbac.web.entity.FmRole;
import com.wvd.saas.rbac.web.service.IFmRoleService;
import com.wvd.saas.rbac.web.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author author
 * @since 2019-11-23
 */
@RestController
@RequestMapping("/role")
public class FmRoleController {

    @Autowired
    IFmRoleService service;

    @RequestMapping(value = "page", method = RequestMethod.GET)
    public ResponseVo selectPage(@RequestParam Map paraMap) {
        return new ResponseVo(service.searchPage(paraMap));
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseVo add(@RequestBody FmRole role) {
        service.save(role);
        return new ResponseVo();
    }

    @RequestMapping(value = "modify", method = RequestMethod.POST)
    public ResponseVo modified(@RequestBody FmRole role) {
        this.service.updateById(role);
        return new ResponseVo();
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public ResponseVo delete(@PathVariable Long id) {
        this.service.removeById(id);
        return new ResponseVo();
    }
}

