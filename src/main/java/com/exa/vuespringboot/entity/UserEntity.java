package com.exa.vuespringboot.entity;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String loginName;

    private String realName;

    private String password;

    private String mobile;
    private String email;
    private String identity;
    private String jobTitle;
    private String pId;

	private String op_Pid;
	private Integer op_User_Id;

	public String getOp_Pid() {
		return op_Pid;
	}

	public void setOp_Pid(String op_Pid) {
		this.op_Pid = op_Pid;
	}

	public Integer getOp_User_Id() {
		return op_User_Id;
	}

	public void setOp_User_Id(Integer op_User_Id) {
		this.op_User_Id = op_User_Id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	private Integer certificateTypeId;

    private String certificateNo;

    private Integer sex;

    private Integer isActive;

    private String description;

    private Date createdTime;

    private Date updatedTime;
    
    private String certificateName;
    
    private String organizationName;
    
    private Integer organizationId;
    private Integer organizationType;
    private Integer roleId;
    
	private String oldPwd;
	
	private String newPwd;
	
	private String confirmPwd;

	public boolean Success;

	//0:本所民警,1:本所辅警,2:他所民警
	public Integer type;

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public Integer getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(Integer organizationType) {
		this.organizationType = organizationType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public Integer getCertificateTypeId() {
		return certificateTypeId;
	}

	public void setCertificateTypeId(Integer certificateTypeId) {
		this.certificateTypeId = certificateTypeId;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", loginName=" + loginName + ", realName=" + realName + ", password=" + password
				+ ", mobile=" + mobile + ", email=" + email + ", identity=" + identity + ", jobTitle=" + jobTitle
				+ ", certificateTypeId=" + certificateTypeId + ", certificateNo=" + certificateNo + ", sex=" + sex
				+ ", isActive=" + isActive + ", description=" + description + ", createdTime=" + createdTime
				+ ", updatedTime=" + updatedTime + ", certificateName=" + certificateName + ", organizationName="
				+ organizationName + ", organizationId=" + organizationId + ", organizationType=" + organizationType
				+ ", roleId=" + roleId + ", oldPwd=" + oldPwd + ", newPwd=" + newPwd + ", confirmPwd=" + confirmPwd
				+ ", Success=" + Success + ", type=" + type + "]";
	}
	
	
    
}