package com.bear.cakeonline.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bear.cakeonline.entity.Orders;

@Repository
public class AdminOrdersDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 查找所有订单
	 * @return
	 */
	public List<Orders> findAllOrders(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Orders");
		return q.list();
	}
	/**
	 * 通过id查询订单
	 * @param id
	 * @return
	 */
	public Orders selectByOrderid(int goodsId) {
		return this.sessionFactory.getCurrentSession().get(Orders.class,goodsId);
	}
	/**
	 * 分页查找已提交的所有订单
	 * @param pagr
	 * @return
	 */
	public List<Orders> findAllOrders(int page){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Orders");
		//分页
		q.setFirstResult((page-1)*8);
		q.setMaxResults(8);		
		return q.list();
	}
	/**
	 * 查找属于某用户的所有已提交订单
	 * @param page
	 * @param userid
	 * @return
	 */
	public List<Orders> findAll(int page,int customerId){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Orders where customerId="+customerId);
		//分页
		q.setFirstResult((page-1)*8);
		q.setMaxResults(8);		
		return q.list();
	}
	/**
	 * 查找订单总数
	 * @return
	 */
	public int findOrderCount(){
		Query qc=this.sessionFactory.getCurrentSession().createQuery("select COUNT(goodsId) from Orders");
		Number number = (Number)qc.uniqueResult();
		int count = number.intValue();
		return count;
	} 	
	/**
	 * 删除一个订单
	 * @param id
	 */
	public void deleteOrder(int goodsId) {
		Query q=this.sessionFactory.getCurrentSession().createQuery("delete from Orders where goodsId="+goodsId);
		q.executeUpdate();
	}
	/**
	 * 更新一个订单
	 * @param order
	 */
	public void updateOrder(Orders order) {
		this.sessionFactory.getCurrentSession().update(order);
	}
	/**
	 * 保存一个订单
	 * @param order
	 */
	public void saveOrder(Orders order) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(order);
	}
}
