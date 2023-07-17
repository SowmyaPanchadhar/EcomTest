package com.ecom.testcases.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ecom.util.Log;

public class HomePageTest {
	@BeforeClass
	public void config() {
		DOMConfigurator.configure("log4j.xml");

	}

	
	@Test
	public void verifySearchDropDown() {
		
	}
	
	
	@Test
	public void verifySearchTextBox() {

		Reporter.log("This is just a test method in HomePageTest");
		Log.info("This is just a message");
	}

	
	@Test
	public void verifySearchButton() {
		
	}
	
	


}
