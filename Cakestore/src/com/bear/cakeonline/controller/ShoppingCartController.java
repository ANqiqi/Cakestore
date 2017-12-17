package com.bear.cakeonline.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.bear.cakeonline.entity.ShoppingCart;
import com.bear.cakeonline.service.GoodsService;
import com.bear.cakeonline.service.ShoppingCartService;

@Controller
public class ShoppingCartController {
	@Resource
    private GoodsService goodsService;
    @Resource
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/shopping_cart")
    public String shopping_cart(){
        return "shopping_cart";
    }

    @RequestMapping(value = "/addShoppingCart",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addShoppingCart(int customerId,int goodsId,int counts){
        System.out.println("数量为"+counts);
        ShoppingCart shoppingCart = shoppingCartService.getshoppingCart(customerId,goodsId);
        if(shoppingCart == null){
            ShoppingCart shoppingCart1 = new ShoppingCart();
            shoppingCart1.setCustomerId(customerId);
            shoppingCart1.setGoodsId(goodsId);
            shoppingCart1.setCounts(counts);
            shoppingCart1.setGoodsPrice(goodsService.getGoods(goodsId).getGoodsPrice()*counts);
            shoppingCartService.addshoppingCart(shoppingCart1);
        }
        else{
            shoppingCart.setCounts(shoppingCart.getCounts()+counts);
            shoppingCart.setGoodsPrice(goodsService.getGoods(goodsId).getGoodsPrice()*shoppingCart.getCounts());
            shoppingCartService.updateshoppingCart(shoppingCart);
        }
        Map<String, Object> resultMap = new HashMap<String,Object>();
        resultMap.put("result","success");
        System.out.println("我返回了");
        return resultMap;
    }

    @RequestMapping(value = "/getshoppingCart",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getshoppingCart(int customerId){
        List<ShoppingCart> shoppingCartList = shoppingCartService.getshoppingCart(customerId);
        String shoppingCart = JSONArray.toJSONString(shoppingCartList);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("result",shoppingCart);
        return resultMap;
    }

    @RequestMapping(value = "/deleteshoppingCart",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteshoppingCart(int customerId,int goodsId){
        shoppingCartService.deleteshoppingCart(customerId,goodsId);
        Map<String, Object> resultMap = new HashMap<String,Object>();
        resultMap.put("result","success");
        System.out.println("我返回了");
        return resultMap;
    }
}

