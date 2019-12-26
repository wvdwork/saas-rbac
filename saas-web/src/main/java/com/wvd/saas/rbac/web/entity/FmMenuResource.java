package com.wvd.saas.rbac.web.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 菜单资源表
 * </p>
 *
 * @author author
 * @since 2019-12-08
 */
@TableName("t_fm_menu_resource")
public class FmMenuResource extends Model<FmMenuResource> {

    private static final long serialVersionUID = 1L;

    /**
     * 非业务主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 菜单ID
     */
    @TableField("parent_id")
    private Long parentId;
    /**
     * 资源名称
     */
    @TableField("resource_name")
    private String resourceName;
    /**
     * 资源类型
     */
    @TableField("resource_type")
    private String resourceType;
    /**
     * 资源路径
     */
    @TableField("resource_url")
    private String resourceUrl;
    /**
     * 方法名称
     */
    @TableField("resource_method")
    private String resourceMethod;
    /**
     * 描述信息
     */
    @TableField("resource_desc")
    private String resourceDesc;
    /**
     * 是否被删除
     */
    @TableField("is_del")
    private Integer isDel;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;
    /**
     * 创建人
     */
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private String createUser;
    /**
     * 最后一次修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Long updateTime;
    /**
     * 最后一次修改人
     */
    @TableField(value = "update_user", fill = FieldFill.UPDATE)
    private String updateUser;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getResourceMethod() {
        return resourceMethod;
    }

    public void setResourceMethod(String resourceMethod) {
        this.resourceMethod = resourceMethod;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "FmMenuResouce{" +
        "id=" + id +
        ", parentId=" + parentId +
        ", resourceName=" + resourceName +
        ", resourceType=" + resourceType +
        ", resourceUrl=" + resourceUrl +
        ", resourceMethod=" + resourceMethod +
        ", resourceDesc=" + resourceDesc +
        ", isDel=" + isDel +
        ", createTime=" + createTime +
        ", createUser=" + createUser +
        ", updateTime=" + updateTime +
        ", updateUser=" + updateUser +
        "}";
    }
}
