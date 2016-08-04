package com.epam.gmail.driverProvider;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverProvider 
{
	private static WebDriver instance = null;
	
	private WebDriverProvider() {}
	
	public static WebDriver getInstance()
	{
		if(instance == null)
		{
//			instance = new FirefoxDriver();
			String browser = System.getProperty("browser");
			BrowserType type;
			try
			{
				type = BrowserType.valueOf(browser.toUpperCase());
			}
			catch(Exception e)
			{
				type = BrowserType.FIREFOX;
			}
			
			init(type);
		}
		return instance;
	}
	
	
	private static void init(BrowserType type)
	{
		switch(type)
		{
		case CHROME:
			instance = new ChromeDriver();
			break;
		case IE:
			instance = new InternetExplorerDriver();
			break;
		case FIREFOX:
			instance = new FirefoxDriver();
			break;
		case OPERA:
			instance = new OperaDriver();
			break;
		}
	}
	
	
	public static void close()
	{
		instance.quit();
		instance = null;
	}
}