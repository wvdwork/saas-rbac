package com.wvd.saas.rbac.web.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * <p>
 * 用户密码表
 * </p>
 *
 * @author author
 * @since 2019-11-10
 */
@TableName("t_fm_password")
public class FmPassword extends Model<FmPassword> {

    private static final long serialVersionUID = 1L;

    /**
     * 非业务主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户ID
     */
    @TableField("user_id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;
    /**
     * 帐号ID
     */
    @TableField("account_id")
    private String accountId;
    /**
     * 用户密码
     */
    @TableField("user_password")
    private String userPassword;
    /**
     * 密码过期时间
     */
    @TableField("password_expired_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long passwordExpiredTime;
    /**
     * 登陆错误次数
     */
    @TableField("login_error_count")
    private Integer loginErrorCount;
    /**
     * 登录错误控制失效时间
     */
    @TableField("login_error_expired_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long loginErrorExpiredTime;
    /**
     * 是否被锁定
     */
    @TableField("is_locked")
    private Integer isLocked;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Long getPasswordExpiredTime() {
        return passwordExpiredTime;
    }

    public void setPasswordExpiredTime(Long passwordExpiredTime) {
        this.passwordExpiredTime = passwordExpiredTime;
    }

    public Integer getLoginErrorCount() {
        return loginErrorCount;
    }

    public void setLoginErrorCount(Integer loginErrorCount) {
        this.loginErrorCount = loginErrorCount;
    }

    public Long getLoginErrorExpiredTime() {
        return loginErrorExpiredTime;
    }

    public void setLoginErrorExpiredTime(Long loginErrorExpiredTime) {
        this.loginErrorExpiredTime = loginErrorExpiredTime;
    }

    public Integer getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Integer isLocked) {
        this.isLocked = isLocked;
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
