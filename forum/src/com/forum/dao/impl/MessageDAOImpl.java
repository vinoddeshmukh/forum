package com.forum.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.forum.dao.MessageDAO;
import com.forum.model.MessageBean;
import com.forum.model.MessageDetailsBean;
import com.forum.utils.ForumHibernateDAOSupport;

@Repository("messageDAO")
public class MessageDAOImpl extends ForumHibernateDAOSupport implements MessageDAO {

	@Override
	public List<MessageBean> getMessages() {
		List<MessageBean> messageList = getHibernateTemplate().loadAll(MessageBean.class);
		/*for (MessageBean messageBean : messageList) {
			System.out.println("MessageBean-->" + messageBean.toString());
			List<MessageDetailsBean> messageReplies = messageBean
					.getMessageReplies();
			if (messageReplies != null) {
				for (MessageDetailsBean messageDetailsBean : messageReplies) {
					System.out.println("messageDetailsBean-->"
							+ messageDetailsBean.toString());
				}
			} else {
				System.out.println("MessageDetailsBean is null");
			}
		}*/
		return messageList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MessageBean> getMessagesByCategory(String catagoty, String userRole) {
		List<MessageBean> messagesByCategoryList = new ArrayList<>();
		DetachedCriteria criteria = DetachedCriteria.forClass(MessageBean.class);
		if (userRole != null && userRole.equals("ADMIN")) {			
			criteria.add(Restrictions.eq("category", catagoty));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.addOrder(Order.desc("createdDt"));
			criteria.addOrder(Order.desc("status"));
		
			messagesByCategoryList = getHibernateTemplate().findByCriteria(criteria);
		} else {
			criteria.add(Restrictions.eq("category", catagoty));
			criteria.add(Restrictions.eq("status", "A"));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.addOrder(Order.desc("createdDt"));
			
			messagesByCategoryList = getHibernateTemplate().findByCriteria(criteria);
		}

		return messagesByCategoryList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MessageBean> getMessagesByRecent() {
		List<MessageBean> messagesByCategoryList = new ArrayList<>();
		
		DetachedCriteria criteria = DetachedCriteria.forClass(MessageBean.class);
		criteria.add(Restrictions.eq("status", "A"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc("createdDt"));
		//criteria.setMaxResults(10);
		//TODO: Vinod - set max result pending
		messagesByCategoryList = getHibernateTemplate().findByCriteria(criteria);
		return messagesByCategoryList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MessageBean> getMessagesByMostViewed() {
		List<MessageBean> messagesByCategoryList = new ArrayList<>();
		
		DetachedCriteria criteria = DetachedCriteria.forClass(MessageBean.class);
		criteria.add(Restrictions.eq("status", "A"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc("createdDt"));
		//criteria.setMaxResults(10);
		//TODO: Vinod - set max result pending
		messagesByCategoryList = getHibernateTemplate().findByCriteria(criteria);
		return messagesByCategoryList;
	}

	@Override
	public MessageBean getMessageDetails(Integer index) {
		return getHibernateTemplate().get(MessageBean.class, index);
	}

	@Override
	public void update(MessageDetailsBean messageDetailsBean) {
		messageDetailsBean.setStatus("P");
		getHibernateTemplate().saveOrUpdate(messageDetailsBean);
	}

	@Override
	public void update(MessageBean messageBean) {
		getHibernateTemplate().saveOrUpdate(messageBean);
	}

	public void save(MessageBean messageBean) {
		messageBean.setStatus("P");
		getHibernateTemplate().saveOrUpdate(messageBean);
	}

}
