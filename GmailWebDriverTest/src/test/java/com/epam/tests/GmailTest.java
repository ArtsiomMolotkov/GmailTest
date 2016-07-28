package com.epam.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.epam.gmail.pages.AfterSendMessagePage;
import com.epam.gmail.pages.EnterEmailPage;
import com.epam.gmail.pages.EnterPasswordPage;
import com.epam.gmail.pages.InboxMenuPage;
import com.epam.gmail.pages.NewMessagePage;
import com.epam.gmail.pages.OpenMailPage;
import com.epam.gmail.pages.SignOutPage;

public class GmailTest {
	
	public static final String URL="http://www.gmail.com";
	public static final String userName01="testepamuser01";
	public static final String userName02="testepamuser02";
	public static final String userPassword01="testepamuser01pass";
	public static final String userPassword02="testepamuser02pass";
	public static final String domainName="@gmail.com";
	public String sbj="To my closest friend ";
	public String messageText="How are you?";
	public static boolean StaySignedButton=false;
	
	
	@Test
	public void spamTest() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		EnterEmailPage eep = new EnterEmailPage(driver);
		eep.openPage(URL);
		EnterPasswordPage epp = eep.emailEnter(userName01);
		Thread.sleep(1000);
		InboxMenuPage imp = epp.passwordEnter(userPassword01);	
		Thread.sleep(4000);
		NewMessagePage nmp = imp.createNewMessage();
		Thread.sleep(1000);
		AfterSendMessagePage asmbp = nmp.writeNewMessage(userName02+domainName,sbj+userName02,messageText);
		SignOutPage sop = asmbp.signOut();
		Thread.sleep(1000);
		EnterEmailPage eep2 = sop.logOff();
		Thread.sleep(1000);
		EnterPasswordPage epp2= eep2.emailEnter(userName02);
		Thread.sleep(1000);
		InboxMenuPage imp2 = epp2.passwordEnter(userPassword02);
		Thread.sleep(4000);
		OpenMailPage omp = imp2.openInboxMail();
		omp.sendToSpum();
	}
}
