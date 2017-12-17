package com.bear.cakeonline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="goods")
public class Goods {
	private int goodsId;
	private String goodsName;
	private int goodsTypeId;
	private String goodsDescript;
	private double goodsPrice;
	private String  goodsImagePath ;
	private int  sellCount;
	private String keyWord;
	private GoodsType goodstype;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	public String getGoodsDescript() {
		return goodsDescript;
	}
	public void setGoodsDescript(String goodsDescript) {
		this.goodsDescript = goodsDescript;
	}
	public double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsImagePath() {
		return goodsImagePath;
	}
	public void setGoodsImagePath(String goodsImagePath) {
		this.goodsImagePath = goodsImagePath;
	}
	public int getSellCount() {
		return sellCount;
	}
	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	@ManyToOne
	@JoinColumn(name="goodsid")
	public GoodsType getGoodstype() {
		return goodstype;
	}
	public void setGoodstype(GoodsType goodstype) {
		this.goodstype = goodstype;
	}
}
