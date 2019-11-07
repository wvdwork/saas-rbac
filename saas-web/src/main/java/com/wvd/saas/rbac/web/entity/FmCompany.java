package com.wvd.saas.rbac.web.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 公司信息表
 * </p>
 *
 * @author author
 * @since 2019-11-03
 */
@TableName("t_fm_company")
public class FmCompany extends Model<FmCompany> {

    private static final long serialVersionUID = 1L;

    /**
     * 非业务主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 公司编码
     */
    @TableField("company_code")
    private String companyCode;
    /**
     * 公司名称
     */
    @TableField("company_name")
    private String companyName;
    /**
     * 公司简介
     */
    @TableField("company_profile")
    private String companyProfile;
    /**
     * 企业法人
     */
    @TableField("company_legal")
    private String companyLegal;
    /**
     * 公司电话
     */
    @TableField("company_phone")
    private String companyPhone;
    /**
     * 公司邮箱
     */
    @TableField("company_mail")
    private String companyMail;
    /**
     * 公司logo地址
     */
    @TableField("company_logo_url")
    private String companyLogoUrl;
    /**
     * 公司显示名称
     */
    @TableField("company_dis_name")
    private String companyDisName;
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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile;
    }

    public String getCompanyLegal() {
        return companyLegal;
    }

    public void setCompanyLegal(String companyLegal) {
        this.companyLegal = companyLegal;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyMail() {
        return companyMail;
    }

    public void setCompanyMail(String companyMail) {
        this.companyMail = companyMail;
    }

    public String getCompanyLogoUrl() {
        return companyLogoUrl;
    }

    public void setCompanyLogoUrl(String companyLogoUrl) {
        this.companyLogoUrl = companyLogoUrl;
    }

    public String getCompanyDisName() {
        return companyDisName;
    }

    public void setCompanyDisName(String companyDisName) {
        this.companyDisName = companyDisName;
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

    @Override
    public String toString() {
        return "FmCompany{" +
        "id=" + id +
        ", companyCode=" + companyCode +
        ", companyName=" + companyName +
        ", companyProfile=" + companyProfile +
        ", companyLegal=" + companyLegal +
        ", companyPhone=" + companyPhone +
        ", companyMail=" + companyMail +
        ", companyLogoUrl=" + companyLogoUrl +
        ", companyDisName=" + companyDisName +
        ", isActive=" + isActive +
        ", isDel=" + isDel +
        ", createTime=" + createTime +
        ", createUser=" + createUser +
        ", updateTime=" + updateTime +
        ", updateUser=" + updateUser +
        "}";
    }
}
