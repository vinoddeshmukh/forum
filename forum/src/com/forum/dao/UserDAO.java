package com.forum.dao;

import java.util.List;

import com.forum.model.UserBean;

public interface UserDAO {
	
	public List<UserBean> getConsultants();
	
	public List<UserBean> getOnlineConsultants();
	
	public UserBean getConsultantDetails(String index);
	
	public UserBean registerNewUser(UserBean userBean);
	
	public UserBean getUserDetailsAfterLogin(UserBean userBean);

}
