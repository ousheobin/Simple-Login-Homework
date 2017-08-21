package cn.oushaobin.crm.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Action;
import com.tentcoo.service.UserService;
import com.tentcoo.service.impl.UserServiceImpl;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class AdminAction implements Action, ServletRequestAware {
	
	private UserService userService;
	private HttpServletRequest request;
	
	public AdminAction(){
		userService = new UserServiceImpl();
	}
	

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public String execute() throws Exception {
		if(request.getSession().getAttribute("auth")==null || !request.getSession().getAttribute("auth").equals("admin")){
			return ERROR;
		}
		request.setAttribute("customers", userService.getCustomerList());
		return SUCCESS;
	}

}
