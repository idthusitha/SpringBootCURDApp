package com.example.springbootwebapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootwebapplication.entity.Customer;

public interface CustomerDataRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findAll();

	Customer findOne(Integer id);
}
