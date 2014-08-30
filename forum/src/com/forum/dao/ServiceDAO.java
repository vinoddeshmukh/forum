package com.forum.dao;

import java.util.List;

import com.forum.model.ServiceBean;

public interface ServiceDAO {

	public List<ServiceBean> getServiceDetailsByCategory(String category);
	
}
