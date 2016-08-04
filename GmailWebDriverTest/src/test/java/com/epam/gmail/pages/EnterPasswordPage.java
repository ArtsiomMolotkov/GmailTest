package com.epam.gmail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.tests.BaseTest;

public class EnterPasswordPage extends BasePage {
	
	private final static Logger log = LogManager.getLogger("eventLogger");
	
	@FindBy(id="Passwd")
	private WebElement inputPassword;
	
	@FindBy(id="signIn")
	private WebElement signInButton;
	
	@FindBy(id="PersistentCookie")
	private WebElement staySignedRadioButton;
	
	
	public EnterPasswordPage(WebDriver driver){
		super(driver);
	}
	
	public InboxMenuPage passwordEnter(String password){
		
		inputPassword.sendKeys(password);
		if (BaseTest.StaySignedButton==false){
			staySignedRadioButton.click();
			BaseTest.StaySignedButton=true;
		}
		signInButton.click();
		log.info("Entering with password :"+password);
		return new InboxMenuPage(this.driver);
	}

}
