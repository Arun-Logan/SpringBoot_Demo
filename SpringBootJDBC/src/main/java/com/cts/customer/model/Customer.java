package com.cts.customer.model;

import java.sql.Date;

public class Customer {
	private int customerId;
	private String customerName;
	private Date price;

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

	public Date getPrice() {
		return price;
	}

	public void setPrice(Date price) {
		this.price = price;
	}
}
