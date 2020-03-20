package com.exa.vuespringboot.entity;

import java.io.Serializable;
import java.util.Date;

public class OrganizationEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;

    private String name;

    private String type;
    
    private String address;
    
    private String telephone;
    
    private String postcode;
    private Date createdTime;
    
    private Date updatedTime;
    
    private Integer parentId; //上级部门
	private String pid;//上级部门ID

	private String orgCode;
	private String orgAlias;
	private String orgRep;
	private String orgStatus;
	private String proName;

	private Integer op_User_Id; //当前操作人id

	private String op_pid; //当前操作人员所在单位PID

	public String getOp_pid() {
		return op_pid;
	}

	public void setOp_pid(String op_pid) {
		this.op_pid = op_pid;
	}

	public Integer getOp_User_Id() {
		return op_User_Id;
	}

	public void setOp_User_Id(Integer op_User_Id) {
		this.op_User_Id = op_User_Id;
	}

	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
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
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgAlias() {
		return orgAlias;
	}
	public void setOrgAlias(String orgAlias) {
		this.orgAlias = orgAlias;
	}
	public String getOrgRep() {
		return orgRep;
	}
	public void setOrgRep(String orgRep) {
		this.orgRep = orgRep;
	}
	public String getOrgStatus() {
		return orgStatus;
	}
	public void setOrgStatus(String orgStatus) {
		this.orgStatus = orgStatus;
	}
	@Override
	public String toString() {
		return "OrganizationEntity [id=" + id + ", name=" + name + ", type=" + type + ", address=" + address
				+ ", telephone=" + telephone + ", postcode=" + postcode + ", createdTime=" + createdTime
				+ ", updatedTime=" + updatedTime+ ", pid=" + pid + ", parentId=" + parentId + ", orgCode=" + orgCode + ", orgAlias="
				+ orgAlias + ", orgRep=" + orgRep + ", orgStatus=" + orgStatus + ", proName=" + proName + "]";
	}


    
}