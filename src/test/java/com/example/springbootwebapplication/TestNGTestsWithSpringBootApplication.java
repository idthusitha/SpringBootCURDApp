package com.example.springbootwebapplication;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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

	@Test(dataProvider = "numberGenerator")
	public void testParameter(int num1, int num2, int output) {
		Assert.assertEquals(num1 * num2, output, "Out put should be:" + output);
	}

	@AfterClass
	public void tearDown() {
		System.out.println("I am in tearDown");
	}

	@DataProvider(name = "numberGenerator")
	public Object[][] getValues() {
		return new Object[][] { { 2, 2, 4 }, { 5, 10, 50 }, { 7, 8, 56 } };
	}
}
