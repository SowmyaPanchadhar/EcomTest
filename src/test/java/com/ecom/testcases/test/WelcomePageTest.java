package com.ecom.testcases.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ecom.basepage.BaseDriver;
import com.ecom.pages.logincomponent.SignInPage;
import com.ecom.pages.logincomponent.WelcomePage;


public class WelcomePageTest extends BaseDriver {
	Actions a;

	public WelcomePageTest() {
		super();
	}

	@BeforeClass
	public void setup() {
	//	initialization();
		a = new Actions(driver);
		DOMConfigurator.configure("log4j.xml");

		 System.out.println("The thread ID for setup is "+ Thread.currentThread().getId());

	}

	@Test(priority = 1, groups = "unitTesting")
	public void verifyTitle() {
		WelcomePage welcomePage = openSite();
		String title = welcomePage.verifyTitle();
		Reporter.log("TC_001 The title is " + title);
		assertEquals(
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",
				title);
		
		 System.out.println("The thread ID for verifyTitle is "+ Thread.currentThread().getId());

	}

	@Test(priority = 2, groups = "unitTesting")
	public void verifySignInButton() {
		WelcomePage welcomePage = openSite();
		boolean isSelected = welcomePage.isSignInButtonEnabled();
		Reporter.log("TC_002 Verify signIn button is selected " + isSelected);
		assertTrue(isSelected);
		 System.out.println("The thread ID for verifySignInButton is "+ Thread.currentThread().getId());

	}

	@Test(priority = 3)
	public void verifySignInClick() {
		WelcomePage welcomePage = openSite();
		 System.out.println("The thread ID for verifySignInClick is "+ Thread.currentThread().getId());

		SignInPage signInPage= welcomePage.clickSignInButton(a);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Verifyclick method");
		String signInTitle = signInPage.getTitle();
		Reporter.log("Verify the sign In page title " + signInTitle);
		assertEquals("Amazon Sign In", signInTitle);


	}

	@Test(priority = 4, dependsOnMethods = "verifySignInClick")
	public void verifySignInFunctionality() {
		WelcomePage welcomePage = openSite();
		SignInPage signInPage= welcomePage.clickSignInButton(a);
		signInPage.signIn(getUserName(), getPassword());

		assertEquals("", "");
		 System.out.println("The thread ID for verifySignInFunctionality is "+ Thread.currentThread().getId());


	}

	

}
