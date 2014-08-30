package com.forum.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FRM_TABLE_COL_JSON_MAP")
public class TableColumnJSONMapping implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PK_ID")
	public String pkId;
	
	//@Id
	@Column(name = "TABLE_NAME")
	public String tableName;
	
	//@Id
	@Column(name = "COLUMN_NAME")
	private String columnName;
	
	@Column(name = "JSON_KEY")
	private String jsonKey;
	
	@Column(name = "RENDER_FLG")
	private String renderFlag;
	
	@Column(name = "MODULE_ID")
	private String moduleId;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getJsonKey() {
		return jsonKey;
	}

	public void setJsonKey(String jsonKey) {
		this.jsonKey = jsonKey;
	}

	public String getRenderFlag() {
		return renderFlag;
	}

	public void setRenderFlag(String renderFlag) {
		this.renderFlag = renderFlag;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getPkId() {
		return pkId;
	}

	public void setPkId(String pkId) {
		this.pkId = pkId;
	}
	
}
