package com.example.SpringBootCrud2.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.SpringBootCrud2.bean.Customer;


public interface CustomerRepository extends CrudRepository<Customer,Integer>{

}
