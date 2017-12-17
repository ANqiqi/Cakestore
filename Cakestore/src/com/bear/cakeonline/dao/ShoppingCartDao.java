package com.bear.cakeonline.dao;

import java.util.List;

import com.bear.cakeonline.entity.ShoppingCart;



public interface ShoppingCartDao {
	public ShoppingCart getshoppingCart(int customerId,int goodsId);
	public void addshoppingCart(ShoppingCart shoppingCart);
	public boolean deleteshoppingCart(int customerId,int goodsId);
	public boolean updateshoppingCart(ShoppingCart shoppingCart);
	public List<ShoppingCart>getshoppingCart(int customerId);
}
