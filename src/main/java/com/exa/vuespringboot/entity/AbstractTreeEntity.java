package com.exa.vuespringboot.entity;

import java.util.ArrayList;
import java.util.List;

public class AbstractTreeEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	protected Long id;
	protected String text;
	protected Integer  type;
	protected List<AbstractTreeEntity> children = new ArrayList<AbstractTreeEntity>();
	//close或者open
	protected String state;

	public void addChildren(AbstractTreeEntity entity) {
		if (children == null) {
			children = new ArrayList<AbstractTreeEntity>();
		}
		children.add(entity);
	}
	public void addChildren(List<AbstractTreeEntity> entityList) {
		if (children == null) {
			children = new ArrayList<AbstractTreeEntity>();
		}
		children.addAll(entityList);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<AbstractTreeEntity> getChildren() {
		return children;
	}

	public void setChildren(List<AbstractTreeEntity> children) {
		this.children = children;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String reserve) {
		this.state = reserve;
	}
}
