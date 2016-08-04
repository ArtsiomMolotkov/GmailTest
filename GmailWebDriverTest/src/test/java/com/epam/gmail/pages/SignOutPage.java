package com.epam.gmail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOutPage extends BasePage {
	
	private final static Logger log = LogManager.getLogger("eventLogger");
		
	@FindBy(id="gb_71")
	private WebElement logOffButton;

	
	public SignOutPage(WebDriver driver){	
		super(driver);
	}
	
	public EnterEmailPage logOff(){
		logOffButton.click();
		log.info("Clicking logOff button");
		return new EnterEmailPage(this.driver);	
	}


}
