package com.exa.vuespringboot.entity;

import java.io.Serializable;
import java.util.Date;

public class RoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String ROLE_SUPER_ADMIN = "系统维护人员";
    public static final String ROLE_ADMIN = "管理员";
    public static final String ROLE_AREA_USER = "办案场所人员";
    public static final String ROLE_CASE_USER = "办案人员";
    public static final String ROLE_LEADER = "公安领导";
    public static final String ROLE_LAW = "法制人员";
    public static final String ROLE_999 = "999体检人员";
    public static final String ROLE_COMBINE = "合成作战人员";
    public static final int DATA_AUTH_NULL = -1;//无权限
    public static final int DATA_AUTH_SELF = 0;// 0本人
    public static final int DATA_AUTH_SELFAREA = 1;// 1本办案场所
    public static final int DATA_AUTH_DOWN_CASCADEAREA = 2;// 2本办案场所及下级办案场所
    public static final int DATA_AUTH_UP_CASCADEAREA = 3;// 3上级办案场所及其下级办案场所
    public static final int DATA_AUTH_FULL = 4;// 4全部
    public static final int DATA_AUTH_SELFORG = 5;// 5本部门
    public static final int DATA_AUTH_DOWN_CASCADEORG = 6;// 6本部门及下级部门
    public static final int DATA_AUTH_UP_CASCADEORG = 7;// 7上级部门及其下级部门

    private Integer id;
    private String name;
    private String description;
    private int bacsDataAuth;
    private int sacwDataAuth;
    private int jzglDataAuth;
    private int jxkpDataAuth;
    private int slaDataAuth;
    private int zhglDataAuth;
    private int bacsConfigure;
    private int sacwConfigure;
    private int jzglConfigure;
    private int jxkpConfigure;
    private int slaConfigure;
    private int xtConfigure;
    private Date createdTime;
    private Date updatedTime;

    private Boolean isSelect = false;

    public int getZhglDataAuth() {
        return zhglDataAuth;
    }

    public void setZhglDataAuth(int zhglDataAuth) {
        this.zhglDataAuth = zhglDataAuth;
    }

    public int getBacsConfigure() {
        return bacsConfigure;
    }

    public void setBacsConfigure(int bacsConfigure) {
        this.bacsConfigure = bacsConfigure;
    }

    public int getSacwConfigure() {
        return sacwConfigure;
    }

    public void setSacwConfigure(int sacwConfigure) {
        this.sacwConfigure = sacwConfigure;
    }

    public int getJzglConfigure() {
        return jzglConfigure;
    }

    public void setJzglConfigure(int jzglConfigure) {
        this.jzglConfigure = jzglConfigure;
    }

    public int getJxkpConfigure() {
        return jxkpConfigure;
    }

    public void setJxkpConfigure(int jxkpConfigure) {
        this.jxkpConfigure = jxkpConfigure;
    }

    public int getSlaConfigure() {
        return slaConfigure;
    }

    public void setSlaConfigure(int slaConfigure) {
        this.slaConfigure = slaConfigure;
    }

    public int getXtConfigure() {
        return xtConfigure;
    }

    public void setXtConfigure(int xtConfigure) {
        this.xtConfigure = xtConfigure;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBacsDataAuth() {
        return bacsDataAuth;
    }

    public void setBacsDataAuth(int bacsDataAuth) {
        this.bacsDataAuth = bacsDataAuth;
    }

    public int getSacwDataAuth() {
        return sacwDataAuth;
    }

    public void setSacwDataAuth(int sacwDataAuth) {
        this.sacwDataAuth = sacwDataAuth;
    }

    public int getJzglDataAuth() {
        return jzglDataAuth;
    }

    public void setJzglDataAuth(int jzglDataAuth) {
        this.jzglDataAuth = jzglDataAuth;
    }

    public int getJxkpDataAuth() {
        return jxkpDataAuth;
    }

    public void setJxkpDataAuth(int jxkpDataAuth) {
        this.jxkpDataAuth = jxkpDataAuth;
    }

    public int getSlaDataAuth() {
        return slaDataAuth;
    }

    public void setSlaDataAuth(int slaDataAuth) {
        this.slaDataAuth = slaDataAuth;
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

    public Boolean getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(Boolean select) {
        isSelect = select;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", bacsDataAuth=" + bacsDataAuth +
                ", sacwDataAuth=" + sacwDataAuth +
                ", jzglDataAuth=" + jzglDataAuth +
                ", jxkpDataAuth=" + jxkpDataAuth +
                ", slaDataAuth=" + slaDataAuth +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", isSelect=" + isSelect +
                '}';
    }
}