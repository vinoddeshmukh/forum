package com.forum.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.forum.dao.UserDAO;
import com.forum.model.UserBean;
import com.forum.utils.ForumHibernateDAOSupport;

@Repository("userDAO")
public class UserDAOImpl extends ForumHibernateDAOSupport implements UserDAO {

	@Override
	public List<UserBean> getConsultants() {
		return getHibernateTemplate().loadAll(UserBean.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserBean> getOnlineConsultants() {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserBean.class);
		criteria.add(Restrictions.eq("loginStatus", "A"));
		
		return getHibernateTemplate().findByCriteria(criteria);
	}
	
	@Override
	public UserBean getConsultantDetails(String index) {
		return getHibernateTemplate().get(UserBean.class, index);
	}
	
	@Override
	public UserBean registerNewUser(UserBean userBean){
		getHibernateTemplate().saveOrUpdate(userBean);
		return userBean;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public UserBean getUserDetailsAfterLogin(UserBean userBean){
		List<UserBean> userList = new ArrayList<UserBean>();
		DetachedCriteria criteria = DetachedCriteria.forClass(UserBean.class);
		criteria.add(Restrictions.eq("email", userBean.getEmail()));
		criteria.add(Restrictions.eq("password", userBean.getPassword()));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		userList = getHibernateTemplate().findByCriteria(criteria);
			
		return userList.get(0);
	}
	
}
