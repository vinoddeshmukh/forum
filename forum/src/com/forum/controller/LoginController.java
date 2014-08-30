package com.forum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.forum.common.NameValueBean;
import com.forum.dao.UserDAO;
import com.forum.model.UserBean;

@SessionAttributes("userBean")
@Controller
public class LoginController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "loginAction", method = RequestMethod.POST)
	public @ResponseBody String executeLoginAction(@RequestBody List<NameValueBean> nameValueBeanList, HttpServletRequest req, HttpServletResponse res ){
		System.out.println("LoginController | executeLoginAction | Start");
		UserBean userBean = new UserBean();
		for (NameValueBean nameValueBean : nameValueBeanList) {
			System.out.println("LoginController | executeLoginAction | name:"+nameValueBean.getName());
			System.out.println("LoginController | executeLoginAction | value:"+nameValueBean.getValue());
			if(nameValueBean.getName() != null && nameValueBean.getName().equals("email")){
				userBean.setEmail(nameValueBean.getValue());
			} else if(nameValueBean.getName() != null && nameValueBean.getName().equals("password")){
				userBean.setPassword(nameValueBean.getValue());
			}
		}
		
		userBean = userDAO.getUserDetailsAfterLogin(userBean);
		
		req.getSession().setAttribute("userBean", userBean);
		
		System.out.println("LoginController | executeLoginAction | End");
		//ModelAndView modelAndView = new ModelAndView("index.html");
		return new String("{\"responseCode\":\"SUCCESS\",\"userRole\":\"ADMIN\"}");
		//return new String("{\"responseCode\":\"SUCCESS\",\"userRole\":\"\"}");
		//return "redirect:/index.html";
		//return modelAndView;
	}
}
