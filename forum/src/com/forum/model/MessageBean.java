package com.forum.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "FRM_MESSAGE")
@SequenceGenerator(name = "SEQ_FRM_MESSAGE_ID", sequenceName = "SEQ_FRM_MESSAGE_ID", allocationSize = 1)
public class MessageBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FRM_MESSAGE_ID")
	@Column(name = "POST_ID")
	private Integer postId;
	
	@Column(name = "CREATED_DT")
	private Date createdDt;
	
	@Column(name = "USER_ID")
	private String createdBy;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "MESSAGE")
	private String message;
	
	@Column(name = "STATUS")
	private String status;
	
	@Version
	@Column(name = "VERSION")
	private Integer version;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "replies")
	@Cascade({CascadeType.SAVE_UPDATE})
	@JsonManagedReference
	//@JoinColumn(name="POST_ID")
	private List<MessageDetailsBean> messageReplies;
	
	public List<MessageDetailsBean> getMessageReplies() {
		return messageReplies;
	}

	public void setMessageReplies(List<MessageDetailsBean> messageReplies) {
		this.messageReplies = messageReplies;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MessageBean:postId:"+postId+"\n"+"message:"+message;
				
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
