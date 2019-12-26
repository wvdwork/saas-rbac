package com.wvd.saas.rbac.web.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author author
 * @since 2019-12-03
 */
@TableName("t_fm_menu")
public class FmMenu extends Model<FmMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 非业务主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 菜单名称
     */
    @TableField("menu_name")
    private String menuName;
    /**
     * 父节点ID
     */
    @TableField("parent_id")
    private Long parentId;
    /**
     * 是否叶子节点
     */
    @TableField("is_leaf_node")
    private Integer isLeafNode;
    /**
     * 公司ID
     */
    @TableField("company_id")
    private Long companyId;
    /**
     * 项目ID
     */
    @TableField("application_id")
    private Long applicationId;
    /**
     * 菜单图标url
     */
    private String icon;
    /**
     * 扩展属性，json格式
     */
    @TableField("extend_propeties")
    private String extendPropeties;
    /**
     * 资源路径
     */
    private String path;
    /**
     * 转发路径
     */
    @TableField("redirect_path")
    private String redirectPath;
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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getIsLeafNode() {
        return isLeafNode;
    }

    public void setIsLeafNode(Integer isLeafNode) {
        this.isLeafNode = isLeafNode;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getExtendPropeties() {
        return extendPropeties;
    }

    public void setExtendPropeties(String extendPropeties) {
        this.extendPropeties = extendPropeties;
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
        return "FmMenu{" +
        "id=" + id +
        ", menuName=" + menuName +
        ", parentId=" + parentId +
        ", isLeafNode=" + isLeafNode +
        ", companyId=" + companyId +
        ", applicationId=" + applicationId +
        ", icon=" + icon +
        ", extendPropeties=" + extendPropeties +
        ", path=" + path +
        ", redirectPath=" + redirectPath +
        ", isDel=" + isDel +
        ", createTime=" + createTime +
        ", createUser=" + createUser +
        ", updateTime=" + updateTime +
        ", updateUser=" + updateUser +
        "}";
    }
}
