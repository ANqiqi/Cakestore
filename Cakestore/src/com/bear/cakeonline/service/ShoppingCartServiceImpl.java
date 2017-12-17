package com.bear.cakeonline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bear.cakeonline.dao.ShoppingCartDao;
import com.bear.cakeonline.entity.ShoppingCart;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Autowired
    private ShoppingCartDao shoppingCartDao;
	@Override
	public ShoppingCart getshoppingCart(int customerId, int goodsId) {
		// TODO Auto-generated method stub
		return shoppingCartDao.getshoppingCart(customerId,goodsId);
	}

	@Override
	public void addshoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		 shoppingCartDao.addshoppingCart(shoppingCart);
	}

	@Override
	public boolean deleteshoppingCart(int customerId, int goodsId) {
		// TODO Auto-generated method stub
		return shoppingCartDao.deleteshoppingCart(customerId,goodsId);
	}

	@Override
	public boolean updateshoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return shoppingCartDao.updateshoppingCart(shoppingCart);
	}

	@Override
	public List<ShoppingCart> getshoppingCart(int customerId) {
		// TODO Auto-generated method stub
		return shoppingCartDao.getshoppingCart(customerId);
	}

}
