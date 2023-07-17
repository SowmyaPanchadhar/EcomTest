package com.ecom.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class WelcomePage  {

	WebDriver driver;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	@FindBy(xpath="//span[text()='Sign in']")
	WebElement signIn_button;

	//@FindBy(xpath = "//span[text()='Hello, sign in']")
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement SignIn_DisplayText;

	@FindBy(xpath="//a[@href='/ref=nav_logo']")
	WebElement amazonLogo;
	
	
	
	 public WelcomePage(WebDriver driver) { this.driver=driver;
	 PageFactory.initElements(driver, this); }
	
	
	
	
	
	
	
	
	public void verifyUrl() {
		String url = driver.getCurrentUrl();
		assertEquals(" ",url);
		Reporter.log("Valid URL"+url);
		
	}
	
	public String verifyTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public boolean isSignInButtonEnabled() {
		boolean isEnable=  signIn_button.isEnabled();
		return isEnable;
	}
	
	public SignInPage clickSignInButton(Actions a) {
		mouseMoveToHelloAccountName(a);
		System.out.println("clickSignInButton1");
		signIn_button.click();
		System.out.println("clickSignInButton2");
		return new SignInPage(driver);

	}

	public void mouseMoveToHelloAccountName(Actions a) {
		System.out.println("mouseMoveToHelloAccountName");
		a.moveToElement(SignIn_DisplayText).perform();
	}

}
