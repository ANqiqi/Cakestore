package com.bear.cakeonline.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bear.cakeonline.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public Customer getCustomer(int customerId) {
		String hql="from Customer where customerId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, customerId);
		
		return (Customer)query.uniqueResult();
	}

	@Override
	public Customer getCustomer(String customerNameorEmail) {
		String hql="from Customer where customerEmail=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, customerNameorEmail);
		if(query.uniqueResult() == null) {
			hql="from Customer where customerName=?";
			query=sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter(0, customerNameorEmail);
			
		}
		return (Customer)query.uniqueResult();
	}

	@Override
	public void addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
		
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		String hql="delete Customer where id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, customerId);
		return query.executeUpdate() >0;
		
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		String hql="update Customer set customerName=?,customerEmail=?,customerTrueName=?,where customerId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, customer.getCustomerName());
		query.setParameter(1, customer.getCustomerEmail());
		query.setParameter(2,customer.getCustomerEmail());
		query.setParameter(3, customer.getCustomerId());
		
		return query.executeUpdate() >0;
	}

	@Override
	public List<Customer> getAllUser() {
		String hql="from Customer";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	
}
