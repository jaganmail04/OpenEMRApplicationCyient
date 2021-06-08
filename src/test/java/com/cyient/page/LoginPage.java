package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	private By usernameLocator=By.id("authUser");
	private By passLocator=By.id("clearPass");
	private By languageLocator= By.name("languageChoice");
	private By loginLocator=By.xpath("//button[@class='btn btn-login btn-lg']");
	
	private By invalidLocator=By.partialLinkText("Invalid");
	
	
	private WebDriver driver;
		public LoginPage(WebDriver driver) {
		this.driver=driver;
	}


	public void sendUsername(String username) {
		driver.findElement(usernameLocator).sendKeys(username);
	}

	public void sendPass(String pass) {
		driver.findElement(passLocator).sendKeys(pass);
			}
	public void selectLanguageByText(String language) {
		Select selectlanguage=new Select(driver.findElement(languageLocator));
		selectlanguage.selectByVisibleText(language);
	}
	
	public void loginSubmit() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(loginLocator).click();
	}
	
	public String invalidText(){
		return driver.findElement(invalidLocator).getText();
		
				
	}
}
