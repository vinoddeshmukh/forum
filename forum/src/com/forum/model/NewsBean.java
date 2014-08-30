package com.forum.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.forum.common.CommonUtil;

@Entity
@Table(name = "FRM_NEWS")
@SequenceGenerator(name = "SEQ_FRM_NEWS_ID", sequenceName = "SEQ_FRM_NEWS_ID", allocationSize = 1)
public class NewsBean implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FRM_NEWS_ID")
	@Column(name = "FRM_ID")
	private Integer frmId;
	
	@Column(name = "NEWS_TITLE")
	private String newsTitle;
	
	@Column(name = "NEWS_DESC")
	private String newsDesc;
	
	@Column(name = "NEWS_DT")
	private Date newsDt;
	
	@Column(name = "USER_ID")
	private String createdBy;
	
	@Column(name = "CREATED_DT")
	private Date createdDt;
	
	@Column(name = "NEWS_STATUS")
	private String newsStatus;
	
	@Column(name = "REFERENCE")
	private String reference;
	
	private transient String newsDtStr;

	public Integer getFrmId() {
		return frmId;
	}
	
	public void setFrmId(Integer frmId) {
		this.frmId = frmId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsDesc() {
		return newsDesc;
	}

	public void setNewsDesc(String newsDesc) {
		this.newsDesc = newsDesc;
	}

	public Date getNewsDt() {
		return newsDt;
	}

	public void setNewsDt(Date newsDt) {
		this.newsDt = newsDt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getNewsStatus() {
		return newsStatus;
	}

	public void setNewsStatus(String newsStatus) {
		this.newsStatus = newsStatus;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getNewsDtStr() {
		if(this.newsDt !=null){
			return CommonUtil.getDateInStringFormat(newsDt);
		}
		return newsDtStr;
	}

	public void setNewsDtStr(String newsDtStr) {
		this.newsDtStr = newsDtStr;
	}
	
}
