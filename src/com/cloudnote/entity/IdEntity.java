package com.cloudnote.entity;

/**
 * 	FileName: IdEntity.java
 *	desc: 所有实体类的父类,主键定义.
 *
 */
public abstract class IdEntity {

	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
