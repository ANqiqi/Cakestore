package com.bear.cakeonline.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bear.cakeonline.entity.Goods;


@Repository
public class GoodsDaoImpl implements GoodsDao{
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public Goods getGoods(int goodsId) {
		// TODO Auto-generated method stub
		String hql="from Goods where goodsId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, goodsId);
		return (Goods)query.uniqueResult();
	}

	@Override
	public Goods getGoods(String goodsName) {
		// TODO Auto-generated method stub
		String hql="from Goods where goodsName=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, goodsName);
		
		return (Goods)query.uniqueResult();
	}

	@Override
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(goods);
	}

	@Override
	public boolean deleteGoods(int goodsId) {
		// TODO Auto-generated method stub
		String hql="delete Goods where goodsId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, goodsId);
		return query.executeUpdate() > 0;
	}

	@Override
	public boolean updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		String hql="update Goods set goodsName=?,goodsTypeId=?,goodsDescript=?,goodsPrice=?,goodsImagePath=?,sellCount=?,where goodsId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, goods.getGoodsName());
		query.setParameter(1, goods.getGoodsTypeId());
		query.setParameter(2, goods.getGoodsDescript());
		query.setParameter(3, goods.getGoodsPrice());
		query.setParameter(4, goods.getGoodsImagePath());
		query.setParameter(5, goods.getSellCount());
		query.setParameter(6, goods.getGoodsId());
		return query.executeUpdate() > 0;
	}

	@Override
	public List<Goods> getGoodsByGoodsTypeId(int typeId) {
		// TODO Auto-generated method stub
		String hql="from Goods where TypeId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, typeId);
		return query.list();
	}

	@Override
	public List<Goods> getGoodsBykeyWord(String searchKeyWord) {
		// TODO Auto-generated method stub
		String queryKeyWord = "%";
		for(int i=0;i<searchKeyWord.length();i++) {
			queryKeyWord += String.valueOf(searchKeyWord.charAt(i)+"%");
			
		}
		System.out.println("我搜索了"+queryKeyWord);
		String hql="from Goods where Goodsname like ? or keyword like ?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, queryKeyWord);
		query.setParameter(1, queryKeyWord);
		
		return query.list();
	}

	@Override
	public List<Goods> getAllProduct() {
		// TODO Auto-generated method stub
		String hql="from Goods";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

}
