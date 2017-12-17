package com.bear.cakeonline.dao;

import java.util.List;

import com.bear.cakeonline.entity.CustomerDetail;

 

public interface CustomerDetailDao {
	public CustomerDetail getCustomerDetail(int customerId);
	public void addCustomerDetail(CustomerDetail customerDetail);
	public boolean deleteCustomerDetail(int customerId);
	public boolean updateCustomerDetail(CustomerDetail customerDetail);
	public List<CustomerDetail>getAllCustomerDetail();
}
