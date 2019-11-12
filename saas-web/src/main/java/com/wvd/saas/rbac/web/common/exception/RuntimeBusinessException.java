package com.wvd.saas.rbac.web.common.exception;


import com.wvd.saas.rbac.web.common.SystemResponseStatus;

public class RuntimeBusinessException extends RuntimeException {
    private SystemResponseStatus status;
    private Object errorPara;

    public RuntimeBusinessException(SystemResponseStatus status) {
        this.status = status;
    }

    public RuntimeBusinessException(SystemResponseStatus status, Object errorPara) {
        this.status = status;
        this.errorPara = errorPara;
    }


    public SystemResponseStatus getStatus() {
        return status;
    }

    public Object getErrorPara() {
        return errorPara;
    }
}
