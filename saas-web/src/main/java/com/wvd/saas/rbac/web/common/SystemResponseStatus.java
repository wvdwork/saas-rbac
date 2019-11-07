package com.wvd.saas.rbac.web.common;

public class SystemResponseStatus {
    public final static SystemResponseStatus S_20000 = newStatus("S_20000", "成功");

    private String code;
    private String message;
    protected static SystemResponseStatus newStatus(String code, String message) {
        return new SystemResponseStatus(code, message);
    }

    public SystemResponseStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
