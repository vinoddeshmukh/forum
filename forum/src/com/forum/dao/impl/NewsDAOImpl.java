package com.forum.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.forum.dao.NewsDAO;
import com.forum.model.NewsBean;
import com.forum.utils.ForumHibernateDAOSupport;

@Repository("newsDAO")
public class NewsDAOImpl extends ForumHibernateDAOSupport implements NewsDAO {
	
	@Override
	public List<NewsBean> getNews() {
		return getHibernateTemplate().loadAll(NewsBean.class);
	}
	
	@Override
	public NewsBean getNewsDetails(Integer index) {
		return getHibernateTemplate().get(NewsBean.class, index);
	}
}
