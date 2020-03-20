package com.exa.vuespringboot.entity;

public class LowerMenuEntiry {

	private Long id;
	
	private String title;
	
	private String url;

	private String jsMethod;

	private Integer sortNum;

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getJsMethod() {
		return jsMethod;
	}

	public void setJsMethod(String jsMethod) {
		this.jsMethod = jsMethod;
	}
}
