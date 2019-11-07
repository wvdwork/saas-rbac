package com.wvd.saas.rbac.web.vo;

import com.wvd.saas.rbac.web.common.SystemResponseStatus;

public class ResponseVo {
    private boolean success;
    private String message;
    private String code;
    private Object data;
    private SystemResponseStatus systemResponseStatus;

    public ResponseVo() {
        this.code = "S200000";
        this.success = true;
        this.message = "success";
    }

    public ResponseVo(Object _data) {
        this();
        this.data = _data;
    }

    public ResponseVo(String code, String message) {
        this.message = message;
        this.code = code;
        if (code.startsWith("S")) {
            this.success = true;
        } else {
            this.success = false;
        }
    }

    public ResponseVo(String code) {
        this("", code);

    }

    public ResponseVo(boolean success, String message, String code) {
        this.message = message;
        this.code = code;
        this.success = success;
    }

    public ResponseVo(String message, String code, Object data) {
        this(message, code);
        this.data = data;
    }

    public ResponseVo(boolean success, String message, String code, Object data) {
        this(success, message, code);
        this.data = data;
    }

    public ResponseVo(SystemResponseStatus systemResponseStatus) {
        this(systemResponseStatus.getCode(), systemResponseStatus.getMessage());
    }

    public void setSystemResponseStatus(SystemResponseStatus systemResponseStatus) {
        this.setCode(systemResponseStatus.getCode());
        this.setMessage(systemResponseStatus.getMessage());
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        if (code.startsWith("S")) {
            this.success = true;
        } else {
            this.success = false;
        }
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
