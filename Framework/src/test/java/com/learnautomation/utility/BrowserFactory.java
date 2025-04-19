package com.learnautomation.utility;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	//WebDriver driver;
	
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
        	
		}
        else {
        	System.out.println("Please specify browser");
        }
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(appURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
