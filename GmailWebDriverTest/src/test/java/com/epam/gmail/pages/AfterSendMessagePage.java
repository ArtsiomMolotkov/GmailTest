package com.epam.gmail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AfterSendMessagePage extends BasePage {
	
	private final static Logger log = LogManager.getLogger("eventLogger");
	
	@FindBy(xpath="//span[@class='gb_3a gbii']")
	private WebElement signOutButton;

	public AfterSendMessagePage(WebDriver driver){	
		super(driver);
	}
	
	public SignOutPage signOut(){
		signOutButton.click();
		log.info("Clicking sign out button");
		return new SignOutPage(this.driver);
	}
	

}
