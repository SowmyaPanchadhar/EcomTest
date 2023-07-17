package com.ecom.pages.logincomponent;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {


WebDriver driver;
	
	
	//@FindBy(xpath="//input[@id='ap_email']")
	@FindBy(id="ap_email")
	WebElement emailorMobile;
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	@FindBy(id="auth-create-account-link")
	WebElement createYourAmazonAccountButton;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement signinButton;
	
	@FindBy(id="auth-fpp-link-bottom")
	WebElement forgotPassword;
	
	@FindBy(id="auth-login-via-otp-btn-announce")
	WebElement getOTP;
	
	
	
	public SignInPage(WebDriver driver) {
	this.driver= driver;
	PageFactory.initElements(driver, this);
	}
	
	
	public void enterEmailOrMobile(String email) {
		emailorMobile.sendKeys(email);
	}
	
	public void clickOnContinue() {
		continueButton.click();
	}
	
	public void clickOnCreateAmazonAccount() {
		createYourAmazonAccountButton.click();
	}
	
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickOnSignIn() {
		signinButton.click();
	}
	
	

	
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void signIn(String email_or_mobile,String password) {
		enterEmailOrMobile(email_or_mobile);
		clickOnContinue();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		enterPassword(password);
		clickOnSignIn();
	
	}
	
	public boolean signInTextBoxIsEditable() {
		
		return  emailorMobile.isEnabled();
	}
	
	public boolean continueButtonIsEnabled() {
		return continueButton.isEnabled();
	}
	


}
