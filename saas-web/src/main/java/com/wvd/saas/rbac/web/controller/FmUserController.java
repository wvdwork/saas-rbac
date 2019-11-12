package com.wvd.saas.rbac.web.controller;

import com.wvd.saas.rbac.web.dto.UserAddDto;
import com.wvd.saas.rbac.web.entity.FmUser;
import com.wvd.saas.rbac.web.service.IFmUserService;
import com.wvd.saas.rbac.web.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("user")
public class FmUserController {
    @Autowired
    IFmUserService service;

    @RequestMapping(value = "page", method = RequestMethod.GET)
    public ResponseVo selectPage(@RequestParam Map paraMap) {
        return new ResponseVo(service.searchPage(paraMap));
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseVo addUser(@RequestBody UserAddDto user) {
        this.service.save(user);
        return new ResponseVo();
    }
}
