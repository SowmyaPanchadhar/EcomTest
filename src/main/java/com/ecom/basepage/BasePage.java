package com.ecom.basepage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.manager.SeleniumManager;

import com.ecom.util.Log;
import com.ecom.util.TestUtil;

public class BasePage {

	public static WebDriver driver;
	static Properties prop;

	public BasePage() {

		try {

			prop = new Properties();
			FileInputStream fis = new FileInputStream("E:\\Selenium\\EcomTest\\src\\main\\java\\com\\ecom\\config\\config.properties");

			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Properties file not found");
		}
	}

	public static void initialization() {
		

		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");
		if (browserName.equals("chrome")) {
			
			// driver = WebDriverManager.chromedriver().create();
			 
			 
			 ChromeOptions options = new ChromeOptions();
			    options.addArguments("--headless");
			    driver = new ChromeDriver(options);
			
			//driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.navigate().to(url);

		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

	}

	public static String getUserName() {
		String username= prop.getProperty("username");
		return username;
	}
	
	public static String getPassword() {
		String password= prop.getProperty("password");
		return password;
	}
	
	public static void printLog(String message) {
		Log.info(message);
	}
	
}
