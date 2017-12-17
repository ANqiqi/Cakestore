package com.bear.cakeonline.dao;

import java.util.List;

import com.bear.cakeonline.entity.Customer;



public interface CustomerDao {
	public Customer getCustomer(int customerId);
	public Customer getCustomer(String customerNameorEmail);
	public void addCustomer(Customer customer);
	public boolean deleteCustomer(int customerId);
	public boolean updateCustomer(Customer customer);
	public List<Customer>getAllUser();
}
