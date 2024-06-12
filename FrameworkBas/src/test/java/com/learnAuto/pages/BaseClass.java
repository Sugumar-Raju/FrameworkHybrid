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
		 reporter= new ExtentSparkReporter((System.getProperty("user.dir")+"/Reports/parabank.html"));
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
		extent.flush();
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver);
			System.out.println("TestFailed");
		}
	}
	

}
