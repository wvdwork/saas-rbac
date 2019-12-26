package com.wvd.saas.rbac.web.vo;

import java.io.Serializable;

public class TreeNode implements Serializable {
    private long id ;
    private Long parentId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
