package com.bear.cakeonline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="customer")
public class Customer {

	
private int customerId;
private String customerName;
private String customerEmail;
private String customerTrueName;

private int customerRole;
private CustomerDetail customerdetail;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public String getCustomerTrueName() {
	return customerTrueName;
}
public void setCustomerTrueName(String customerTrueName) {
	this.customerTrueName = customerTrueName;
}
public String getCustomerEmail() {
	return customerEmail;
}
public void setCustomerEmail(String customerEmail) {
	this.customerEmail = customerEmail;
}
public int getCustomerRole() {
	return customerRole;
}
public void setCustomerRole(int customerRole) {
	this.customerRole = customerRole;
}
@ManyToOne
@JoinColumn(name="customerid")
public CustomerDetail getCustomerdetail() {
	return customerdetail;
}
public void setCustomerdetail(CustomerDetail customerdetail) {
	this.customerdetail = customerdetail;
}
}
