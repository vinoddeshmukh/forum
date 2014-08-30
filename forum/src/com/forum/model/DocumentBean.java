package com.forum.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "FRM_TITURALS")
public class DocumentBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private Integer documentId;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "CONTENTS")
	@Lob
	@JsonIgnore
	private Blob documentContents;
	
	@JsonIgnore
	private transient String documentContentsAsString;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "FILE_NAME")
	private String fileName;
	
	@Column(name = "CONTENT_TYPE")
	private String contentType;

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getDocumentContents() {
		return documentContents;
	}

	public void setDocumentContents(Blob documentContents) {
		this.documentContents = documentContents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getDocumentContentsAsString() {
		if(this.documentContents!=null){
			byte[] bdata = null;
			try {
				bdata = this.documentContents.getBytes(1, (int) this.documentContents.length());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			documentContentsAsString = new String(bdata);
		}
		return documentContentsAsString;
	}

	public void setDocumentContentsAsString(String documentContentsAsString) {
		this.documentContentsAsString = documentContentsAsString;
	}
	
}
