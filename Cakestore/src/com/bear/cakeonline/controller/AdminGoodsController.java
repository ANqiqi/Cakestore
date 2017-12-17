package com.bear.cakeonline.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.cakeonline.entity.Goods;
import com.bear.cakeonline.service.AdminGoodsServiceImpl;
import com.bear.cakeonline.service.GoodsServiceImpl;

 

@Controller
@RequestMapping("admingoods")
public class AdminGoodsController {
	@Resource
	private AdminGoodsServiceImpl adminGoodsServiceImpl;
	@Resource 
	private GoodsServiceImpl goodsServiceImpl;
	/**
	 * 查找所有蛋糕品种
	 * @param cp
	 * @param response
	 * @param session
	 * @throws IOException
	 */
	//
	@RequestMapping("/listAdminGoods")
	public void ListAdminCake(@RequestParam("acpageIndex")Integer cp,
	HttpServletResponse response,HttpSession session) throws IOException {
		List<Goods> goodslist=this.adminGoodsServiceImpl.listAll(cp);
		//分页
		int pageCount=this.adminGoodsServiceImpl.getPageCount();	
		int pageIndex=1;	
		 if(0==pageIndex|| pageIndex<0) {
			 session.setAttribute("acpageIndex",1);
			 
		 }else {
			 session.setAttribute("acpageIndex",pageIndex);
			 	}		
		session.setAttribute("acpageIndex",pageIndex);
		session.setAttribute("acpageCount",pageCount);
		session.setAttribute("admincakelist", goodslist);
		response.sendRedirect("/Goods/adminGoods.jsp");
	}
    /**
     * 删除一个蛋糕品种
     * @param cakeid
     * @param response
     * @param session
     * @throws IOException
     */
	@RequestMapping("/deleteOneGoods")
	public void AdminDeleteGoods(@RequestParam("goodsid")String goodsid,
			HttpServletResponse response,
			HttpSession session) throws IOException {
		this.adminGoodsServiceImpl.deleteOneGoods(Integer.parseInt(goodsid));
		response.sendRedirect("/Goods/adminGoods.jsp");
	}
	/**
	 * 增加或修改一个蛋糕品种
	 * @param cid
	 * @param name
	 * @param detail
	 * @param price
	 * @param img
	 * @param img1
	 * @param img2
	 * @param img3
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/updateOneGoods")
	public void UpdateOneGoods(
			@RequestParam("goodsId")Integer goodsId,
			@RequestParam("goodsName")String goodsName,
			@RequestParam("goodsTypeId")int goodsTypeId,
			@RequestParam("goodsDescript")String goodsDescript,
			@RequestParam("goodsPrice")double goodsPrice,
			@RequestParam("goodsImagePath")String goodsImagePath,
			@RequestParam("sellCount")int sellCount,
			@RequestParam("keyWord")String keyWord,
			HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		Goods goods=new Goods();
		List<Goods> clist=this.goodsServiceImpl.getAllProduct();
		for(Goods tgoods:clist) {
			if(tgoods.getGoodsId()==goodsId) {
				goods=this.adminGoodsServiceImpl.getGoodsById(goodsId);			
				goods.setGoodsName(goodsName);
				goods.setGoodsTypeId(goodsTypeId);
				goods.setGoodsPrice(goodsPrice);
				goods.setGoodsDescript(goodsDescript);
				goods.setGoodsImagePath(goodsImagePath);
				goods.setSellCount(sellCount);
				goods.setKeyWord(keyWord);
				this.adminGoodsServiceImpl.updateOneGoods(goods);
				request.setAttribute("isUpdated", true);
				break;
			}
			else {
				request.setAttribute("isUpdated",false);
			}
		}
		if(request.getAttribute("isUpdated").equals(false)) {		
			goods.setGoodsId(goodsId);
			goods.setGoodsName(goodsName);
			goods.setGoodsTypeId(goodsTypeId);
			goods.setGoodsPrice(goodsPrice);
			goods.setGoodsDescript(goodsDescript);
			goods.setGoodsImagePath(goodsImagePath);
			goods.setSellCount(sellCount);
			goods.setKeyWord(keyWord);
		this.adminGoodsServiceImpl.addOneGoods(goods);
		}
		response.sendRedirect("/Goods/adminGoods.jsp");
	}
}
