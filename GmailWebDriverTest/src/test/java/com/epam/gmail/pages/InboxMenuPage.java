package com.epam.gmail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxMenuPage {
	
	private WebDriver driver;
	private final static Logger log = LogManager.getLogger("eventLogger");
	
	
	@FindBy(xpath = "//div[contains(text(), 'НАПИСАТЬ')]")
	private WebElement createNewMessageButton;
	
	@FindBy(xpath="//div[@class='UI']")
	private WebElement openInboxMailButton;
		
//	@FindBy(xpath="//div[@aria-label='Настройки']/div")
	@FindBy(xpath="//div[@class='aos T-I-J3 J-J5-Ji']")
	private WebElement settingsButton;
	
	public InboxMenuPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	public NewMessagePage createNewMessage(){		
		createNewMessageButton.click();
		log.info("New message creating");
		return new NewMessagePage(this.driver);
		
	}
	
	public AfterSettingsClickPage changeSettings(){		
		settingsButton.click();
		log.info("Clicking settings button");
		return new AfterSettingsClickPage(this.driver);
	}
	
	
	public OpenMailPage openInboxMail(){		
		openInboxMailButton.click();
		log.info("Opening inbox mail");
		return new OpenMailPage(this.driver);
	}
	

}
