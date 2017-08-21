package cn.oushaobin.crm.dao;

import java.util.List;

import cn.oushaobin.crm.entity.CustomerEntity;

public interface CustomerDao {
	
	public void addCustomer(CustomerEntity customer);
	
	public CustomerEntity getCustomer(String username,String password);
	
	public CustomerEntity getCustomerByUsername(String username);
	
	public List<CustomerEntity> getAllCustomer();

}
