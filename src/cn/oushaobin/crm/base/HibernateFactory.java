package cn.oushaobin.crm.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateFactory {
	private static SessionFactory sessionFactory;
	
	static {
		try {
			Configuration cfg = new Configuration().configure("/config/hibernate.cfg.xml");
			ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(cfg.getProperties());  
	        ServiceRegistry registry = builder.buildServiceRegistry();   
	        sessionFactory = cfg.buildSessionFactory(registry);  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}