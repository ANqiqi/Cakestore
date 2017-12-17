package com.bear.cakeonline.service;

import java.util.List;

import com.bear.cakeonline.entity.Customer;



public interface CustomerService {
	public Customer getCustomer(int customerId);
	public Customer getCustomer(String customerNameorEmail);
	public void addCustomer(Customer customer);
	public boolean deleteCustomer(int customerId);
	public boolean updateCustomer(Customer customer);
	public List<Customer>getAllUser();
}
