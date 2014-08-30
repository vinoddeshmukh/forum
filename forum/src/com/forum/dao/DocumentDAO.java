package com.forum.dao;

import java.util.List;

import com.forum.model.DocumentBean;

public interface DocumentDAO {
	
	public void save(DocumentBean document);
	
	public List<DocumentBean> list();
	
	public List<DocumentBean> documentList(String category);
	
	public DocumentBean get(Integer id);
	
	public void remove(Integer id);

}
