package com.cts.customer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cts.customer.model.Customer;

@Repository
public class CustomerDAOImpl {

	@Autowired
	private JdbcTemplate jt;

	public List<Customer> findAll() {
		
		List<Customer> customers = jt.queryForObject("select * from sakila.customer", new RowMapperDemo());
		
		return customers;
	}
	
	public List<Customer> findAll_v1(){
		List<Customer> customers = jt.query("select * from sakila.customer", new ResultSetExtrcustomerDemo());
		return customers;
	}
	
	public int saveCustomer(Customer customer)
	{
		int noOfRows = jt.update("insert into sakila.customer(customer_id,first_name,last_name) values(?,?,?)", customer.getCustomerId(),customer.getCustomerName(),"Logan");
		System.out.println("Row inserted successfully");
		return noOfRows;
	}
	
	public void updateCustomer(String fname, Customer customer)
	{
		jt.update("update sakila.customer set first_name='"+fname+"' where customer_id=?",customer.getCustomerId());
		System.out.println("Row updated successfully");
	}
	
	public void deleteCustomer(Customer customer)
	{
		jt.update("delete from sakila.customer where customer_id=?",customer.getCustomerId());
		System.out.println("Row deleted successfully");
	}
}


class ResultSetExtractorDemo implements ResultSetExtractor<List<Customer>>
{
	
	public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<Customer> customers = new ArrayList<Customer>();

		System.out.println("Customer ID | Name");
		while (rs.next()) {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt("customer_id"));
			customer.setCustomerName(rs.getString("first_name"));

			System.out.println(customer.getCustomerId() + "|" + customer.getCustomerName());
			
			customers.add(customer);
		}
		return customers;
	

}
}


class RowMapperDemo implements RowMapper<List<Customer>> {
	List<Customer> customers = new ArrayList<Customer>();

	public List<Customer> mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("Customer ID | Name");
		while (rs.next()) {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt("customer_id"));
			customer.setCustomerName(rs.getString("first_name"));

			System.out.println(customer.getCustomerId() + "|" + customer.getCustomerName());
			
			customers.add(customer);
		}
		return customers;
	}
}
