package com.forum.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.forum.dao.ConfigDAO;
import com.forum.jdbc.ConnectionUtil;
import com.forum.model.ConfigBean;

public class ConfigDAOImpl implements ConfigDAO{

	@SuppressWarnings("unchecked")
	public List<ConfigBean> getDefaultConfigurations() {
		Session session = null;
		List<ConfigBean> object = null;
		try {
			session = ConnectionUtil.getSession();
			session.beginTransaction();
			
			object = session.createCriteria(ConfigBean.class).add(Restrictions.eq("role", "default")).list();
			//object = session.createCriteria(ConfigBean.class).list();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return object;
	}
}
