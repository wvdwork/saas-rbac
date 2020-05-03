package com.wvd.saas.rbac.web.controller;


import com.wvd.saas.rbac.web.entity.FmMenu;
import com.wvd.saas.rbac.web.entity.FmMenuResource;
import com.wvd.saas.rbac.web.entity.FmRole;
import com.wvd.saas.rbac.web.service.IFmMenuResouceService;
import com.wvd.saas.rbac.web.service.IFmMenuService;
import com.wvd.saas.rbac.web.service.IFmRoleService;
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
public class FmMenuController {

    @Autowired
    IFmMenuService service;

    @Autowired
    IFmMenuResouceService resouceService;

    @RequestMapping(value = "add/{menuId}", method = RequestMethod.POST)
    public ResponseVo add(@PathVariable Long menuId) {
        return new ResponseVo(service.addMenu(menuId));
    }

    @RequestMapping(value = "modify", method = RequestMethod.POST)
    public ResponseVo modified(@RequestBody FmMenu menu) {
        service.updateById(menu);
        return new ResponseVo(service.getById(menu.getId()));
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public ResponseVo delete(@PathVariable Long id) {
        service.removeById(id);
        return new ResponseVo();
    }

    @RequestMapping(value = "find/{menuId}", method = RequestMethod.GET)
    public ResponseVo findById(@PathVariable Long menuId) {
        return new ResponseVo(service.getById(menuId));
    }

    @RequestMapping(value = "tree/{applicationId}", method = RequestMethod.GET)
    public ResponseVo tree(@PathVariable Long applicationId) {
        return new ResponseVo(service.treeByAppId(applicationId));
    }

    @RequestMapping(value = "resource/{menuId}", method = RequestMethod.GET)
    public ResponseVo resourceList(@PathVariable Long menuId) {
        Map paraMap = new HashMap();
        paraMap.put("menuId", menuId);
        return new ResponseVo(resouceService.list(paraMap));
    }

    @RequestMapping(value = "resource/add", method = RequestMethod.POST)
    public ResponseVo addResource(@RequestBody FmMenuResource resource) {
        return new ResponseVo(resouceService.save(resource));
    }

    @RequestMapping(value = "resource/modify", method = RequestMethod.POST)
    public ResponseVo modifiedResource(@RequestBody FmMenuResource resource) {
        resouceService.updateById(resource);
        return new ResponseVo();
    }

    @RequestMapping(value = "resource/delete/{id}", method = RequestMethod.POST)
    public ResponseVo deleteResource(@PathVariable Long id) {
        resouceService.removeById(id);
        return new ResponseVo();
    }
}

