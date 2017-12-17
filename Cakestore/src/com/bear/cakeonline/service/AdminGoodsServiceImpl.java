package com.bear.cakeonline.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.cakeonline.dao.AdminGoodsDaoImpl;
import com.bear.cakeonline.entity.Goods;

@Service
@Transactional(readOnly=false)
public class AdminGoodsServiceImpl {
	@Resource
	private AdminGoodsDaoImpl adminGoodsDaoImpl;
	public List<Goods> listAll(int page){
		return this.adminGoodsDaoImpl.findAll(page);
	}
	
	public void deleteOneGoods(int goodsId) {
		this.adminGoodsDaoImpl.deleteGoods(goodsId);
	}
	/**
	 * 更新一个蛋糕
	 
	 */
	public void updateOneGoods(Goods goods) {
		this.adminGoodsDaoImpl.updateGoods(goods);
	}
	/**
	 * 增加蛋糕
	
	 */
	public void addOneGoods(Goods goods) {
		this.adminGoodsDaoImpl.saveGoods(goods);
	}
	/**
	 * 通过id查询蛋糕
	 * @return
	 */
	public Goods getGoodsById(int goodsId) {
	return this.adminGoodsDaoImpl.selectByGoodsid(goodsId);
	}
	/**
	 * 得到总页码数
	 * @return
	 */
	public int getPageCount() {
        if((this.adminGoodsDaoImpl.findRowsCount())%9==0) {
		    return (int)(this.adminGoodsDaoImpl.findRowsCount()/9);
		}else {
		    return (int)(this.adminGoodsDaoImpl.findRowsCount()/9+1);	
		}	
	}
}
