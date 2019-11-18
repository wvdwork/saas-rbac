package com.wvd.saas.rbac.web.controller;

import com.wvd.saas.rbac.web.entity.FmCompany;
import com.wvd.saas.rbac.web.entity.FmOrganization;
import com.wvd.saas.rbac.web.service.IFmCompanyService;
import com.wvd.saas.rbac.web.service.IFmOrganizationService;
import com.wvd.saas.rbac.web.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * <p>
 * 公司信息表 前端控制器
 * </p>
 *
 * @author author
 * @since 2019-11-04
 */
@RestController
@RequestMapping("/organization")
public class FmOrganizationController {
    @Autowired
    private IFmOrganizationService service;

    /**
     * 分页查询
     */
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public ResponseVo selectPage(@RequestParam Map paraMap) {
        return new ResponseVo(service.searchPage(paraMap));
    }

    /**
     * 分页查询
     */
    @RequestMapping(value = "orgs", method = RequestMethod.GET)
    public ResponseVo orgTree(@RequestParam Map paraMap) {
        return new ResponseVo(service.findOrgTree(paraMap));
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseVo addOrg(@RequestBody FmOrganization organization) {
        this.service.save(organization);
        return new ResponseVo();
    }

    @RequestMapping(value = "modified", method = RequestMethod.POST)
    public ResponseVo modified(@RequestBody FmOrganization organization) {
        this.service.updateById(organization);
        return new ResponseVo();
    }

    @RequestMapping(value = "delete/{orgId}", method = RequestMethod.POST)
    public ResponseVo delete(@PathVariable Long orgId) {
        this.service.deleteOrgs(orgId);
        return new ResponseVo();
    }
}
