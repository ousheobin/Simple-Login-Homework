package cn.oushaobin.crm.base;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Session;

public class DatabaseListener implements Servlet{
	
	private static Logger logger = Logger.getLogger(DatabaseListener.class);

	@Override
	public void destroy() {
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("Start to create hibernate session factory.");
		Session session = HibernateFactory.getSession();
		if(session!=null){
			System.out.println("Create hibernate session successfully.");
			session.close();
		}else{
			System.out.println("Create hibernate session failed.");
		}
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		
	}

}
