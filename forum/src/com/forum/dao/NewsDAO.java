package com.forum.dao;

import java.util.List;

import com.forum.model.NewsBean;

public interface NewsDAO {
	
	public List<NewsBean> getNews();
	
	public NewsBean getNewsDetails(Integer index);

}
