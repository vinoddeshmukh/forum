package com.forum.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FRM_CONFIG_MAP")
public class ConfigBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CONFIG_ID")
	private String configId;
	
	@Column(name = "SCREEN_ID")
	private String screenId;
	
	@Column(name = "MODULE_ID")
	private String moduleId;
	
	@Column(name = "ROLE")
	private String role;
	
	@Column(name = "HTML_PATH")
	private String htmlPath;
	
	@Column(name = "EL")
	private String el;
	
	@Column(name = "DEFAULT_SERVICE_URL")
	private String defaultServiceUrl;

	public String getConfigId() {
		return configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getHtmlPath() {
		return htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}

	public String getEl() {
		return el;
	}

	public void setEl(String el) {
		this.el = el;
	}

	public String getDefaultServiceUrl() {
		return defaultServiceUrl;
	}

	public void setDefaultServiceUrl(String defaultServiceUrl) {
		this.defaultServiceUrl = defaultServiceUrl;
	}
}
