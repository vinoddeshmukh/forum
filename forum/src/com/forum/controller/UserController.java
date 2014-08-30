package com.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forum.client.bean.ConsultantTabBean;
import com.forum.common.BaseBean;
import com.forum.dao.ServiceDAO;
import com.forum.dao.UserDAO;
import com.forum.model.ServiceBean;
import com.forum.model.UserBean;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ServiceDAO serviceDAO;

	@RequestMapping(value = "consultants", method = RequestMethod.GET)
	public @ResponseBody BaseBean getConsultants(){
		System.out.println("UserController | getConsultants | Start");
		
		List<ServiceBean> ourValuesList = serviceDAO.getServiceDetailsByCategory("VALUES");
		List<ServiceBean> ourServiceList = serviceDAO.getServiceDetailsByCategory("SERVICE");
		
		List<UserBean> consultants = userDAO.getConsultants();
		ConsultantTabBean baseBean = new ConsultantTabBean();
		baseBean.setHeader("Our Technical Consultant");
		baseBean.setDataList(consultants);
		baseBean.setOurServiceList(ourServiceList);
		baseBean.setOurValuesList(ourValuesList);
		System.out.println("UserController | getConsultants | End");
		return baseBean;
	}
	
	@RequestMapping(value = "onlineConsultants", method = RequestMethod.GET)
	public @ResponseBody BaseBean getOnlineConsultants(){
		System.out.println("UserController | getOnlineConsultants | Start");
		List<UserBean> consultants = userDAO.getOnlineConsultants();
		BaseBean baseBean = new BaseBean();
		baseBean.setHeader("Online Chat with our Consultant");
		baseBean.setDataList(consultants);
		System.out.println("UserController | getOnlineConsultants | End");
		return baseBean;
	}
	
	
	
	@RequestMapping(value = "consultants/{index}", method = RequestMethod.GET)
	public @ResponseBody UserBean getConsultantsDetails(@PathVariable String index){
		System.out.println("UserController | getConsultantsDetails | Start");
		UserBean consultant = userDAO.getConsultantDetails(index);
		System.out.println("UserController | getConsultantsDetails | End");
		return consultant;
	}
	
	@RequestMapping(value= "registerNewUser", method = RequestMethod.POST)
	public @ResponseBody BaseBean registerNewUser(@RequestBody UserBean userBean){
		System.out.println("UserController | registerNewUser | start");
		
		userBean = userDAO.registerNewUser(userBean);
		
		System.out.println("UserController | registerNewUser | End");
		BaseBean baseBean = new BaseBean();
		baseBean.setMessage("Registered successfully");
		baseBean.setData(userBean);
		return baseBean;
	}
	
	@RequestMapping(value = "usersList", method = RequestMethod.GET)
	public @ResponseBody BaseBean getUsersList(){
		System.out.println("UserController | getUsersList | Start");
		List<UserBean> consultants = userDAO.getConsultants();
		BaseBean baseBean = new BaseBean();
		baseBean.setHeader("Registered User Management");
		baseBean.setDataList(consultants);
		System.out.println("UserController | getUsersList | End");
		return baseBean;
	}
}
