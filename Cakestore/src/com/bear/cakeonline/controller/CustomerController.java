package com.bear.cakeonline.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bear.cakeonline.entity.Customer;
import com.bear.cakeonline.entity.CustomerDetail;
import com.bear.cakeonline.service.CustomerDetailService;
import com.bear.cakeonline.service.CustomerService;


@Controller
public class CustomerController {
	@Resource
	   CustomerService customerService;

	    @Resource
	    CustomerDetailService customerDetailService;


	    @RequestMapping(value = "/register")
	    public String register() {
	        return "register";
	    }

	    @RequestMapping(value = "/amend_info")
	    public String amend_info() {
	        return "amend_info";
	    }

	    @RequestMapping(value = "/login")
	    public String login() {
	        return "login";
	    }

	    @RequestMapping(value = "/main")
	    public String main() {
	        return "main";
	    }

	    @RequestMapping(value = "/control")
	    public String control() {
	        return "control";
	    }

	    @RequestMapping(value = "/doLogin", method = RequestMethod.GET)
	    @ResponseBody
	    public Map<String, Object> doLogin(String customerNameorEmail, String password, HttpSession httpSession) {
	        System.out.println("我接收到了登录请求" + customerNameorEmail + " " + password);
	        String result = "fail";
	        Customer customer = customerService.getCustomer(customerNameorEmail);
	        if (customer == null)
	            result = "unexist";
	        else {
	            CustomerDetail customerDetail = customerDetailService.getCustomerDetail(customer.getCustomerId());
	            if (customerDetail.getCustomerPassword().equals(password)) {
	                result = "success";
	                httpSession.setAttribute("currentUser", customer);
	            } else
	                result = "wrong";
	        }
	        Map<String, Object> resultMap = new HashMap<String, Object>();
	        resultMap.put("result", result);
	        return resultMap;
	    }

	    @RequestMapping(value = "/doRegister", method = RequestMethod.GET)
	    @ResponseBody
	    public Map<String, Object> doRegister(String customerName, String customerEmail, String customerTrueName, String customerPassword, String customerPhone, int customerSex, String customerBirthday, String customerpostNumber, String customerAddress) {

	        String result = "fail";
	        Customer customer = customerService.getCustomer(customerName);
	        if (customer != null) {
	            result = "nameExist";
	        } else {
	            customer = customerService.getCustomer(customerEmail);
	            if (customer != null)
	                result = "emailExist";
	            else {
	                Customer customer1 = new Customer();
	                customer1.setCustomerName(customerName);
	                System.out.println(customerName);
	                customer1.setCustomerEmail(customerEmail);
	                System.out.println(customerEmail);
	                customer1.setCustomerTrueName(customerTrueName);
	                System.out.println(customerTrueName);
	                customer1.setCustomerRole(0);
	                customerService.addCustomer(customer1);
	                customer1 = customerService.getCustomer(customerName);
	                CustomerDetail customerDetail = new CustomerDetail();
	                customerDetail.setCustomerId(customer1.getCustomerId());
	                customerDetail.setCustomerAddress(customerAddress);
	                customerDetail.setCustomerBirthday(customerBirthday);
	                customerDetail.setCustomerPassword(customerPassword);
	                customerDetail.setCustomerPhone(customerPhone);
	                customerDetail.setCustomerSex(customerSex);
	                customerDetail.setCustomerPostNumber(customerpostNumber);
	                Date date = new Date();
	                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                customerDetail.setCustomerRegisterTime(sf.format(date));
	                customerDetailService.addCustomerDetail(customerDetail);
	                result = "success";
	            }
	        }
	        Map<String, Object> resultMap = new HashMap<String, Object>();
	        resultMap.put("result", result);
	        return resultMap;
	    }

	    @RequestMapping(value = "/doUpdate", method = RequestMethod.GET)
	    @ResponseBody
	    public Map<String, Object> doUpdate(String customerName, String customerEmail, String customerTrueName, String customerPassword, String customerPhone, int customerSex, String customerBirthday, String customerPostNumber, String customerAddress) {
	        String result = "fail";
	        Customer customer = customerService.getCustomer(customerName);
	        customer.setCustomerTrueName(customerTrueName);
	        customerService.updateCustomer(customer);
	        CustomerDetail customerDetail = customerDetailService.getCustomerDetail(customer.getCustomerId());
	        customerDetail.setCustomerAddress(customerAddress);
	        customerDetail.setCustomerBirthday(customerBirthday);
	        customerDetail.setCustomerPassword(customerPassword);
	        customerDetail.setCustomerPhone(customerPhone);
	        customerDetail.setCustomerSex(customerSex);
	        customerDetail.setCustomerPostNumber(customerPostNumber);
	        customerDetailService.updateCustomerDetail(customerDetail);
	        result = "success";
	        Map<String, Object> resultMap = new HashMap<String, Object>();
	        resultMap.put("result", result);
	        return resultMap;
	    }

	    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
	    @ResponseBody
	    public Map<String, Object> getAllCustomer() {
//	        System.out.println("我接收到了获取用户请求");
	        List<Customer> customerList = new ArrayList<>();
	        customerList = customerService.getAllUser();
	        String allUsers = JSONArray.toJSONString(customerList);
//	        System.out.println("我返回的结果是"+allUsers);
	        Map<String,Object> resultMap = new HashMap<String,Object>();
	        resultMap.put("allUsers",allUsers);
	        return resultMap;
	    }

	    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	    @ResponseBody
	    public Map<String, Object> deleteCustomer(int customerId) {
	        String result ="fail";
	        if(customerDetailService.deleteCustomerDetail(customerId)){
	            if(customerService.deleteCustomer(customerId)){
	                result="success";
	            }
	        }
	        Map<String,Object> resultMap = new HashMap<String,Object>();
	        resultMap.put("result",result);
	        return resultMap;
	    }

	    @RequestMapping(value = "/getUserAddressAndPhoneNumber", method = RequestMethod.POST)
	    @ResponseBody
	    public Map<String, Object> getCustomerAddressAndPhoneNumber(int customerId) {
	        String customerAddress = customerDetailService.getCustomerDetail(customerId).getCustomerAddress();
	        String customerPhone = customerDetailService.getCustomerDetail(customerId).getCustomerPhone();
	        Map<String,Object> resultMap = new HashMap<String,Object>();
	        resultMap.put("customeraddress",customerAddress);
	        resultMap.put("customerphone",customerPhone);
	        return resultMap;
	    }

	    @RequestMapping(value = "/doLogout")
	    public String doLogout(HttpSession httpSession){
	        httpSession.setAttribute("currentCustomer","");
	        return "redirect:login";
	    }

	    @RequestMapping(value = "/getCustomerById", method = RequestMethod.POST)
	    @ResponseBody
	    public Map<String, Object> getCustomerById(int customerId) {
	        Customer customer = customerService.getCustomer(customerId);
	        String result = JSON.toJSONString(customer);
	        Map<String,Object> resultMap = new HashMap<String,Object>();
	        resultMap.put("result",result);
	        return resultMap;
	    }

	    @RequestMapping(value = "/getCustomerDetailById", method = RequestMethod.POST)
	    @ResponseBody
	    public Map<String, Object> getCustomerDetailById(int customerId) {
	        CustomerDetail customerDetail = customerDetailService.getCustomerDetail(customerId);
	        String result = JSON.toJSONString(customerDetail);
	        Map<String,Object> resultMap = new HashMap<String,Object>();
	        resultMap.put("result",result);
	        return resultMap;
	    }
}
