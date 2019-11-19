package com.wvd.saas.rbac.web.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author author
 * @since 2019-11-10
 */
@TableName("t_fm_user")
public class FmUser extends Model<FmUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 非业务主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户名称
     */
    @TableField("user_name")
    private String userName;
    /**
     * 用户电话
     */
    @TableField("user_phone")
    private String userPhone;
    /**
     * 用户昵称
     */
    @TableField("user_nick_name")
    private String userNickName;
    /**
     * 英文名称
     */
    @TableField("user_en_name")
    private String userEnName;
    /**
     * 用户邮箱
     */
    @TableField("user_mail")
    private String userMail;
    /**
     * 公司ID
     */
    @TableField("company_id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long companyId;
    /**
     * 是否有效
     */
    @TableField("is_active")
    private Integer isActive;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserEnName() {
        return userEnName;
    }

    public void setUserEnName(String userEnName) {
        this.userEnName = userEnName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
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

}
