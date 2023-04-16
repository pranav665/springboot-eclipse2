package com.example.SpringBootCrud2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootCrud2.bean.Customer;
import com.example.SpringBootCrud2.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/customers")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
	
	@RequestMapping(method= RequestMethod.PUT, value="/customers/{id}")
	public void updateCustomer(@PathVariable int id,@RequestBody Customer customer) {
		customerService.updateCustomer(id,customer);
	}
	
	@RequestMapping(method= RequestMethod.DELETE, value="/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
	}
	
	@GetMapping("/customers/welcome")
	public String welcome() {
		return "welcome to customers table";
	}
}
