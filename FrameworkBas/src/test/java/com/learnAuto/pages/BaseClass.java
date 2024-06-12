package com.learnAuto.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learnAuto.utility.BrowserFactory;
import com.learnAuto.utility.ConfigDataProvider;
import com.learnAuto.utility.ExcelDataProvider;
import com.learnAuto.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider edf;
	public ConfigDataProvider config;
	public ExtentSparkReporter reporter;
	public ExtentReports extent;
	public ExtentTest test;
	@BeforeSuite
	 public void setupSuite() throws IOException
	 {
		 edf = new ExcelDataProvider();
		 config=new ConfigDataProvider();
		 reporter= new ExtentSparkReporter((System.getProperty("user.dir")+"/Reports/"+Helper.getCurrentDateTime()+"parabank.html"));
		 extent= new ExtentReports();
		 extent.attachReporter(reporter);
		 
	 }
	
	
	@BeforeClass
	public void setup()
	{
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
	
	}
	
	@AfterClass
	public void tearDown()
	{
		
		BrowserFactory.quitBrowser(driver);
	}
	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.fail("test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.pass("Test case passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		
		extent.flush();
		
	}
		
	}
	
