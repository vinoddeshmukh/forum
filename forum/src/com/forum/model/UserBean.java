package com.forum.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FRM_USER_DT")
public class UserBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "FIRST_NM")
	private String firstNm;
	
	@Column(name = "LAST_NM")
	private String lastNm;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "COMPANY")
	private String company;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "CONTACT_NO")
	private String contactNo;
	
	@Column(name = "ALERTS")
	private String alerts;
	
	@Column(name = "CREATED_DT")
	private Date createdDt;
	
	@Column(name = "APPROVED_BY")
	private String approvedBy;
	
	@Column(name = "APPROVAL_DT")
	private Date approvalDt;
	
	@Column(name = "MODIFIED_DT")
	private Date modifiedDt;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "PREFFERED_CET")
	private String prefferedCat;
	
	@Column(name = "ROLE")
	private String role;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "DESIGNATION")
	private String designation;
	
	@Column(name = "RESUME_TEXT")
	private String resumeText;
	
	@Column(name = "LOGIN_STATUS")
	private String loginStatus;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstNm() {
		return firstNm;
	}

	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}

	public String getLastNm() {
		return lastNm;
	}

	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAlerts() {
		return alerts;
	}

	public void setAlerts(String alerts) {
		this.alerts = alerts;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getApprovalDt() {
		return approvalDt;
	}

	public void setApprovalDt(Date approvalDt) {
		this.approvalDt = approvalDt;
	}

	public Date getModifiedDt() {
		return modifiedDt;
	}

	public void setModifiedDt(Date modifiedDt) {
		this.modifiedDt = modifiedDt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getPrefferedCat() {
		return prefferedCat;
	}

	public void setPrefferedCat(String prefferedCat) {
		this.prefferedCat = prefferedCat;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getResumeText() {
		return resumeText;
	}

	public void setResumeText(String resumeText) {
		this.resumeText = resumeText;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	
}
