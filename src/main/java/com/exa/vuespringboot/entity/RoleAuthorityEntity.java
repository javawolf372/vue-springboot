package com.exa.vuespringboot.entity;

import java.io.Serializable;

public class RoleAuthorityEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private Long roleId;
    
    private Long authorityId;
    
    public RoleAuthorityEntity(){}

    public RoleAuthorityEntity(Long authorityId, Long roleId) {
    	this.roleId = roleId;
    	this.authorityId = authorityId;
	}

	@Override
	public String toString() {
		return "RoleAuthorityEntity [roleId=" + roleId + ", authorityId=" + authorityId + "]";
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Long authorityId) {
		this.authorityId = authorityId;
	}

}