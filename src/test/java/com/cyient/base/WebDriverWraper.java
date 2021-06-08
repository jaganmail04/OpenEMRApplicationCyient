package com.cyient.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebDriverWraper {
	
protected WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		
		 //String browser="ff";
		
				 System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
				// System.setProperty("webdriver.ie.driver", "src/test/resources/driver/IEDriverServer.exe");
			
				 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.openemr.io/b/openemr/interface/login/login.php?site=default");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
