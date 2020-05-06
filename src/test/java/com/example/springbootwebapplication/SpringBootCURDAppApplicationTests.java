package com.example.springbootwebapplication;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springbootwebapplication.controller.WebController;

@SpringBootTest
public class SpringBootCURDAppApplicationTests {

	@Autowired
	private WebController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
