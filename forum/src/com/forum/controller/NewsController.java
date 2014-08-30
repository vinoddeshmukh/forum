package com.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forum.common.BaseBean;
import com.forum.dao.NewsDAO;
import com.forum.model.NewsBean;

@Controller
public class NewsController {
	@Autowired
	private NewsDAO newsDAO;

	@RequestMapping(value = "news", method = RequestMethod.GET)
	public @ResponseBody BaseBean getNews(){
		System.out.println("NewsController | getNews | Start");
		List<NewsBean> news = newsDAO.getNews();
		BaseBean baseBean = new BaseBean();
		baseBean.setHeader("Latest Technical News");
		baseBean.setDataList(news);
		System.out.println("NewsController | getNews | End");
		return baseBean;
	}
	
	@RequestMapping(value = "news/{index}", method = RequestMethod.GET)
	public @ResponseBody NewsBean getNewsDetails(@PathVariable Integer index){
		System.out.println("NewsController | getNewsDetails | Start index:"+index);
		NewsBean newsDetails = newsDAO.getNewsDetails(index);
		System.out.println("NewsController | getNewsDetails | End");
		return newsDetails;
	}
}
