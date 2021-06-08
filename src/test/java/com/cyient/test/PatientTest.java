package com.cyient.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWraper;

public class PatientTest extends WebDriverWraper{

	@Test 
	public void addPatient() throws InterruptedException{
		
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
driver.get("https://demo.openemr.io/b/openemr/interface/login/login.php?site=default");


 driver.findElement(By.id("authUser")).sendKeys("admin");
   driver.findElement(By.id("clearPass")).sendKeys("pass");

//dropdown
	Select selectlanguage= new Select(driver.findElement(By.name("languageChoice")));
	selectlanguage.selectByVisibleText("English (Indian)");
	driver.findElement(By.xpath("//button[@class='btn btn-login btn-lg']")).click();
	
	Actions action= new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//div[text()='Patient/Client']"))).perform();

 //Thread.sleep(1000);
	driver.findElement(By.xpath("//div[text()='Patients']")).click();
	
	driver.switchTo().frame(driver.findElement(By.name("fin")));
	driver.findElement(By.xpath("//button[text()='Add New Patient']")).click();
	driver.switchTo().defaultContent();
	driver.switchTo().frame(driver.findElement(By.name("pat")));
	driver.findElement(By.id("form_fname")).sendKeys("jagan");
	driver.findElement(By.id("form_mname")).sendKeys("mohan");
	driver.findElement(By.id("form_lname")).sendKeys("reddy");
	
	Select sex= new Select(driver.findElement(By.id("form_sex")));
	sex.selectByVisibleText("Male");

	driver.findElement(By.name("form_DOB")).sendKeys("2021-06-07");
	driver.findElement(By.name("create")).click();
	driver.switchTo().defaultContent();
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='modalframe']")));
	driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();

Thread.sleep(5000);

String alert= driver.switchTo().alert().getText();
 System.out.println(alert);
 Thread.sleep(3000);
 driver.switchTo().alert().accept();

driver.findElement(By.xpath("//div[@data-dismiss='modal']")).click();
	
driver.switchTo().defaultContent();

driver.switchTo().frame(driver.findElement(By.name("pat")));
String name=new String(driver.findElement(By.xpath("//h2[contains(text(),'Medical Record Dashboard')]")).getText());
System.out.println(name);	
Assert.assertEquals(name, "Medical Record Dashboard - Jagan Reddy");
	}
}
