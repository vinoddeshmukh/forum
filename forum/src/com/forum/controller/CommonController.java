package com.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/forumservice")
public class CommonController {
	@RequestMapping(value = "dataservice/headerAndMenu", method = RequestMethod.GET)
	public @ResponseBody String getHeaderAndMenu(){
		System.out.println("TabController | headerAndMenu | Start");
		System.out.println("TabController | headerAndMenu | End");
		return new String("This is getPanel1Data");
	}
}
