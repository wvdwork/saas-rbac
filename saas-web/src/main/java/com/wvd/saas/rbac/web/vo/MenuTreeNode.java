package com.wvd.saas.rbac.web.vo;

public class MenuTreeNode extends TreeNode {
    private String menuName;
    private String icon;
    private String extendProperties;
    private String path;
    private String redirectPath;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getExtendProperties() {
        return extendProperties;
    }

    public void setExtendProperties(String extendProperties) {
        this.extendProperties = extendProperties;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRedirectPath() {
        return redirectPath;
    }

    public void setRedirectPath(String redirectPath) {
        this.redirectPath = redirectPath;
    }
}
