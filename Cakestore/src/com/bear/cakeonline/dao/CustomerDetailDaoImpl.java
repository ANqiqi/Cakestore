package com.bear.cakeonline.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bear.cakeonline.entity.CustomerDetail;

@Repository
public class CustomerDetailDaoImpl implements CustomerDetailDao{

	@Resource
	private SessionFactory sessionFactory;
	
	
	@Override
	public CustomerDetail getCustomerDetail(int customerId) {
		String hql="from CustomerDetail where customerId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, customerId);
		return (CustomerDetail)query.uniqueResult();
		
	}

	@Override
	public void addCustomerDetail(CustomerDetail customerDetail) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(customerDetail);
		
		
	}

	@Override
	public boolean deleteCustomerDetail(int customerId) {
		String hql="delete CustomerDetail where customerId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, customerId);
		return query.executeUpdate() >0 ;
	}

	@Override
	public boolean updateCustomerDetail(CustomerDetail customerDetail) {
		String hql="update CustomerDetail set customerPassword=?,customerPhone=?,customerBirthday=?,customerSex=?,customerPostNumber=?,customerAddress=?,where customerId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, customerDetail.getCustomerPassword());
		query.setParameter(1, customerDetail.getCustomerPhone());
		query.setParameter(2, customerDetail.getCustomerSex());
		query.setParameter(3, customerDetail.getCustomerBirthday());
		query.setParameter(4, customerDetail.getCustomerPostNumber());
		query.setParameter(5, customerDetail.getCustomerAddress());
		query.setParameter(6, customerDetail.getCustomerId());
		return query.executeUpdate() >0;
		
	}

	@Override
	public List<CustomerDetail> getAllCustomerDetail() {
		String hql="from CustomerDetail";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

}
