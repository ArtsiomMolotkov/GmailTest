package com.epam.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.gmail.pages.AfterSendMessagePage;
import com.epam.gmail.pages.EnterEmailPage;
import com.epam.gmail.pages.EnterPasswordPage;
import com.epam.gmail.pages.InboxMenuPage;
import com.epam.gmail.pages.NewMessagePage;
import com.epam.gmail.pages.OpenMailPage;
import com.epam.gmail.pages.SignOutPage;
import com.epam.gmail.properties.Account;
import com.epam.gmail.properties.PropertyProvider;
import com.epam.gmail.driverProvider.WebDriverProvider;


public class SpamTest extends BaseTest {
	
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
}