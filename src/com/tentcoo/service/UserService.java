package com.tentcoo.service;

import java.util.List;

import cn.oushaobin.crm.entity.CustomerEntity;

public interface UserService {
	
	public boolean comfirmAdminLogin(String username,String password);
	
	public CustomerEntity getCustomerByUsername(String username,String password);
	
	public CustomerEntity getCustomerByUsername(String username);
	
	public void addCutomer(CustomerEntity customer);
	
	public List<CustomerEntity> getCustomerList();
	
}
