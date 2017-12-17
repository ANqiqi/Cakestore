package com.bear.cakeonline.dao;

import java.util.List;

import com.bear.cakeonline.entity.Goods;



public interface GoodsDao {
	public Goods getGoods(int goodsId);
	public Goods getGoods(String goodsName);
	public void addGoods(Goods goods);
	public boolean deleteGoods(int goodsId);
	public boolean updateGoods(Goods goods);
	
	public List<Goods>getGoodsByGoodsTypeId(int typeId);
	public List<Goods>getGoodsBykeyWord(String searchKeyWord);
	public List<Goods>getAllProduct();
}
