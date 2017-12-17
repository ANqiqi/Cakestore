package com.bear.cakeonline.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bear.cakeonline.entity.Admin;

@Repository
public class AdminDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	 public List<Admin> findAll(){
			int p=0;
			Query q=this.sessionFactory.getCurrentSession().createQuery("from Admin");
			q.setFirstResult((p-1)*9);
			q.setMaxResults(9);
			return q.list();
		    }
}
