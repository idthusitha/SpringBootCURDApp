package com.example.springbootwebapplication.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer", schema = "rezos_common")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
//	public Customer(Integer userId, String userName, String age, String salary, String status) {
//		this.userId = userId;
//		this.userName = userName;
//		this.age = age;
//		this.salary = salary;
//		this.status = status;
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer userId;

	@Column(name = "name")
	private String userName;

	@Column(name = "age")
	private String age;

	@Column(name = "salary")
	private String salary;

	@Column(name = "status")
	private String status;

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
