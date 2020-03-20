package com.exa.vuespringboot.form;

import com.exa.vuespringboot.entity.AuthorityEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AuthorityForm implements Serializable {
    /**
     * 具体权限   表单实体类
     */
    private static final long serialVersionUID = 4891058860152506841L;
    private Long id;
    private String title;            //权限名称
    private String englishTitle;     //英文名称
    private String description;      //描述
    /**
     * 0:首页大图标
     * 1:菜单大标题
     * 2:菜单小标题按钮
     * 3:表格外按钮
     * 4:权限按钮
     * 5.具体权限
     */
    private Integer type;
    private Long parentId;           //父级权限id
    private Long rootId;             //系统分类权限
    private Long sortNumber;         //树形排序
    private String url;              //具体路径
    private String jsMethod;         //权限按钮id
    private String icon;             //菜单图标
    private String bigIcon;          //大图标
    private String smallIcon;        //小图标
    private String jsMethod1;
    private String flag;
    private Long authorityId;
    private List<AuthorityEntity> children = new ArrayList<AuthorityEntity>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    public Long getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Long sortNumber) {
        this.sortNumber = sortNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJsMethod() {
        return jsMethod;
    }

    public void setJsMethod(String jsMethod) {
        this.jsMethod = jsMethod;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<AuthorityEntity> getChildren() {
        return children;
    }

    public void setChildren(List<AuthorityEntity> children) {
        this.children = children;
    }

    public String getJsMethod1() {
        return jsMethod1;
    }

    public void setJsMethod1(String jsMethod1) {
        this.jsMethod1 = jsMethod1;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    public String getBigIcon() {
        return bigIcon;
    }

    public void setBigIcon(String bigIcon) {
        this.bigIcon = bigIcon;
    }

    public String getSmallIcon() {
        return smallIcon;
    }

    public void setSmallIcon(String smallIcon) {
        this.smallIcon = smallIcon;
    }

    @Override
    public String toString() {
        return "AuthorityForm [id=" + id + ", title=" + title + ", englishTitle=" + englishTitle + ", description="
                + description + ", type=" + type + ", parentId=" + parentId + ", rootId=" + rootId + ", sortNumber="
                + sortNumber + ", url=" + url + ", jsMethod=" + jsMethod + ", icon=" + icon + ", bigIcon=" + bigIcon
                + ", smallIcon=" + smallIcon + ", jsMethod1=" + jsMethod1 + ", flag=" + flag + ", authorityId="
                + authorityId + ", children=" + children + "]";
    }
}
