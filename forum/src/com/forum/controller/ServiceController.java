package com.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forum.common.BaseBean;
import com.forum.dao.ServiceDAO;
import com.forum.model.ServiceBean;

@Controller
public class ServiceController {

	@Autowired
	private ServiceDAO serviceDAO;
	
	@RequestMapping(value = "service/{ltaf}", method = RequestMethod.GET)
	public @ResponseBody BaseBean getLatestTechnologyAndFrameworks(@PathVariable String ltaf){
		System.out.println("ServiceController | getLatestTechnologyAndFrameworks | Start ltaf:"+ltaf);
		BaseBean baseBean = new BaseBean();
		if(ltaf.equalsIgnoreCase("OFW")){
			baseBean.setHeader("Our Frameworks");
		}else if(ltaf.equalsIgnoreCase("LTAF")){
			baseBean.setHeader("Latest Technology and Frameworks");
		}
		List<ServiceBean> serviceDetailsByCategory = serviceDAO.getServiceDetailsByCategory(ltaf);
		baseBean.setDataList(serviceDetailsByCategory);
		return baseBean;
	}
}
