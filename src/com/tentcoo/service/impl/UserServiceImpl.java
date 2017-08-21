package com.tentcoo.service.impl;

import java.util.List;
import java.util.Map;

import com.tentcoo.service.UserService;

import cn.oushaobin.crm.constant.AdminConfig;
import cn.oushaobin.crm.dao.CustomerDao;
import cn.oushaobin.crm.dao.impl.CustomerDaoImpl;
import cn.oushaobin.crm.entity.CustomerEntity;

public class UserServiceImpl implements UserService {
	
	private CustomerDao customerDao;
	
	public UserServiceImpl(){
		customerDao = new CustomerDaoImpl();
	}

	@Override
	public boolean comfirmAdminLogin(String username, String password) {
		Map<String,String> adminMap = AdminConfig.getAdminMap();
		if(adminMap.containsKey(username)){
			if(adminMap.get(username).equals(password)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	@Override
	public CustomerEntity getCustomerByUsername(String username, String password) {
		return customerDao.getCustomer(username, password);
	}

	@Override
	public void addCutomer(CustomerEntity customer) {
		customerDao.addCustomer(customer);
	}

	@Override
	public List<CustomerEntity> getCustomerList() {
		return customerDao.getAllCustomer();
	}

	@Override
	public CustomerEntity getCustomerByUsername(String username) {
		return customerDao.getCustomerByUsername(username);
	}

}
