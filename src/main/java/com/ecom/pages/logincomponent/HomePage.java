package com.ecom.pages.logincomponent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {


WebDriver driver;
	
	@FindBy(xpath="//div[@class='nav-line-1-container']/child::span")
	WebElement accountName;
	
	
	//div[@class='s-suggestion s-suggestion-ellipsis-direction' and contains(@aria-label,'baby boy')]
	
	@FindBy(xpath="//select[@id='searchDropdownBox']")
	WebElement selectDropDown;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement search;
	
	@FindBy(id= "nav-search-submit-button")
	WebElement searchButton;
	
	@FindBy(xpath="//span[@class='nav-icon nav-arrow']")
	WebElement accountArrow;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	WebElement logout;
	
	
	/*
	 * @FindBy(xpath="//div[@class='s-suggestion-container']/child::div[1]")
	 * WebElement searchText;
	 */
	
	@FindBy(xpath="//div[@aria-label='toys for 7 months baby boy']")
	WebElement searchText;
	
	Select selectDrop ;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getAccountName() {
		
		
		
		
		 return accountName.getText();
	}
	
	public Select getSelectedOptions() {
		return new Select(selectDropDown);
	}

	public void selectDropDownValue(String selectString) {
		
		selectDrop = new Select(selectDropDown);
		selectDrop.selectByValue(selectString);
	}
	
	public void searchForString(String searchString) {
		searchBox.sendKeys(searchString);
	}

	//remove this code
	public void selectFirstSuggestion(Actions a) {
		a.moveToElement(searchBox).perform();
		List<WebElement> autoSuggestion = driver.findElements(By.xpath("//div[@class='left-pane-results-container']/div"));
		int count = autoSuggestion.size();
		System.out.println(count);
		
		if(count > 1) {
		  WebElement selectFirstAutoSuggestion = autoSuggestion.get(count -2);
		  a.moveToElement(selectFirstAutoSuggestion).perform();
		  autoSuggestion.get(count - 2).click();
		}
	}
	
	public void selectSecondSuggestion(Actions a) {
		a.moveToElement(searchBox).perform();
		searchBox.sendKeys(Keys.ARROW_DOWN);
		searchBox.sendKeys(Keys.ARROW_DOWN);
		searchBox.sendKeys(Keys.ENTER);
	}
	
	public void clickOnSearch() {
		//search.click();
		searchButton.click();
	}
	
	public void logout(Actions a) {
		a.moveToElement(accountName);
		a.moveToElement(logout).build().perform();
		logout.click();
		
	}



}
