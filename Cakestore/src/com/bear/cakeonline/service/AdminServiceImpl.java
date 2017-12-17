package com.bear.cakeonline.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bear.cakeonline.dao.AdminDaoImpl;
import com.bear.cakeonline.entity.Admin;

@Service
public class AdminServiceImpl {
	@Resource
	private AdminDaoImpl adminDaoImpl;
	public List<Admin> listAdmin(){
	    return adminDaoImpl.findAll();
	}
}
