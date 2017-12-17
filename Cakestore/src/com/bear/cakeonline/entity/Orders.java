package com.bear.cakeonline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Orders")
public class Orders {
	private int ordertype;
	private int customerId;
	private int goodsId;
	private int counts;
	private double goodsPrice;
	private String time;
	
	@Id
	@Column(name="customerid")
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(int ordertype) {
		this.ordertype = ordertype;
	}
	
}
