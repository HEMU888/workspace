package com.hemu.mvcapp.test;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;

import com.hemu.mvcapp.dao.CriteriaCustomer;
import com.hemu.mvcapp.dao.CustomerDAO;
import com.hemu.mvcapp.dao.impl.CustomerDAOImpl;
import com.hemu.mvcapp.domain.Customer;

public class CustomerDAOImplTest {

	private CustomerDAO customerDAO = new CustomerDAOImpl();
	
	@Test
	public void testGetForListWithCriteriaCustomer() {
		CriteriaCustomer criteriaCustomer = new CriteriaCustomer("yi", "", "");
		List<Customer> ll = customerDAO.getForListWithCriteriaCustomer(criteriaCustomer);


		for(Customer customer : ll) {
			System.out.println(customer.getId());
			System.out.println(customer.getName());
			System.out.println(customer.getAddress());
			System.out.println(customer.getPhone());
			System.out.println("--------------------");
		}
		
	}
	@Test
	public void testGetAll() {
		List<Customer> customers = customerDAO.getAll();
		for(Customer customer : customers) {
			System.out.println(customer.getId());
			System.out.println(customer.getName());
			System.out.println(customer.getAddress());
			System.out.println(customer.getPhone());
			System.out.println("--------------------");
		}
		
	}

	@Test
	public void testSave() {
		Customer customer = new Customer();
		customer.setName("heyi");
		customer.setAddress("dalian");
		customer.setPhone("1588888888");
		customerDAO.save(customer);
	}

	@Test
	public void testGetInteger() {
		Customer customer = customerDAO.get(1);
		System.out.println(customer);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCountWithName() {
		fail("Not yet implemented");
	}

}
