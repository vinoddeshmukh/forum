package com.forum.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.forum.dao.DocumentDAO;
import com.forum.model.DocumentBean;
import com.forum.utils.ForumHibernateDAOSupport;
 
@Repository("documentDAO")
public class DocumentDAOImpl extends  ForumHibernateDAOSupport implements DocumentDAO {
     
	@Override
    public void save(DocumentBean document) {
        getHibernateTemplate().saveOrUpdate(document);
    }
     
    @Override
    public List<DocumentBean> list() {
        return getHibernateTemplate().loadAll(DocumentBean.class);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<DocumentBean> documentList(String category) {
        DetachedCriteria criteria = DetachedCriteria.forClass(DocumentBean.class);
        criteria.add(Restrictions.eq("category", category)); 
        return getHibernateTemplate().findByCriteria(criteria);
    }
    
    @Override
    public DocumentBean get(Integer id) {
        return getHibernateTemplate().get(DocumentBean.class, id);
    }
 
    @Override
    public void remove(Integer id) {
        getHibernateTemplate().delete(getHibernateTemplate().get(DocumentBean.class, id));
    }
}
