package com.wvd.saas.rbac.web.controller;

import com.wvd.saas.rbac.web.dto.UserAddDto;
import com.wvd.saas.rbac.web.entity.FmApplication;
import com.wvd.saas.rbac.web.entity.FmUser;
import com.wvd.saas.rbac.web.service.IFmUserAccountService;
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

    @Autowired
    IFmUserAccountService accountService;

    @RequestMapping(value = "page", method = RequestMethod.GET)
    public ResponseVo selectPage(@RequestParam Map paraMap) {
        return new ResponseVo(service.searchPage(paraMap));
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseVo addUser(@RequestBody UserAddDto user) {
        this.service.save(user);
        return new ResponseVo();
    }

    @RequestMapping(value = "modify", method = RequestMethod.POST)
    public ResponseVo modified(@RequestBody FmUser fmUser) {
        this.service.updateById(fmUser);
        return new ResponseVo();
    }

    @RequestMapping(value = "{userId}/account/list", method = RequestMethod.POST)
    public ResponseVo accountList(@PathVariable Long userId) {
        return new ResponseVo(this.accountService.getByUserId(userId));
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseVo delete(@PathVariable Long userId) {
        FmUser fmUser = new FmUser();
        fmUser.setId(userId);
        fmUser.setIsActive(0);
        this.service.updateById(fmUser);
        return new ResponseVo();
    }

    @RequestMapping(value = "{userId}/organization/tree", method = RequestMethod.POST)
    public ResponseVo userOrganization(@PathVariable Long userId) {
        return new ResponseVo(this.service.userOrgTreeSearch(userId));
    }

    @RequestMapping(value = "org/{userId}/{orgId}", method = RequestMethod.POST)
    public ResponseVo saveUserOrganization(@PathVariable Long userId, @PathVariable Long orgId) {
        this.service.saveUserOrg(userId, orgId);
        return new ResponseVo();
    }
}
