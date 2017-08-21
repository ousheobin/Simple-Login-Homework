package cn.oushaobin.crm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;
import com.tentcoo.service.UserService;
import com.tentcoo.service.impl.UserServiceImpl;

import cn.oushaobin.crm.entity.CustomerEntity;

public class LoginAction implements Action, ServletRequestAware,ServletResponseAware {

	private UserService userService;

	private String type;
	private String username;
	private String password;

	private HttpServletRequest request;
	private HttpServletResponse response;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}



	public LoginAction() {
		userService = new UserServiceImpl();
	}

	@Override
	public String execute() throws Exception {
		if (type!=null && type.equals("admin")) {
			boolean isLogin = userService.comfirmAdminLogin(username, password);
			if (isLogin) {
				request.getSession().setAttribute("auth", "admin");
				response.sendRedirect(request.getContextPath()+"/admin/index.action");
			}
		} else if (type!=null && type.equals("user")) {
			CustomerEntity customer = userService.getCustomerByUsername(username, password);
			if (customer != null) {
				request.getSession().setAttribute("auth", "customer");
				request.getSession().setAttribute("userInfo", customer);
				response.sendRedirect(request.getContextPath()+"/customer/index.action");
			}
		}
		return ERROR;
	}
	
	public String logout() throws IOException{
		request.getSession().invalidate();
		return SUCCESS;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
