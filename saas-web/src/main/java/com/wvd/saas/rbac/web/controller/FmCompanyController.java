package com.wvd.saas.rbac.web.controller;

import com.wvd.saas.rbac.web.common.SystemResponseImplStatus;
import com.wvd.saas.rbac.web.entity.FmCompany;
import com.wvd.saas.rbac.web.service.IFmCompanyService;
import com.wvd.saas.rbac.web.vo.ResponseVo;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * <p>
 * 公司信息表 前端控制器
 * </p>
 *
 * @author author
 * @since 2019-11-03
 */
@RestController
@RequestMapping("/company")
public class FmCompanyController {
    @Autowired
    IFmCompanyService companyService;

    @RequestMapping
    public ResponseVo findAll() {
        FmCompany company = companyService.getById(0l);
        return new ResponseVo();
    }

    @RequestMapping(value = "page", method = RequestMethod.GET)
    public ResponseVo selectPage(@RequestParam Map paraMap) {
        return new ResponseVo(companyService.searchPage(paraMap));
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseVo add(@RequestBody FmCompany company) {
        this.companyService.save(company);
        return new ResponseVo();
    }

    @RequestMapping(value = "modify", method = RequestMethod.POST)
    public ResponseVo modify(@RequestBody FmCompany company) {
        this.companyService.updateById(company);
        return new ResponseVo();
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public ResponseVo delete(@PathVariable Long id) {
        this.companyService.removeById(id);
        return new ResponseVo();
    }
}

