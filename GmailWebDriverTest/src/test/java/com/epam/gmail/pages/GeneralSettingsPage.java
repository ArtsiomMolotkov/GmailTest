package com.epam.gmail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralSettingsPage extends BasePage {
	
	@FindBy(xpath = "//a[contains(text(),'Пересылка и POP/IMAP')]")
	private WebElement forwardPopImapButton;
	
	private final static Logger log = LogManager.getLogger("eventLogger");
		
	public GeneralSettingsPage(WebDriver driver){
		super(driver);
	}
	
	public ForwardPopImapPage goToForwardPopImapPage(){
		
		forwardPopImapButton.click();
		log.info("Opening Forward POP//IMAP page");
		return new  ForwardPopImapPage(this.driver);
		
		
	}
	
}
