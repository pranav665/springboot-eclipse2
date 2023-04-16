package com.example.SpringBootCrud2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootCrud2.bean.Customer;
import com.example.SpringBootCrud2.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers=new ArrayList<>();
		customerRepo.findAll().forEach(customers::add);
		return customers;
	}
	
	public void addCustomer(Customer customer) {
		customerRepo.save(customer);
	}
	
	public void updateCustomer(int id,Customer customer) {
		customerRepo.save(customer);
	}
	
	public void deleteCustomer(int id) {
		customerRepo.deleteById(id);
	}

}
