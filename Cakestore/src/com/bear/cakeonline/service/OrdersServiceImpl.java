package com.bear.cakeonline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bear.cakeonline.dao.OrdersDao;
import com.bear.cakeonline.entity.Orders;



@Service
public class OrdersServiceImpl implements OrdersService{
	@Autowired
    private OrdersDao ordersDao;
	@Override
	public Orders getorders(int customerId, int goodsId, String time) {
		// TODO Auto-generated method stub
		return ordersDao.getorders(customerId,goodsId,time);
	}

	@Override
	public void addorders(Orders orders) {
		// TODO Auto-generated method stub
		ordersDao.addorders(orders);
	}

	@Override
	public boolean deleteorders(int customerId, int goodsId) {
		// TODO Auto-generated method stub
		return ordersDao.deleteorders(customerId,goodsId);
	}

	@Override
	public boolean updateorders(Orders orders) {
		// TODO Auto-generated method stub
		return ordersDao.updateorders(orders);
	}

	@Override
	public List<Orders> getorders(int customerId) {
		// TODO Auto-generated method stub
		return ordersDao.getorders(customerId);
	}

	@Override
	public List<Orders> getAllorders() {
		// TODO Auto-generated method stub
		return ordersDao.getAllorders();
	}

	@Override
	public List<Orders> getordersByOrderType(int ordertype) {
		// TODO Auto-generated method stub
		return ordersDao.getordersByOrderType(ordertype);
	}

	@Override
	public boolean getCustomerGoodsorder(int customerId, int goodsId) {
		// TODO Auto-generated method stub
		 return ordersDao.getCustomerGoodsorder(customerId,goodsId);
	}

}
