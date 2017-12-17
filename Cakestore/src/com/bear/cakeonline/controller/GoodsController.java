package com.bear.cakeonline.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bear.cakeonline.entity.Goods;
import com.bear.cakeonline.service.GoodsService;


@Controller
public class GoodsController {
	 @Resource
	    private GoodsService goodsService;
	 @RequestMapping(value = "/getAllProduct")
	 @ResponseBody
	 public String getAllGoods(){
	        List<Goods> goodsList = new ArrayList<>();
	        goodsList = goodsService.getAllProduct();
	        String allProducts = JSONArray.toJSONString(goodsList);
	        Map<String,Object> resultMap = new HashMap<String,Object>();
	        resultMap.put("allProducts",allProducts);
	        return "goods";
	    }

	    @RequestMapping(value = "/deleteGoods", method = RequestMethod.GET)
	    @ResponseBody
	    public String deleteGoods(Integer goodsId) {
	        String result ="fail";
	        if(goodsService.deleteGoods(goodsId)){
	            result="success";
	        }
	        Map<String,Object> resultMap = new HashMap<String,Object>();
	        resultMap.put("result",result);
	        return "goods";
	    }

	    @RequestMapping(value = "/addGoods", method = RequestMethod.GET)
	    @ResponseBody
	    public String addGoods(String goodsName,String goodsDescript,String keyWord,int goodsPrice,int sellcount,int goodsTypeId) {
	        System.out.println("添加了商品："+goodsName);
	        String result ="fail";
	        Goods goods = new Goods();
	        goods.setGoodsName(goodsName);
	        goods.setGoodsDescript(goodsDescript);
	        goods.setKeyWord(keyWord);
	        goods.setGoodsPrice(goodsPrice);
	        goods.setSellCount(sellcount);
	        goods.setGoodsTypeId(goodsTypeId);
	        goodsService.addGoods(goods);
	        result = "success";
	        Map<String,Object> resultMap = new HashMap<String,Object>();
	        resultMap.put("result",result);
	        return "goods";
	    }

	    @RequestMapping(value = "/goodsDetail")
	    @ResponseBody
	    public  String goodsDetail(Integer goodsId, HttpSession httpSession) {
	        System.out.println("I am here!"+goodsId);
	        Goods goods = goodsService.getGoods(1);
	        httpSession.setAttribute("goods",goods);
	        System.out.print("I am here"+goods.getGoodsName());
	        Map<String,Object> resultMap = new HashMap<String,Object>();
	        resultMap.put("result","success");
	        return "goods";
	    }

	    @RequestMapping(value = "/goods_detail")
	    public String goods_detail() {
	        return "goods_detail";
	    }

	    @RequestMapping(value = "/searchPre", method = RequestMethod.GET)
	    @ResponseBody
	    public String searchPre(String searchKeyWord,HttpSession httpSession) {
	        httpSession.setAttribute("searchKeyWord",searchKeyWord);
	        Map<String,Object> resultMap = new HashMap<String,Object>();
	        resultMap.put("result","success");
	        return "goods";
	    }

	    @RequestMapping(value = "/search")
	    public String search() {
	        return "search";
	    }

	    @RequestMapping(value = "/searchGoods", method = RequestMethod.GET)
	    @ResponseBody
	    public String searchProduct(String searchKeyWord){
	        System.out.println("我到了SearchProduct"+searchKeyWord);
	        List<Goods> goodsList = new ArrayList<Goods>();
	        goodsList = goodsService.getGoodsByKeyWord(searchKeyWord);
	        String searchResult = JSONArray.toJSONString(goodsList);
	        Map<String,Object> resultMap = new HashMap<String,Object>();
	        resultMap.put("result",searchResult);
	        System.out.println("我返回了"+searchResult);
	        return "goods";
	    }

	    @RequestMapping(value = "/getGoodsById", method = RequestMethod.GET)
	    @ResponseBody
	    public String getGoodsById(Integer goodsId) {
	        Goods goods = goodsService.getGoods(goodsId);
	        String result = JSON.toJSONString(goods);
	        Map<String,Object> resultMap = new HashMap<String,Object>();
	        resultMap.put("result",result);
	        return "goods";
	    }

	    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	    @ResponseBody
	    public String uploadFile(@RequestParam MultipartFile productImgUpload,String goodsName, HttpServletRequest request) {
	        String result = "fail";
	        try{
	            if(productImgUpload != null && !productImgUpload.isEmpty()) {
	                String fileRealPath = request.getSession().getServletContext().getRealPath("/static/img");
	                int goodsId = goodsService.getGoods(goodsName).getGoodsId();
	                String fileName = String.valueOf(goodsId)+".jpg";
	                File fileFolder = new File(fileRealPath);
	                System.out.println("fileRealPath=" + fileRealPath+"/"+fileName);
	                if(!fileFolder.exists()){
	                    fileFolder.mkdirs();
	                }
	                File file = new File(fileFolder,fileName);
	                productImgUpload.transferTo(file);
	                result = "success";
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        Map<String,Object> resultMap = new HashMap<String,Object>();
	        resultMap.put("result",result);
	        return "goods";
	    }
}
