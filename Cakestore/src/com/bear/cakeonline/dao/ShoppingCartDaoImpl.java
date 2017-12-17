package com.bear.cakeonline.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bear.cakeonline.entity.ShoppingCart;
 

@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao{
	 @Resource
	 private SessionFactory sessionFactory;
	@Override
	public ShoppingCart getshoppingCart(int customerId, int goodsId) {
		// TODO Auto-generated method stub
		String hql="from shoppingCart where customerId=? and goodsId=?";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, customerId);
		query.setParameter(1, goodsId);
		return (ShoppingCart)query.uniqueResult();
	}

	@Override
	public void addshoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(shoppingCart);
	}

	@Override
	public boolean deleteshoppingCart(int customerId, int goodsId) {
		// TODO Auto-generated method stub
		String hql="delete shoppingCart where customerId=?and goodsId=?";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, customerId);
		query.setParameter(1, goodsId);
		
		return query.executeUpdate() >0;
	
	}

	@Override
	public boolean updateshoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		String hql="update shoppingCart set goodsPrice=?,counts=?,where customerId=? and goodsId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, shoppingCart.getGoodsPrice());
		query.setParameter(1, shoppingCart.getCounts());
		query.setParameter(2, shoppingCart.getCustomerId());
		query.setParameter(3, shoppingCart.getGoodsId());
		
		return query.executeUpdate() >0;
	}

	@Override
	public List<ShoppingCart> getshoppingCart(int customerId) {
		// TODO Auto-generated method stub
		String hql="from shoppingCart where customerId";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, customerId);
		return query.list();
		
	}

}
