
package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;

public class LoginTestCRM extends BaseClass {
	


	@Test(priority=1)
	public void loginApp() {
		
		Reporter.log("Executing Test1 LoginApp", true);
		
	   logger = report.createTest("Login To CRM");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting application...");
		
		loginPage.loginToCRM(excel.getStringData("Login",0 ,0), excel.getStringData("Login",0 ,1));
			
		logger.pass("Login Pass");
		System.out.println("Testing a commit");
	}
	

	@Test(priority=2)
	public void Logout() {
		
		Reporter.log("Executing Test2 Logout", true);
		
	   logger = report.createTest("Logout");
	   logger.fail("Logout Failed");
	   
	}
	
	
}
