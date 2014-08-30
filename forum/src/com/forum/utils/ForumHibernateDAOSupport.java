package com.forum.utils;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
 
public abstract class ForumHibernateDAOSupport extends HibernateDaoSupport
{    
    @Autowired
    public void setSessionfactory(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
}