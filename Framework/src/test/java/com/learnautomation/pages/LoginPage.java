package com.learnautomation.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	//add constructor to identify the drivers for launching app
	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(xpath="//a[@href='https://ui.cogmento.com/?lang=en']") WebElement loginLink;
	
	@FindBy(xpath="//input[@name='email']") WebElement email;
	
	@FindBy(xpath="//input[@name='password']") WebElement pwd;
	
	@FindBy(xpath="//div[text()='Login']") WebElement loginBtn;
	
	public void loginToCRM(String uname, String password) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		loginLink.click();
		
		// Switch to the new window
				String parent = driver.getWindowHandle();
				Set<String> handles = driver.getWindowHandles();

				for (String handle : handles) {
				    if (!handle.equals(parent)) {
				        driver.switchTo().window(handle);
				        System.out.println("Title of new window: " + driver.getTitle());
				    }
				}
		
		email.sendKeys(uname);
		pwd.sendKeys(password);
		loginBtn.click();
	}

}
