package com.exa.vuespringboot.entity;

import java.util.Date;

public class AreaEntity implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -4783107711681656029L;
	
	public static final String INSERT_TYPE = "add";
	public static final String EDIT_TYPE = "edit";
	public static final String DELETE_TYPE = "delete";
	public static final String RMI_TYPE = "rmi";
	public static final String UPLOAD_TYPE = "upload";
	public static final String DOWNLOAD_TYPE = "download";
	public static final String OTHER_TYPE = "other";

	private Integer id;

    private String name;

    private String type;

    private String description;

    private Integer organizationId;

    private String address;

    private String telephone;

    private String postcode;

    private String geoCoord;

    private Date createdTime;

    private Date updatedTime;
    private String organizationName;

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

    @Override
	public String toString() {
		return "AreaEntity [id=" + id + ", name=" + name + ", type=" + type + ", description=" + description
				+ ", organizationId=" + organizationId + ", address=" + address + ", telephone=" + telephone
				+ ", postcode=" + postcode + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime
				+ ", organizationName=" + organizationName + "]";
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Integer getId() {
        return id;
    }

    public String getGeoCoord() {
        return geoCoord;
    }

    public void setGeoCoord(String geoCoord) {
        this.geoCoord = geoCoord;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
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
}