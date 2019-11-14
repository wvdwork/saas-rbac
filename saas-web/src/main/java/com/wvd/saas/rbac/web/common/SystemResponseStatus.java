package com.wvd.saas.rbac.web.common;

public class SystemResponseStatus {
    public final static SystemResponseStatus S_2000000 = newStatus("S_2000000", "成功");


    public final static SystemResponseStatus E_4001000 = newStatus("E_4001000", "项目已存在");

    public final static SystemResponseStatus E_4002000 = newStatus("E_4002000", "登录账号已存在");

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
