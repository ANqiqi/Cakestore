package com.bear.cakeonline.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bear.cakeonline.entity.Goods;

@Repository
public class AdminGoodsDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public List<Goods> findAll(int page){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Goods");
		q.setFirstResult((page-1)*9);
		q.setMaxResults(9);	
		return q.list();
	}	
	public Goods selectByGoodsid(int goodsId) {
		return this.sessionFactory.getCurrentSession().get(Goods.class,goodsId);
	}
	 public int findRowsCount(){
			Query qc=this.sessionFactory.getCurrentSession().createQuery("select COUNT(goodsId) from Goods");
			Number number = (Number)qc.uniqueResult();
			int count = number.intValue();
			return count;
		} 
	 public void deleteGoods(int goodsId) {
			Query q=this.sessionFactory.getCurrentSession().createQuery("delete from Goods where goodsId="+goodsId);
			q.executeUpdate();
		}
	 public void updateGoods(Goods goods) {
			this.sessionFactory.getCurrentSession().saveOrUpdate(goods);
		}
	 public void saveGoods(Goods goods) {
			this.sessionFactory.getCurrentSession().save(goods);
		}
}
