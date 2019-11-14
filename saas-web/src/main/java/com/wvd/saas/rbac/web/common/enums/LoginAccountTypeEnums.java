package com.wvd.saas.rbac.web.common.enums;

public enum  LoginAccountTypeEnums {
    ACCOUNT("account");

    private String code;
    LoginAccountTypeEnums(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
