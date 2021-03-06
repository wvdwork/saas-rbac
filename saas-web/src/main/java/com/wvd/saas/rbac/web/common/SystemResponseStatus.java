package com.wvd.saas.rbac.web.common;

public class SystemResponseStatus {
    public final static SystemResponseStatus S_2000000 = newStatus("S_2000000", "成功");


    public final static SystemResponseStatus E_4001000 = newStatus("E_4001000", "项目已存在");
    public final static SystemResponseStatus E_4003000 = newStatus("E_4003000", "存在子组织，不能删除!");

    public final static SystemResponseStatus E_4002000 = newStatus("E_4002000", "登录账号已存在");

    public final static SystemResponseStatus E_4004000 = newStatus("E_4004000", "存在子菜单, 不能删除!");
    public final static SystemResponseStatus E_4004001 = newStatus("E_4004001", "根节点不能删除!");

    public final static SystemResponseStatus E_4005001 = newStatus("E_4005001", "存在明细数据，不能删除!");

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
