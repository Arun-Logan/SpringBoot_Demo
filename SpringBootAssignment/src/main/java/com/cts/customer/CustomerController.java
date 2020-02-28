package com.cts.customer;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cts.customer.config.AppConfig;
import com.cts.customer.dao.CustomerDAOImpl;
import com.cts.customer.model.Customer;

public class CustomerController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		CustomerDAOImpl dao = ac.getBean(CustomerDAOImpl.class);
		//List<Customer> customers = dao.findAll_v1();
		
		Customer customer = new Customer();
		customer.setCustomerId(999);
		customer.setCustomerName("ArunTest");
		
		//Calling insert operation
		dao.saveCustomer(customer);
		
		//Calling Update Operation
		//dao.updateCustomer("AK",customer);
		
		//Calling Delete operation
		//dao.deleteCustomer(customer);
		
		ac.close();
	}

}
