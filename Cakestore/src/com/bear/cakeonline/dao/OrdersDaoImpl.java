package com.bear.cakeonline.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bear.cakeonline.entity.Orders;


@Repository
public class OrdersDaoImpl implements OrdersDao{
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public Orders getorders(int customerId, int goodsId, String time) {
		// TODO Auto-generated method stub
		String hql="from orders where customerId=? and goodsId=? and time=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, customerId);
		query.setParameter(1, goodsId);
		query.setParameter(2, time);
		return(Orders)query.uniqueResult();
	}

	@Override
	public void addorders(Orders orders) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(orders);
	}

	@Override
	public boolean deleteorders(int customerId, int goodsId) {
		// TODO Auto-generated method stub
		String hql="delete orders where customerId=? and goodsId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, customerId);
		query.setParameter(1, goodsId);
		return query .executeUpdate() > 0;
	}

	@Override
	public boolean updateorders(Orders orders) {
		// TODO Auto-generated method stub
		String hql="update orders set ordertype=? where customerId=? and goodsId=? and time=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0,orders.getOrdertype());
        query.setParameter(1,orders.getCustomerId());
        query.setParameter(2,orders.getGoodsId());
        query.setParameter(3,orders.getTime());
		return query.executeUpdate() > 0;
	}

	@Override
	public List<Orders> getorders(int customerId) {
		// TODO Auto-generated method stub
		String hql="from orders where customerId=?";
		 Query query = sessionFactory.getCurrentSession().createQuery(hql);
	        query.setParameter(0,customerId);
	        return query.list();
	}

	@Override
	public List<Orders> getAllorders() {
		// TODO Auto-generated method stub
		String hql = "from orders";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
	}

	@Override
	public List<Orders> getordersByOrderType(int ordertype) {
		// TODO Auto-generated method stub
		String hql = "from orders where orderStatus=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,ordertype);
        return query.list();
	}

	@Override
	public boolean getCustomerGoodsorder(int customerId, int goodsId) {
		String hql = "from orders where customerId=? and goodsId=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,customerId);
        query.setParameter(1,goodsId);
        return query.list().size()>0;
	}

}
