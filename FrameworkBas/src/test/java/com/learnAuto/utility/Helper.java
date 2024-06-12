package com.learnAuto.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver)
	{
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/parabank_"+getCurrentDateTime()+ ".png";
		try {
			FileHandler.copy(src, new File(screenshotPath));
			
			System.out.println("Screen captured");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to captrue screenshots" + e.getMessage());
		}
		return screenshotPath;
	}
	
	
public static String getCurrentDateTime()
{
	SimpleDateFormat sdf= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	Date currentdate =new Date();
	return sdf.format(currentdate);
	
}
	

}
