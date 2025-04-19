package com.learnautomation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {

public WebDriver driver;
public ExcelDataProvider excel;
public ConfigDataProvider config;
public ExtentReports report;
public ExtentTest logger;

    @BeforeSuite
    public void setUpSuite() {
    	
    Reporter.log("Setting up reports and test started..", true); // To print the logs of TestNG methods
    
     excel = new ExcelDataProvider();
     config = new ConfigDataProvider();
     
     
     ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
     //System.getProperty("user.dir")+"/Reports/FreeCRM.html"
     
     report = new ExtentReports();
     report.attachReporter(extent);
     
     Reporter.log("Setting done- Test can be started..", true);
    }
	
	@BeforeClass
	public void setUp() {
		
		Reporter.log("Trying to start browser and getting application ready..", true);
		 
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		System.out.println(driver.getTitle());
		
		 Reporter.log("Browser and application is up and running..", true);
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
		
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) { //ITestResult is an interface
		
		 Reporter.log("Test is about to end...", true);
		
		if(result.getStatus()==ITestResult.FAILURE) {
			//Helper.captureScreenshot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build()); //used class MediaEntityBuilder to capture screenshot
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else {
			System.out.println("error in Logging the test status");
		}
		
		report.flush();
		 Reporter.log("Test Completed>>> Reports Generated", true);
	}
}
