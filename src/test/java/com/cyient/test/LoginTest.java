package com.cyient.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWraper;
import com.cyient.page.LoginPage;
import com.cyient.utilities.DataProviderUtils;


public class LoginTest extends WebDriverWraper{

	
	@Test(dataProvider = "validCredentialData", dataProviderClass = DataProviderUtils.class)
	public void validCredentialTest(String username, String password,String languagetext,String expectedvalue)  {

		
		LoginPage login=new LoginPage(driver);
		login.sendUsername(username);
		login.sendPass(password);
		login.selectLanguageByText(languagetext);
		login.loginSubmit();	
		
		
//		driver.findElement(By.id("authUser")).sendKeys("admin");
//		driver.findElement(By.id("clearPass")).sendKeys("pass");
//
//		Select selectlanguage = new Select(driver.findElement(By.name("languageChoice")));
//		selectlanguage.selectByVisibleText("English (Indian)");
//		driver.findElement(By.xpath("//button[@class='btn btn-login btn-lg']")).click();
//	//String actualTitle = driver.getTitle();
//
//		// System.out.println("------------");
//		// System.out.println(actualTitle);
		Assert.assertEquals(driver.getTitle(), expectedvalue);
	}
	
		
	//@Test(invocationCount = 2)  --  run 2 times
	//(priority = 1)  1,2,3 priorty after non priorty declared methods
	@Test 
	public void AckTest() {
	

		String actualUserPlaceHolder=driver.findElement(By.id("authUser")).getAttribute("placeholder");
		Assert.assertEquals(actualUserPlaceHolder, "Username:");
		
		String actualLangSelected=driver.findElement(By.xpath("//option[@selected=\"selected\"]")).getText();
		System.out.println(actualLangSelected);
		//print default value English (Standard)
		
		
		Select selectLang=new Select(driver.findElement(By.name("languageChoice")));
		selectLang.selectByValue("18");
		
		// Select selectLang=new Select(driver.findElement(By.name("languageChoice")));
		
		String actualSelectedValue=selectLang.getFirstSelectedOption().getText();
		System.out.println(actualSelectedValue);
	// print actual selected value of english india
		
		
//		
//		driver.findElement(By.linkText("Acknowledgments, Licensing and Certification")).click();
//	
//		String ackWin=driver.getWindowHandle();
//		driver.switchTo().window(ackWin);
//				Set<String> windows=driver.getWindowHandles();
//				System.out.println(windows);
//				
//				
//				System.out.println("-----"+ackWin);
//		String ackTitle=driver.getTitle();	
//		System.out.println(ackTitle);
//		Assert.assertEquals(ackTitle, "OpenEMR Login");
}
}