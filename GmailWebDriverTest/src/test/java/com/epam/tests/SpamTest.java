package com.epam.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;


import com.epam.gmail.pages.AfterSendMessagePage;
import com.epam.gmail.pages.EnterEmailPage;
import com.epam.gmail.pages.EnterPasswordPage;
import com.epam.gmail.pages.InboxMenuPage;
import com.epam.gmail.pages.NewMessagePage;
import com.epam.gmail.pages.OpenMailPage;
import com.epam.gmail.pages.SignOutPage;
import com.epam.gmail.properties.Account;
import com.epam.gmail.properties.PropertyProvider;
import com.epam.gmail.driver.WebDriverProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SpamTest {

	protected WebDriver driver;
	protected PropertyProvider property = PropertyProvider.getInstance();
	/**
	 * Constant variable names shoud be written in UPPER CASE!!!!
	 */
	
	public final String URL = property.getValue(Account.URL);
	public final String userName01=property.getValue(Account.USERNAME01);
	public final String userName02=property.getValue(Account.USERNAME02);
	public final String userPassword01=property.getValue(Account.USERPASSWORD01);
	public final String userPassword02=property.getValue(Account.USERPASSWORD02);
	public final String userEmail01=property.getValue(Account.USEREMAIL01);
	public final String userEmail02=property.getValue(Account.USEREMAIL02);
	/**
	 * Wrong access modificators.
	 * If it's a constant Strings use private final static
	 */
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
	public void spamTest() throws InterruptedException{
		EnterEmailPage enterEmailPage = new EnterEmailPage(driver);
		enterEmailPage.openPage(URL);
		EnterPasswordPage enterPasswordPage = enterEmailPage.emailEnter(userName01);
		InboxMenuPage inboxMenuPage = enterPasswordPage.passwordEnter(userPassword01);	
		NewMessagePage newMessagePage = inboxMenuPage.createNewMessage();
		AfterSendMessagePage afterSendMessagePage = newMessagePage.writeNewMessage(userEmail02,sbj+userName02,messageText);
		SignOutPage signOutPage = afterSendMessagePage.signOut();
		EnterEmailPage enterEmailPage2 = signOutPage.logOff();
		EnterPasswordPage enterPasswordPage2= enterEmailPage2.emailEnter(userName02);
		InboxMenuPage inboxMenuPage2 = enterPasswordPage2.passwordEnter(userPassword02);
		OpenMailPage openMailPage = inboxMenuPage2.openInboxMail();
		openMailPage.sendToSpum();
	}
	
	@AfterTest
	public void tearDown()
	{
		WebDriverProvider.close();
	}
	
	
}