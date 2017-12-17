package com.bear.cakeonline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bear.cakeonline.dao.CustomerDetailDao;
import com.bear.cakeonline.entity.CustomerDetail;

@Service
public class CustomerDetailServiceImpl implements CustomerDetailService{
	@Autowired
    private CustomerDetailDao customerDetailDao;
	@Override
	public CustomerDetail getCustomerDetail(int customerId) {
		// TODO Auto-generated method stub
		return customerDetailDao.getCustomerDetail(customerId);
	}

	@Override
	public void addCustomerDetail(CustomerDetail customerDetail) {
		// TODO Auto-generated method stub
		customerDetailDao.addCustomerDetail(customerDetail);
	}

	@Override
	public boolean deleteCustomerDetail(int customerId) {
		// TODO Auto-generated method stub
		return customerDetailDao.deleteCustomerDetail(customerId);
	}

	@Override
	public boolean updateCustomerDetail(CustomerDetail customerDetail) {
		// TODO Auto-generated method stub
		return customerDetailDao.updateCustomerDetail(customerDetail);
	}

	@Override
	public List<CustomerDetail> getAllCustomerDetail() {
		// TODO Auto-generated method stub
		return customerDetailDao.getAllCustomerDetail();
	}

}
