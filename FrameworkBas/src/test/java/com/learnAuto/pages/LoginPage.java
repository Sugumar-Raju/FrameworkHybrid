package com.learnAuto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	 WebDriver driver;
	 
	 public LoginPage(WebDriver ldriver)
	 {
		 this.driver=ldriver;
	 }
	 
	 @FindBy
	 (xpath="//input[@class='button']") WebElement loginButton;
	 @FindBy
	 (name="username") WebElement Uname;
	 @FindBy
	 (xpath="//input[@name='password']") WebElement pwd;
	 
	 

public void LoginPara(String Username, String Password)
{
	Uname.sendKeys(Username);
	pwd.sendKeys(Password);
	loginButton.click();	

}

}

