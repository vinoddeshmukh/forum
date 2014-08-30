package com.forum.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forum.dao.ForumDAO;

@Controller
public class ForumController {
	
	@Autowired
	private ForumDAO forumDAO;

	@RequestMapping(value = "process/{processKey}", method = RequestMethod.GET)
	public @ResponseBody String processRequest(@PathVariable String processKey){
		System.out.println("ForumController | processRequest | Start processKey:"+processKey);
		JSONObject processRequest = forumDAO.processRequest(processKey);
		System.out.println("ForumController | processRequest | End");
		return processRequest.toString();
	}
}
