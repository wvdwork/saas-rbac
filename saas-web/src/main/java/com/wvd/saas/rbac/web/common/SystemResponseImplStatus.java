package com.wvd.saas.rbac.web.common;

public class SystemResponseImplStatus extends SystemResponseStatus {
    public SystemResponseImplStatus(String code, String message) {
        super(code, message);
    }

    public final static SystemResponseStatus S_40000 = newStatus("S_40000", "网络成功");
}
