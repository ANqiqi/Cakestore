package com.bear.cakeonline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="customerdetail")
public class CustomerDetail {
	private int customerId;
	private String customerPassword;
	private String customerPhone;
	private String customerBirthday;
	private int customerSex;
	private String customerPostNumber;
	private String customerAddress;
	private String customerRegisterTime;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerBirthday() {
		return customerBirthday;
	}
	public void setCustomerBirthday(String customerBirthday) {
		this.customerBirthday = customerBirthday;
	}

	public int getCustomerSex() {
		return customerSex;
	}
	public void setCustomerSex(int customerSex) {
		this.customerSex = customerSex;
	}

	public String getCustomerPostNumber() {
		return customerPostNumber;
	}
	public void setCustomerPostNumber(String customerPostNumber) {
		this.customerPostNumber = customerPostNumber;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerRegisterTime() {
		return customerRegisterTime;
	}
	public void setCustomerRegisterTime(String customerRegisterTime) {
		this.customerRegisterTime = customerRegisterTime;
	}
}
