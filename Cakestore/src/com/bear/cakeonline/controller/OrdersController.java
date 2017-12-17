package com.bear.cakeonline.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.bear.cakeonline.entity.Goods;
import com.bear.cakeonline.entity.Orders;
import com.bear.cakeonline.service.GoodsService;
import com.bear.cakeonline.service.OrdersService;


@Controller
public class OrdersController {
	@Resource
    private GoodsService goodsService;
    @Resource
    private OrdersService ordersService;

    @RequestMapping(value = "/shopping_record")
    public String shopping_record(){
        return "shopping_record";
    }

    @RequestMapping(value = "/shopping_handle")
    public String shopping_handle(){
        return "shopping_handle";
    }

    @RequestMapping(value = "/addorders",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addorders(int customerId,int goodsId,int counts){
        System.out.println("我添加了"+customerId+" "+goodsId);
        String result = null;
        Goods goods = goodsService.getGoods(goodsId);
        if(counts<=goods.getSellCount()) {
            Orders orders = new Orders();
            orders.setCustomerId(customerId);
            orders.setGoodsId(goodsId);
            orders.setGoodsPrice(goods.getGoodsPrice() * counts);
            orders.setCounts(counts);
            orders.setOrdertype(0);
            Date date = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            orders.setTime(sf.format(date));
            goods.setSellCount(goods.getSellCount()-counts);
            goodsService.updateGoods(goods);
            ordersService.addorders(orders);
            result = "success";
        }
        else{
            result = "unEnough";
        }
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("result",result);
        return resultMap;
    }

    @RequestMapping(value = "/changeorders",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> changeorders(int customerId,int goodsId,String time,int ordertype){
        System.out.println("我接收了"+customerId+" "+goodsId+" "+time+" "+ordertype);
        Orders orders = ordersService.getorders(customerId,goodsId,time);
        System.out.println("我获取到了了"+orders.getTime());
        orders.setOrdertype(ordertype);
        ordersService.updateorders(orders);

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("result","success");
        System.out.println("我成功fanhui了");
        return resultMap;
    }

    @RequestMapping(value = "/getorders",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getorders(int customerId){
        List<Orders> ordersList = ordersService.getorders(customerId);
        String shoppingRecords = JSONArray.toJSONString(ordersList);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("result",shoppingRecords);
        return resultMap;
    }

    @RequestMapping(value = "/getordersByOrderType",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getordersByOrderType(int ordertype){
        List<Orders> shoppingRecordList = ordersService.getordersByOrderType(ordertype);
        String shoppingRecords = JSONArray.toJSONString(shoppingRecordList);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("result",shoppingRecords);
        return resultMap;
    }

    @RequestMapping(value = "/getAllShoppingRecords",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getAllShoppingRecords(){
//        System.out.println("wo在这里i");
        List<Orders> ordersList = ordersService.getAllorders();
        String orders = JSONArray.toJSONString(ordersList);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("result",orders);
//        System.out.println("我反悔了"+shoppingRecords);
        return resultMap;
    }

    @RequestMapping(value = "/getCustomerGoodsorder",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getCustomerGoodsorder(int customerId,int goodsId){
        String result = "false";
        if(ordersService.getCustomerGoodsorder(customerId,goodsId)){
            result = "true";
        }
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("result",result);
        return resultMap;
    }
}
