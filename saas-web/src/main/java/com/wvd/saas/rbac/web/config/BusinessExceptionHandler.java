package com.wvd.saas.rbac.web.config;

import com.wvd.saas.rbac.web.common.exception.RuntimeBusinessException;
import com.wvd.saas.rbac.web.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BusinessExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(BusinessExceptionHandler.class);

    @ExceptionHandler(RuntimeBusinessException.class)
    @ResponseBody
    public ResponseVo responseCodeExceptionHandler(RuntimeBusinessException runtimeBusinessException) {
        ResponseVo result = new ResponseVo(runtimeBusinessException.getStatus().getCode(), runtimeBusinessException.getStatus().getMessage());
        logger.error("business error||  code: {0}, message:{1}, parameter:{2}", runtimeBusinessException.getStatus().getCode(), runtimeBusinessException.getStatus().getMessage(), runtimeBusinessException.getErrorPara());
        return result;
    }
}
