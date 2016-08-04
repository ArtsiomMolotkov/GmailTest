package com.epam.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.epam.gmail.driverProvider.WebDriverProvider;
import com.epam.gmail.properties.Account;
import com.epam.gmail.properties.PropertyProvider;

public class BaseTest {
	protected WebDriver driver;
	protected PropertyProvider property = PropertyProvider.getInstance();	
	
	protected final String URL = property.getValue(Account.URL);
	protected final String GeneralSettingsURL = property.getValue(Account.GENERALSETTINGSURL);
	protected final String userName01=property.getValue(Account.USERNAME01);
	protected final String userName02=property.getValue(Account.USERNAME02);
	protected final String userName03=property.getValue(Account.USERNAME03);
	
	protected final String userPassword01=property.getValue(Account.USERPASSWORD01);
	protected final String userPassword02=property.getValue(Account.USERPASSWORD02);
	protected final String userPassword03=property.getValue(Account.USERPASSWORD03);
	
	protected final String userEmail01=property.getValue(Account.USEREMAIL01);
	protected final String userEmail02=property.getValue(Account.USEREMAIL02);
	protected final String userEmail03=property.getValue(Account.USEREMAIL03);
	
	protected String sbj="To my closest friend ";
	protected String messageText="How are you?";
	public static boolean StaySignedButton=false;

    @BeforeTest
    public void setUp()
    {
		driver = WebDriverProvider.getInstance();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }
    
    @AfterTest
    public void tearDown()
    {
    	driver.close();
        driver.quit();
        driver = null;
    }

}