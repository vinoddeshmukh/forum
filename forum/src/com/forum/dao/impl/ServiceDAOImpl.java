package com.forum.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.forum.dao.ServiceDAO;
import com.forum.model.ServiceBean;
import com.forum.utils.ForumHibernateDAOSupport;

@Repository("serviceDAO")
public class ServiceDAOImpl extends ForumHibernateDAOSupport implements ServiceDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceBean> getServiceDetailsByCategory(String category) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ServiceBean.class);
		criteria.add(Restrictions.eq("status", "A"));
		criteria.add(Restrictions.eq("category", category));
		
		return getHibernateTemplate().findByCriteria(criteria);
	}
}
