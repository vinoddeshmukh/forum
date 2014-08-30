package com.forum.client.bean;

import java.util.List;

import org.codehaus.jackson.annotate.JsonManagedReference;

import com.forum.common.BaseBean;
import com.forum.model.DocumentBean;

public class DocumentClientBean extends BaseBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonManagedReference
	private List<DocumentBean> documentList;
	
	@JsonManagedReference
	private List<DocumentBean> pdfList;

	public List<DocumentBean> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<DocumentBean> documentList) {
		this.documentList = documentList;
	}

	public List<DocumentBean> getPdfList() {
		return pdfList;
	}

	public void setPdfList(List<DocumentBean> pdfList) {
		this.pdfList = pdfList;
	}
	
}
