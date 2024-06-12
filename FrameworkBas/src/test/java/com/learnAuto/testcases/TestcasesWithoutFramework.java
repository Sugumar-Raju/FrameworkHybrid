package com.learnAuto.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestcasesWithoutFramework {
	
	@Test
	public void test1()
	{
		WebDriver driver = new ChromeDriver();
		
		//EdgeDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://freecrm.com");
		System.out.println(	driver.getTitle());
		System.out.println(	driver.getCurrentUrl());
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
		driver.close();
	}

}
