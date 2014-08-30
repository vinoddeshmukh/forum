package com.forum.dao;

import java.util.List;

import com.forum.model.ConfigBean;

public interface ConfigDAO {
	
	public List<ConfigBean> getDefaultConfigurations();

}
