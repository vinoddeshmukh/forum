package com.forum.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forum.client.bean.MessageClientBean;
import com.forum.common.BaseBean;
import com.forum.dao.MessageDAO;
import com.forum.model.MessageBean;
import com.forum.model.MessageDetailsBean;
import com.forum.model.UserBean;

@Controller
public class MessageController {
	
	@Autowired
	private MessageDAO messagesDAO;

	@RequestMapping(value = "messages", method = RequestMethod.GET)
	public @ResponseBody BaseBean getMessages(HttpSession httpSession){
		System.out.println("MessageController | getMessages | Start");
		MessageClientBean baseBean = new MessageClientBean();
		
		UserBean userBean = (UserBean) httpSession.getAttribute("userBean");
		String userRole = "";
		if(userBean != null){
			userRole = userBean.getRole();
		}
		
		try{
		
		List<MessageBean> javaMessages = messagesDAO.getMessagesByCategory("Java", userRole);
		baseBean.setJava(javaMessages);
		
		List<MessageBean> jEEMessages = messagesDAO.getMessagesByCategory("JEE", userRole);
		baseBean.setJee(jEEMessages);
		
		List<MessageBean> uiMessages = messagesDAO.getMessagesByCategory("UI", userRole);
		baseBean.setUi(uiMessages);
		
		List<MessageBean> managementMessages = messagesDAO.getMessagesByCategory("Management", userRole);
		baseBean.setManagment(managementMessages);
		
		List<MessageBean> projectMessages = messagesDAO.getMessagesByCategory("Project", userRole);
		baseBean.setProject(projectMessages);
		
		List<MessageBean> otherMessages = messagesDAO.getMessagesByCategory("Other", userRole);
		baseBean.setOther(otherMessages);
		
		baseBean.setHeader("Latest Messages");
		
		baseBean.setDataList(javaMessages);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("MessageController | getMessages | End");
		return baseBean;
	}
	
	@RequestMapping(value = "messages", method = RequestMethod.POST)
	public @ResponseBody BaseBean postMessages(@RequestBody MessageDetailsBean messageDetailsBean){
		System.out.println("MessageController | postMessages | Start");
		messageDetailsBean.setCreatedDt(new Date());
		MessageBean messageBean = messagesDAO.getMessageDetails(messageDetailsBean.getMsgId());
		messageDetailsBean.setCreatedBy("gust");
		messageDetailsBean.setReplies(messageBean);
		messageBean.getMessageReplies().add(messageDetailsBean);
		
		/*MessageBean replies = new MessageBean();
		replies.setPostId(messageDetailsBean.getMsgId());
		messageDetailsBean.setReplies(replies);*/
		
		messagesDAO.update(messageDetailsBean);
		System.out.println("MessageController | postMessages | End");
		BaseBean baseBean = new BaseBean();
		baseBean.setMessage("Your reply has been created successfully");
		baseBean.setData(messageDetailsBean);
		return baseBean;
	}
	
	
	@RequestMapping(value = "postNewMessages", method = RequestMethod.GET)
	public @ResponseBody BaseBean postNewMessages(){
		System.out.println("MessageController | postNewMessages | Start");
		System.out.println("MessageController | postNewMessages | End");
		return new BaseBean();
	}
	
	@RequestMapping(value = "postNewMessages", method = RequestMethod.POST)
	public @ResponseBody BaseBean postNewMessages(@RequestBody MessageBean messageBean){
		System.out.println("MessageController | postNewMessages | Start");
		messageBean.setCreatedDt(new Date());
		messageBean.setCreatedBy("gust");
		messagesDAO.save(messageBean);
		System.out.println("MessageController | postNewMessages | End");
		BaseBean baseBean = new BaseBean();
		baseBean.setMessage("Your post has been created successfully");
		baseBean.setData(messageBean);
		return baseBean;
	}
	
	
	@RequestMapping(value = "recentmessages", method = RequestMethod.GET)
	public @ResponseBody BaseBean getRecentMessages(){
		MessageClientBean baseBean = new MessageClientBean();
		baseBean.setHeader("Latest Messages");
		
		List<MessageBean> recentMessages = messagesDAO.getMessagesByRecent();
		baseBean.setRecent(recentMessages);
		
		List<MessageBean> mostViewedMessages = messagesDAO.getMessagesByMostViewed();
		baseBean.setMostViewed(mostViewedMessages);
		
		return baseBean;
	}
	
	@RequestMapping(value = "messages/{index}", method = RequestMethod.GET)
	public @ResponseBody MessageBean getMessageDetails(@PathVariable Integer index){
		System.out.println("MessageController | getMessageDetails | Start index:"+index);
		MessageBean messageBean = messagesDAO.getMessageDetails(index);
		System.out.println("MessageController | getMessageDetails | End");
		return messageBean;
	}
}
