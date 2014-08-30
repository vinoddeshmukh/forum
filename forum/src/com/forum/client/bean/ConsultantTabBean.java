package com.forum.client.bean;

import java.util.List;

import com.forum.common.BaseBean;
import com.forum.model.ServiceBean;

public class ConsultantTabBean  extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ServiceBean> ourServiceList;
	
	private List<ServiceBean> ourValuesList;

	public List<ServiceBean> getOurServiceList() {
		return ourServiceList;
	}

	public void setOurServiceList(List<ServiceBean> ourServiceList) {
		this.ourServiceList = ourServiceList;
	}

	public List<ServiceBean> getOurValuesList() {
		return ourValuesList;
	}

	public void setOurValuesList(List<ServiceBean> ourValuesList) {
		this.ourValuesList = ourValuesList;
	}
	
}
