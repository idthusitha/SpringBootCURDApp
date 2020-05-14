package com.example.springbootwebapplication;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGTestsWithSpringBootApplication extends BaseIT {

	@BeforeClass
	public void setup() {
		System.out.println("I am in Setup");
	}

	@Test
	public void test() {
		System.out.println("I am in Test");
	}

	@Test
	public void simpleTest() {
		Assert.assertEquals(2 * 2, 4, "2x2 should be 4");
	}

	@AfterClass
	public void tearDown() {
		System.out.println("I am in tearDown");
	}
}
