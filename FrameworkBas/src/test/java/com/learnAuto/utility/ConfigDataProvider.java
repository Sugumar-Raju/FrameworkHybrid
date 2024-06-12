package com.learnAuto.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	public Properties pro;
	
	public ConfigDataProvider() throws IOException
	{
		File src= new File("./Config/config.properties");
		FileInputStream fis = new FileInputStream(src);
		pro= new Properties();
		pro.load(fis);
		
		
	}
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	public String getURL()
	{
		return pro.getProperty("qaUrl");
	}

}
