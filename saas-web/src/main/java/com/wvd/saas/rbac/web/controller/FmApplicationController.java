package com.wvd.saas.rbac.web.controller;

import com.wvd.saas.rbac.web.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wvd.saas.rbac.web.service.IFmApplicationService;
import com.wvd.saas.rbac.web.entity.FmApplication;

import java.util.Map;


/**
 * <p>
 * 项目信息 前端控制器
 * </p>
 *
 * @author author
 * @since 2019-11-10
 */
@RestController
@RequestMapping("/application")
public class FmApplicationController  {
    @Autowired
    private IFmApplicationService service;

    @RequestMapping(value = "page", method = RequestMethod.GET)
    public ResponseVo selectPage(@RequestParam Map paraMap) {
        return new ResponseVo(service.searchPage(paraMap));
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseVo selectList(@RequestParam Map paraMap) {
        return new ResponseVo(service.list(paraMap));
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseVo addApp(@RequestBody FmApplication application) {
        this.service.save(application);
        return new ResponseVo();
    }

    @RequestMapping(value = "modify", method = RequestMethod.POST)
    public ResponseVo modified(@RequestBody FmApplication application) {
        this.service.updateById(application);
        return new ResponseVo();
    }
}
