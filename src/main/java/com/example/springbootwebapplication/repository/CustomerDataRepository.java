package com.example.springbootwebapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootwebapplication.entity.Customer;

@Repository
public interface CustomerDataRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findAll();

	Customer findByUserId(Integer id);
}
