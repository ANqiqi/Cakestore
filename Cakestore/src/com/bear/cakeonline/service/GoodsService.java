package com.bear.cakeonline.service;

import java.util.List;

import com.bear.cakeonline.entity.Goods;



public interface GoodsService {
	public Goods getGoods(int goodsId);

    public Goods getGoods(String goodsName);

    public void addGoods(Goods goods);

    public boolean deleteGoods(int goodsId);

    public boolean updateGoods(Goods goods);

    public List<Goods> getGoodsByKeyWord(String searchKeyWord);

    public List<Goods>getGoodsByGoodsTypeId(int typeId);

    public List<Goods> getAllProduct();
}
