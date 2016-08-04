package com.epam.tests;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.epam.gmail.pages.AfterSendMessagePage;
import com.epam.gmail.pages.EnterEmailPage;
import com.epam.gmail.pages.EnterPasswordPage;
import com.epam.gmail.pages.ForwardPage;
import com.epam.gmail.pages.ForwardPopImapPage;
import com.epam.gmail.pages.GeneralSettingsPage;
import com.epam.gmail.pages.InboxMenuPage;
import com.epam.gmail.pages.NewMessagePage;
import com.epam.gmail.pages.OpenMailPage;
import com.epam.gmail.pages.SignOutPage;
import com.epam.gmail.properties.Account;
import com.epam.gmail.properties.PropertyProvider;
import com.epam.gmail.driverProvider.WebDriverProvider;


public class ForwardTest extends BaseTest {
	
	   	@Test
	   	public void forwardTest() throws InterruptedException{		
	   		EnterEmailPage enterEmailPage = new EnterEmailPage(driver);
	   		enterEmailPage.openPage(URL);
			EnterPasswordPage enterPasswordPage = enterEmailPage.emailEnter(userName02);
			InboxMenuPage inboxMenuPage = enterPasswordPage.passwordEnter(userPassword02);
			GeneralSettingsPage generalSettingsPage = inboxMenuPage.goToGeneralSettings(GeneralSettingsURL);
			ForwardPopImapPage forwardPopImapPage = generalSettingsPage.goToForwardPopImapPage();
			ForwardPage forwardPage = forwardPopImapPage.addAddress();
			forwardPage.addressEnter(userEmail03);
			forwardPage.clickNextButton();
	   	}
}