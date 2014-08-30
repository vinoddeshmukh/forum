package com.forum.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;


@Entity
@Table(name = "FRM_MSG_REPLIES")
@SequenceGenerator(name = "SEQ_FRM_MSG_REPLIES_ID", sequenceName = "SEQ_FRM_MSG_REPLIES_ID", allocationSize = 1)
public class MessageDetailsBean  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_ID", nullable = false)
	@JsonBackReference
	private MessageBean replies;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FRM_MSG_REPLIES_ID")
	@Column(name = "MSG_ID")
	private Integer msgId;
	
	@Column(name = "REPLIED_DT")
	private Date createdDt;
	
	@Column(name = "USER_ID")
	private String createdBy;
	
	@Column(name = "ROLE")
	private String role;
	
	@Column(name = "MESSAGE")
	private String message;
	
	@Column(name = "STATUS")
	private String status;
	
	public MessageBean getReplies() {
		return replies;
	}

	public void setReplies(MessageBean replies) {
		this.replies = replies;
	}

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MessageDetailsBean:msgId:"+msgId+"\n"+"message:"+message;
				
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
