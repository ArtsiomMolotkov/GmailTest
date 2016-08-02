package com.epam.gmail.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverProvider 
{
	private static WebDriver instance = null;
	
	private WebDriverProvider() {}
	
	public static WebDriver getInstance()
	{
		if(instance == null)
		{
			instance = new FirefoxDriver();
		}
		return instance;
	}
	
	public static void close()
	{
		instance.quit();
		instance = null;
	}
}