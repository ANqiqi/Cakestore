package com.bear.cakeonline.dao;

import java.util.List;

import com.bear.cakeonline.entity.Orders;



public interface OrdersDao {
	public Orders getorders(int customerId,int goodsId,String time);
	public void addorders(Orders orders);
	public boolean deleteorders(int customerId,int goodsId);
	public boolean updateorders(Orders orders);
	public List<Orders>getorders(int customerId);
	public List<Orders>getAllorders();
	public List<Orders>getordersByOrderType(int ordertype);
	public boolean getCustomerGoodsorder(int customerId,int goodsId);
}
