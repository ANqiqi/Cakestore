package com.bear.cakeonline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bear.cakeonline.dao.CustomerDao;
import com.bear.cakeonline.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
    private CustomerDao customerDao;
	@Override
	public Customer getCustomer(int customerId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(customerId);
	}

	@Override
	public Customer getCustomer(String customerNameorEmail) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(customerNameorEmail);
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return customerDao.deleteCustomer(customerId);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.updateCustomer(customer);
	}

	@Override
	public List<Customer> getAllUser() {
		// TODO Auto-generated method stub
		return customerDao.getAllUser();
	}

}
