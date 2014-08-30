package com.forum.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FRM_PROCESS_KEY_MAP")
public class ForumProcessKeyMap implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "PROCESS_KEY")
	private String processKey;
	
	@Column(name = "TABLE_NAME")
	private String tableName;
	
	@Column(name = "CONDITION")
	private String condition;
	
	@Column(name = "RESULT_TYPE")
	private String resultType;
	
	@Column(name = "HIBERNATE_CLASS_NAME")
	private String hibernateClassName;

	public String getProcessKey() {
		return processKey;
	}

	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getHibernateClassName() {
		return hibernateClassName;
	}

	public void setHibernateClassName(String hibernateClassName) {
		this.hibernateClassName = hibernateClassName;
	}
	
}
