package com.bear.cakeonline.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.cakeonline.entity.Customer;
import com.bear.cakeonline.entity.Orders;
import com.bear.cakeonline.service.AdminOrdersServiceImpl;
import com.bear.cakeonline.service.CustomerServiceImpl;

@Controller
@RequestMapping("adminorder")
public class AdminOrdersController {
	@Resource
	private AdminOrdersServiceImpl  adminOrdersServiceImpl ;
	@Resource CustomerServiceImpl customerServiceImpl;
	
	/**
	 * 分页查找所有订单
	 * @param op
	 * @param response
	 * @param session
	 * @throws IOException
	 */
		@RequestMapping("/listAdminOrder")
		public void ListAdminCake(@RequestParam("aopageIndex")Integer op,
				HttpServletResponse response,HttpSession session) throws IOException {
		List<Orders> orderlist=this.adminOrdersServiceImpl.listAllOrders(op);
        List<Integer> customerId=new ArrayList<Integer>();
        for(Orders or:orderlist) {
        	customerId.add(or.getGoodsId());
        }
        session.setAttribute("customerId", customerId);
		//分页
		int pageCount=this.adminOrdersServiceImpl.findOrderPageCount();
		session.setAttribute("aopageCount",pageCount);
		int pageIndex=1;
		session.setAttribute("aopageIndex",pageIndex);
		if(0==pageIndex|| pageIndex<0) {
			session.setAttribute("aopageIndex",1);				 
		}else {
            session.setAttribute("aopageIndex",pageIndex);
		}			
		session.setAttribute("adminorderlist", orderlist);
		response.sendRedirect("/Cakestore/adminOrders.jsp");
	}
		
	/**
	* 删除一个订单
	* @param orderid
	* @param response
	* @param session
    * @throws IOException
	*/
    @RequestMapping("/deleteOneOrder")
	public void AdminDeleteOrder(
		        @RequestParam("goodsId")String goodsId,
				HttpServletResponse response,
				HttpSession session) throws IOException {
		this.adminOrdersServiceImpl.deleteOneOrder(Integer.parseInt(goodsId));
		response.sendRedirect("/Cakestore/adminOrders.jsp");
	}
    /**
     * 增加或修改一个订单
     * @param oid
     * @param cid
     * @param cname
     * @param count
     * @param total
     * @param userid
     * @param response
     * @param request
     * @throws IOException
     */
	@RequestMapping("/saveOneOrders")		
	public void saveOneOrders(
			@RequestParam("goodsId")Integer goodsId,
			@RequestParam("customerId")Integer customerId,
			@RequestParam("ordertype")Integer ordertype,
			@RequestParam("counts")Integer counts,
			@RequestParam("goodsPrice")Double goodsPrice,
			@RequestParam("time")String time,
			HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		Orders order=new Orders();
		//更新一个订单
		List <Orders> orderL=this.adminOrdersServiceImpl.listAllOrders();
		for(Orders torder: orderL) {
			if(torder.getGoodsId()==goodsId) {
				order=this.adminOrdersServiceImpl.selectByOrderid(goodsId);
				order.setGoodsId(goodsId);
				order.setTime(time);
				order.setOrdertype(ordertype);
				order.setCounts(counts);
				order.setGoodsPrice(goodsPrice);
				Customer customer=this.customerServiceImpl.getCustomer(customerId);
				order.setCustomerId(customerId);
				this.adminOrdersServiceImpl.updateOneOrder(order);;
				request.setAttribute("oisUpdated", true);
				break;
			}else {
				request.setAttribute("oisUpdated",false);
			}				
		}		
		//保存一个订单
		if(request.getAttribute("oisUpdated").equals(false)) {	
			order.setGoodsId(goodsId);
			order.setTime(time);
			order.setOrdertype(ordertype);
			order.setCounts(counts);
			order.setGoodsPrice(goodsPrice);
			Customer customer=this.customerServiceImpl.getCustomer(customerId);
			order.setCustomerId(customerId);
			this.adminOrdersServiceImpl.addOneOrder(order);
			}
		response.sendRedirect("/Cakestore/adminOrders.jsp");
			
		}
}
