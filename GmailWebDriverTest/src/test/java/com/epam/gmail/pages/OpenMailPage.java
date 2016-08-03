package com.epam.gmail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMailPage {
	
	private final static Logger log = LogManager.getLogger("eventLogger");
	
	private WebDriver driver;
	
	public OpenMailPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//div[@aria-label='В спам!']")
	private WebElement spamButton;
	
	public void sendToSpum(){
		spamButton.click();
		log.info("Clicking TO SPUM button");
	}

}
