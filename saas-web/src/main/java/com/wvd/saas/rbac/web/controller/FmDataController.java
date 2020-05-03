package com.wvd.saas.rbac.web.controller;


import com.wvd.saas.rbac.web.entity.FmData;
import com.wvd.saas.rbac.web.entity.FmDataDetail;
import com.wvd.saas.rbac.web.entity.FmMenu;
import com.wvd.saas.rbac.web.entity.FmMenuResource;
import com.wvd.saas.rbac.web.service.IFmDataDetailService;
import com.wvd.saas.rbac.web.service.IFmDataService;
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
@RequestMapping("/data")
public class FmDataController {

    @Autowired
    IFmDataService service;

    @Autowired
    IFmDataDetailService detailService;

    @RequestMapping(value = "page", method = RequestMethod.GET)
    public ResponseVo selectPage(@RequestParam Map paraMap) {
        return new ResponseVo(service.searchPage(paraMap));
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseVo add(@RequestBody FmData data) {
        this.service.save(data);
        return new ResponseVo();
    }

    @RequestMapping(value = "modify", method = RequestMethod.POST)
    public ResponseVo modified(@RequestBody FmData data) {
        this.service.updateById(data);
        return new ResponseVo();
    }

    @RequestMapping(value = "delete/{dataId}", method = RequestMethod.POST)
    public ResponseVo delete(@PathVariable Long dataId) {
        this.service.deleteData(dataId);
        return new ResponseVo();
    }

    @RequestMapping(value = "detail/page", method = RequestMethod.GET)
    public ResponseVo selectDetailPage(@RequestParam Map paraMap) {
        return new ResponseVo(detailService.searchPage(paraMap));
    }

    @RequestMapping(value = "detail/add", method = RequestMethod.POST)
    public ResponseVo detailAdd(@RequestBody FmDataDetail fmDataDetail) {
        this.detailService.save(fmDataDetail);
        return new ResponseVo();
    }

    @RequestMapping(value = "detail/modify", method = RequestMethod.POST)
    public ResponseVo detailModified(@RequestBody FmDataDetail fmDataDetail) {
        this.detailService.updateById(fmDataDetail);
        return new ResponseVo();
    }

    @RequestMapping(value = "detail/delete/{dataId}", method = RequestMethod.POST)
    public ResponseVo detailDelete(@PathVariable Long detailId) {
        this.detailService.removeById(detailId);
        return new ResponseVo();
    }
}

