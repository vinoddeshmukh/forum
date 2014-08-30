package com.forum.dao;

import java.util.List;

import com.forum.model.MessageBean;
import com.forum.model.MessageDetailsBean;

public interface MessageDAO {

	public List<MessageBean> getMessages();
	
	public List<MessageBean> getMessagesByCategory(String catagoty, String userRole);
	
	public List<MessageBean> getMessagesByRecent();
	
	public MessageBean getMessageDetails(Integer index);
	
	public void update(MessageDetailsBean messageDetailsBean);
	
	public void update(MessageBean messageBean);
	
	public void save(MessageBean messageBean);

	List<MessageBean> getMessagesByMostViewed();
	
}
