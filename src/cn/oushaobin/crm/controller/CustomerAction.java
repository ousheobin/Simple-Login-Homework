package cn.oushaobin.crm.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.tentcoo.service.UserService;
import com.tentcoo.service.impl.UserServiceImpl;

import cn.oushaobin.crm.entity.CustomerEntity;

public class CustomerAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	
	private static Logger logger = Logger.getLogger(CustomerAction.class);

	private static final long serialVersionUID = -8679944217642991584L;

	private String username;
	private String password;
	private String address;
	private String email;
	private Date birthday;

	private UserService userService;
	private HttpServletRequest servletRequest;
	private HttpServletResponse servletResponse;

	public CustomerAction() {
		userService = new UserServiceImpl();
	}

	public String register() throws IOException {
		CustomerEntity customer = new CustomerEntity();
		System.out.println(customer);
		if(userService.getCustomerByUsername(username)!=null){
			this.addFieldError("username", "This is username is already regisitered.");
			return INPUT;
		}
		try{
			customer.setAddress(address);
			customer.setBirthday(birthday);
			customer.setEmail(email);
			customer.setPassword(password);
			customer.setUsername(username);
			userService.addCutomer(customer);
		}catch(Exception e){
			logger.debug("Catch exception while handling register request:",e);
			servletRequest.setAttribute("hints", "<div class=\"alert alert-danger\" role=\"alert\" style=\"margin-right: -15px;margin-left: -15px;\">Oops，Something wrong was happend... We feel sorry abou that.</div>");
			return ERROR;
		}
		servletRequest.setAttribute("hints", "<div class=\"alert alert-success\" role=\"alert\" style=\"margin-right: -15px;margin-left: -15px;\">Hey ! Regisiter is finished~ Login to system please.</div>");
		return SUCCESS;
	}

	public String showIndex() throws IOException {
		if(servletRequest.getSession().getAttribute("auth") == null){
			servletResponse.sendRedirect(servletRequest.getContextPath());
		}
		return SUCCESS;

	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

}
