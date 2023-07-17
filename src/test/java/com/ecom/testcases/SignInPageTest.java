package com.ecom.testcases;

import java.time.Duration;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ecom.basepage.BasePage;
import com.ecom.pages.SignInPage;
import com.ecom.pages.WelcomePage;

public class SignInPageTest extends BasePage {

	SignInPage signInPage;
	WelcomePage welcomePage;
	Actions a;

	public SignInPageTest() {
		super();
	}

	@BeforeClass
	public void setup() {
		initialization();
		a = new Actions(driver);
		DOMConfigurator.configure("log4j.xml");

		welcomePage = new WelcomePage(driver);
		signInPage = new SignInPage(driver);
		System.out.println("The thread ID for setup is " + Thread.currentThread().getId());

	}

	@BeforeMethod
	public void goToSignInScreen() {
		welcomePage.clickSignInButton(a);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		System.out.println("The thread ID for goToSignInScreen is " + Thread.currentThread().getId());

	}

	@AfterMethod
	public void goToWelcomeScreen() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.navigate().back();
		System.out.println("The thread ID for goToWelcomeScreen is " + Thread.currentThread().getId());

	}

	@Test(groups = "unitTesting")
	public void verifyEmailTextBoxIsEnabled() {
		boolean enabled = signInPage.signInTextBoxIsEditable();
		Reporter.log("Email textbox is enabled " + enabled);

		System.out.println("The thread ID for verifyEmailTextBoxIsEnabled is " + Thread.currentThread().getId());

	}

	@Test
	public void verifyContinueButtonIsEnabled() {
		boolean enabled = signInPage.continueButtonIsEnabled();
		Reporter.log("Continue button is enabled " + enabled);
		System.out.println("The thread ID for verifyContinueButtonIsEnabled is " + Thread.currentThread().getId());

	}

	/*
	 * @AfterSuite public void tearDown() {if(driver!=null) driver.close(); }
	 */
}
