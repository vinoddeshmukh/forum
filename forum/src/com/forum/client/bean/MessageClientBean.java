package com.forum.client.bean;

import java.util.List;

import com.forum.common.BaseBean;
import com.forum.model.MessageBean;

public class MessageClientBean extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<MessageBean> java;
	List<MessageBean> jee;
	List<MessageBean> ui;
	List<MessageBean> managment;
	List<MessageBean> project;
	List<MessageBean> other;
	
	List<MessageBean> recent;
	List<MessageBean> mostViewed;
	
	public List<MessageBean> getJava() {
		return java;
	}
	public void setJava(List<MessageBean> java) {
		this.java = java;
	}
	public List<MessageBean> getJee() {
		return jee;
	}
	public void setJee(List<MessageBean> jee) {
		this.jee = jee;
	}
	public List<MessageBean> getUi() {
		return ui;
	}
	public void setUi(List<MessageBean> ui) {
		this.ui = ui;
	}
	public List<MessageBean> getManagment() {
		return managment;
	}
	public void setManagment(List<MessageBean> managment) {
		this.managment = managment;
	}
	public List<MessageBean> getProject() {
		return project;
	}
	public void setProject(List<MessageBean> project) {
		this.project = project;
	}
	public List<MessageBean> getOther() {
		return other;
	}
	public void setOther(List<MessageBean> other) {
		this.other = other;
	}
	public List<MessageBean> getRecent() {
		return recent;
	}
	public void setRecent(List<MessageBean> recent) {
		this.recent = recent;
	}
	public List<MessageBean> getMostViewed() {
		return mostViewed;
	}
	public void setMostViewed(List<MessageBean> mostViewed) {
		this.mostViewed = mostViewed;
	}
	
}
