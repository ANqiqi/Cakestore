package com.bear.cakeonline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bear.cakeonline.dao.GoodsDao;
import com.bear.cakeonline.entity.Goods;

@Service
public class GoodsServiceImpl implements GoodsService{
	 @Autowired
	    private GoodsDao goodsDao;
	@Override
	public Goods getGoods(int goodsId) {
		// TODO Auto-generated method stub
		return goodsDao.getGoods(goodsId);
	}

	@Override
	public Goods getGoods(String goodsName) {
		// TODO Auto-generated method stub
		return goodsDao.getGoods(goodsName);
	}

	@Override
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsDao.addGoods(goods);
	}

	@Override
	public boolean deleteGoods(int goodsId) {
		// TODO Auto-generated method stub
		return goodsDao.deleteGoods(goodsId);
	}

	@Override
	public boolean updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.updateGoods(goods);
	}

	@Override
	public List<Goods> getGoodsByKeyWord(String searchKeyWord) {
		// TODO Auto-generated method stub
	
		return goodsDao.getGoodsBykeyWord(searchKeyWord);
	}

	@Override
	public List<Goods> getGoodsByGoodsTypeId(int typeId) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsByGoodsTypeId(typeId);
	}

	@Override
	public List<Goods> getAllProduct() {
		// TODO Auto-generated method stub
		return goodsDao.getAllProduct();
	}
	
}
