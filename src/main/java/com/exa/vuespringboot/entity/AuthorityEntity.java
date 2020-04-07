package com.exa.vuespringboot.entity;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AuthorityEntity implements java.io.Serializable,Cloneable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private String englishTitle;
	private String description;
	private Integer type;
	private Long parentId;
	private Long rootId;
	private Long sortNumber;
	private String url;
	private String jsMethod;
	private String icon;
	private String bigIcon;
	private String smallIcon;
	private String flag;
	private Long authorityId;
	private List<AuthorityEntity> children=new LinkedList<AuthorityEntity>();

	private String moduleName;
    private String namespace;
    private String imageName;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}



	private Set<Long> childIds=new HashSet<Long>();

	public AuthorityEntity() {
	}

	public AuthorityEntity(Long id, Long parentId) {
		this.id = id;
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "AuthorityEntity{" +
				"id=" + id +
				", title='" + title + '\'' +
				", englishTitle='" + englishTitle + '\'' +
				", description='" + description + '\'' +
				", type=" + type +
				", parentId=" + parentId +
				", rootId=" + rootId +
				", sortNumber=" + sortNumber +
				", url='" + url + '\'' +
				", jsMethod='" + jsMethod + '\'' +
				", icon='" + icon + '\'' +
				", bigIcon='" + bigIcon + '\'' +
				", smallIcon='" + smallIcon + '\'' +
				", flag='" + flag + '\'' +
				", authorityId=" + authorityId +
				", children=" + children +
				", moduleName='" + moduleName + '\'' +
				", namespace='" + namespace + '\'' +
				", imageName='" + imageName + '\'' +
				", childIds=" + childIds +
				'}';
	}

	@Override
	public AuthorityEntity clone() {
		AuthorityEntity other=new AuthorityEntity();
		other.setId(this.id);
		other.setTitle(this.title);
		other.setEnglishTitle(this.englishTitle);
		other.setDescription(this.description);
		other.setType(this.type);
		other.setParentId(this.parentId);
		other.setRootId(this.rootId);
		other.setSortNumber(this.sortNumber);
		other.setUrl(this.url);
		other.setJsMethod(this.jsMethod);
		other.setIcon(this.icon);
		other.setFlag(this.flag);
		other.setAuthorityId(this.authorityId);

		other.setModuleName(this.moduleName);
		other.setNamespace(this.namespace);
		other.setImageName(this.imageName);
		if(this.children!=null )
		{
			for(AuthorityEntity c:children){
				AuthorityEntity oc=c.clone();
				other.addChildren(oc);
			} 
		}
		if(this.childIds!=null )
		{
			for(Long cId:childIds){
				other.addChildId(cId);
			} 
		}
		return other;
	}

	public void addChildren(AuthorityEntity entity)
	{
		if(children==null)
		{
			children=new LinkedList<AuthorityEntity>();
		}
		if(entity!=null){
			int i=0;
			for(;i<children.size();i++)
			{
				AuthorityEntity c=children.get(i);
				if(c.getSortNumber()!=null  ){
					if(entity.getSortNumber()==null){
						
						break;
					}else if(c.getSortNumber()==0){
						continue;
					}else if(entity.getSortNumber()<c.getSortNumber()){
						break;
					}
				}
			}
			
			children.add(i,entity);
		}
		
	}
	
	public void addChildId(Long cid)
	{
		if(childIds==null)
		{
			childIds=new HashSet<Long>();
		}
		if(cid!=null){
			childIds.add(cid);
		}
		
	}
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the englishTitle
	 */
	public String getEnglishTitle() {
		return englishTitle;
	}

	/**
	 * @param englishTitle
	 *            the englishTitle to set
	 */
	public void setEnglishTitle(String englishTitle) {
		this.englishTitle = englishTitle;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the rootId
	 */
	public Long getRootId() {
		return rootId;
	}

	/**
	 * @param rootId
	 *            the rootId to set
	 */
	public void setRootId(Long rootId) {
		this.rootId = rootId;
	}

	/**
	 * @return the sortNumber
	 */
	public Long getSortNumber() {
		return sortNumber;
	}

	/**
	 * @param sortNumber
	 *            the sortNumber to set
	 */
	public void setSortNumber(Long sortNumber) {
		this.sortNumber = sortNumber;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the jsMethod
	 */
	public String getJsMethod() {
		return jsMethod;
	}

	/**
	 * @param jsMethod
	 *            the jsMethod to set
	 */
	public void setJsMethod(String jsMethod) {
		this.jsMethod = jsMethod;
	}

	/**
	 * @return the children
	 */
	public List<AuthorityEntity> getChildren() {
		return children;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
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

	public void setChildren(List<AuthorityEntity> children) {
		this.children = children;
	}

	public Set<Long> getChildIds() {
		return childIds;
	}

	public void setChildIds(Set<Long> childIds) {
		this.childIds = childIds;
	}

}
