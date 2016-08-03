package com.epam.gmail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AfterSendMessagePage {
	
	private final static Logger log = LogManager.getLogger("eventLogger");

	
	private WebDriver driver;
	
	@FindBy(xpath="//span[@class='gb_3a gbii']")
	private WebElement signOutButton;

	public AfterSendMessagePage(WebDriver driver){	
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public SignOutPage signOut(){
		signOutButton.click();
		log.info("Clicking sign out button");
		return new SignOutPage(this.driver);
	}
	

}
