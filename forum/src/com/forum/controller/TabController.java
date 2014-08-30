package com.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forum.common.BaseBean;
import com.forum.dao.NewsDAO;
import com.forum.model.NewsBean;

@Controller
public class TabController {
	
	@Autowired
	private NewsDAO newsDAO;
	
	@RequestMapping(value = "panel1", method = RequestMethod.GET)
	public @ResponseBody String getPanel1Data(){
		System.out.println("TabController | getPanel1Data | Start");
		System.out.println("TabController | getPanel1Data | End");
		return "This is getPanel1Data";
	}
	
	@RequestMapping(value = "panel2", method = RequestMethod.GET)
	public @ResponseBody String getPanel2Data(){
		System.out.println("TabController | getPanel2Data | Start");
		System.out.println("TabController | getPanel2Data | End");
		return "This is getPanel2Data";
	}
	
	@RequestMapping(value = "panel3", method = RequestMethod.GET)
	public @ResponseBody String getPanel3Data(){
		System.out.println("TabController | getPanel3Data | Start");
		System.out.println("TabController | getPanel3Data | End");
		return "This is getPanel3Data";
	}
	
	@RequestMapping(value = "panel4", method = RequestMethod.GET)
	public @ResponseBody BaseBean getPanel4Data(){
		System.out.println("TabController | getPanel4Data | Start");
		
		List<NewsBean> news = newsDAO.getNews();
		System.out.println("TabController | getPanel4Data | End");
		
		BaseBean baseBean = new BaseBean();
		baseBean.setHeader("News");
		baseBean.setDataList(news);
		return baseBean;
	}
	
	@RequestMapping(value = "panel5", method = RequestMethod.GET)
	public @ResponseBody String getPanel5Data(){
		System.out.println("TabController | getPanel5Data | Start");
		System.out.println("TabController | getPanel5Data | End");
		return "This is getPanel5Data";
	}
	
	@RequestMapping(value = "panel6", method = RequestMethod.GET)
	public @ResponseBody String getPanel6Data(){
		System.out.println("TabController | getPanel6Data | Start");
		System.out.println("TabController | getPanel6Data | End");
		return "This is getPanel6Data";
	}
}
