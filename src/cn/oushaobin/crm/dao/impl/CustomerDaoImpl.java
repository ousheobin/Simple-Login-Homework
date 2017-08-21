package cn.oushaobin.crm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.oushaobin.crm.base.HibernateFactory;
import cn.oushaobin.crm.dao.CustomerDao;
import cn.oushaobin.crm.entity.CustomerEntity;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void addCustomer(CustomerEntity customer) throws RuntimeException {
		Session session = HibernateFactory.getSession();
		if (session != null) {
			Transaction transaction = session.beginTransaction();
			session.save(customer);
			transaction.commit();
			if(session.isOpen()){
				session.close();
			}
		} else {
			throw new RuntimeException("Could not get session from session factory.");
		}
	}

	@Override
	public CustomerEntity getCustomer(String username, String password) throws RuntimeException {
		List<CustomerEntity> res = null;
		Session session = HibernateFactory.getSession();
		String hql = "from CustomerEntity cust where cust.username = ? and cust.password = ?";
		if (session != null) {
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setString(0, username);
			query.setString(1, password);
			res = (List<CustomerEntity>) query.list();
			transaction.commit();
			if(session.isOpen()){
				session.close();
			}
		} else {
			throw new RuntimeException("Could not get session from session factory.");
		}
		if (res != null) {
			if (res.isEmpty()) {
				return null;
			} else {
				return res.get(0);
			}
		} else {
			return null;
		}
	}

	@Override
	public List<CustomerEntity> getAllCustomer() throws RuntimeException {
		List<CustomerEntity> res = null;
		Session session = HibernateFactory.getSession();
		String hql = "from CustomerEntity";
		if (session != null) {
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			res = (List<CustomerEntity>) query.list();
			transaction.commit();
			if(session.isOpen()){
				session.close();
			}
		} else {
			throw new RuntimeException("Could not get session from session factory.");
		}
		return res;
	}

	@Override
	public CustomerEntity getCustomerByUsername(String username) {
		List<CustomerEntity> res = null;
		Session session = HibernateFactory.getSession();
		String hql = "from CustomerEntity cust where cust.username = ?";
		if (session != null) {
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setString(0, username);
			res = (List<CustomerEntity>) query.list();
			transaction.commit();
			if(session.isOpen()){
				session.close();
			}
		} else {
			throw new RuntimeException("Could not get session from session factory.");
		}
		if (res != null) {
			if (res.isEmpty()) {
				return null;
			} else {
				return res.get(0);
			}
		} else {
			return null;
		}
	}

}
