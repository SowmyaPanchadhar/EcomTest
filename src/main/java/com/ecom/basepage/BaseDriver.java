package com.ecom.basepage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.ecom.pages.logincomponent.WelcomePage;
import com.ecom.util.TestUtil;

public class BaseDriver {
	public WebDriver driver;
	static Properties prop;

	public BaseDriver() {

		try {

			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"E:\\Selenium\\EcomTest\\src\\main\\java\\com\\ecom\\config\\config.properties");

			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Properties file not found");
		}
	}

	@BeforeClass
	public void initialization() {

		String browserName = prop.getProperty("browser");
		System.setProperty("webdriver.chrome.driver", "E://Softwares//chrome_driver113//chromedriver.exe");

		if (browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
		    options.addArguments("--headless");
		    driver = new ChromeDriver(options);

			//driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			 driver = new FirefoxDriver();
		}

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	public WelcomePage openSite() {
		String url = prop.getProperty("url");

		driver.navigate().to(url);

		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		return new WelcomePage(this.driver);
	}

	public static String getUserName() {
		String username = prop.getProperty("username");
		return username;
	}

	public static String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}

}
