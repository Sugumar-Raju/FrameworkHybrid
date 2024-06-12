package com.learnAuto.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnAuto.pages.BaseClass;
import com.learnAuto.pages.LoginPage;
import com.learnAuto.utility.BrowserFactory;
import com.learnAuto.utility.ExcelDataProvider;
import com.learnAuto.utility.Helper;

public class LoginTestCRM extends BaseClass{
	
	
	
	@Test
	public void launchApp() throws IOException
	{
		test=extent.createTest("login","Test started");
		LoginPage loginpage=PageFactory.initElements(driver,LoginPage.class);
		test.info("Browser Started");
		loginpage.LoginPara(edf.getStringData("Login", 0, 0),edf.getStringData("Login", 0, 1));
		test.pass("Test case passed-Login");
		Helper.captureScreenshot(driver);
	}

}
