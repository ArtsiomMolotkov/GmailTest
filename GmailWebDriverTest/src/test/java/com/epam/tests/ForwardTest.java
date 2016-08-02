package com.epam.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.gmail.pages.AfterSendMessagePage;
import com.epam.gmail.pages.AfterSettingsClickPage;
import com.epam.gmail.pages.EnterEmailPage;
import com.epam.gmail.pages.EnterPasswordPage;
import com.epam.gmail.pages.GeneralSettingsPage;
import com.epam.gmail.pages.InboxMenuPage;
import com.epam.gmail.pages.NewMessagePage;
import com.epam.gmail.pages.OpenMailPage;
import com.epam.gmail.pages.SignOutPage;
import com.epam.gmail.properties.Account;
import com.epam.gmail.properties.PropertyProvider;
import com.epam.gmail.driver.WebDriverProvider;


public class ForwardTest {

	protected WebDriver driver;
	protected PropertyProvider property = PropertyProvider.getInstance();
	
	
	public final String URL = property.getValue(Account.URL);
	public final String userName01=property.getValue(Account.USERNAME01);
	public final String userName02=property.getValue(Account.USERNAME02);
	public final String userPassword01=property.getValue(Account.USERPASSWORD01);
	public final String userPassword02=property.getValue(Account.USERPASSWORD02);
	public final String userEmail01=property.getValue(Account.USEREMAIL01);
	public final String userEmail02=property.getValue(Account.USEREMAIL02);
	
	public String sbj="To my closest friend ";
	public String messageText="How are you?";
	public static boolean StaySignedButton=false;
	
	@BeforeTest
	public void setUp()
	{
		driver = WebDriverProvider.getInstance();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}
	
	@Test
	public void forwardTest() throws InterruptedException{		
		EnterEmailPage enterEmailPage = new EnterEmailPage(driver);
		enterEmailPage.openPage(URL);
		EnterPasswordPage enterPasswordPage = enterEmailPage.emailEnter(userName02);
		InboxMenuPage inboxMenuPage = enterPasswordPage.passwordEnter(userPassword02);
		AfterSettingsClickPage afterSettingsClick = inboxMenuPage.changeSettings(); 
		GeneralSettingsPage generalSettingsPage = afterSettingsClick.openGeneralSettings();

	}
	
	@AfterTest
	public void tearDown()
	{
//		WebDriverProvider.close();
	}
	
	
}