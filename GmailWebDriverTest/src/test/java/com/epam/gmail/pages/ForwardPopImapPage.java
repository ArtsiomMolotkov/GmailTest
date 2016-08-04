package com.epam.gmail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class ForwardPopImapPage extends BasePage {
		
	private final static Logger log = LogManager.getLogger("eventLogger");
	
	@FindBy(xpath="//input[@act='add']")
	private WebElement addAddressButton;
	
	public ForwardPopImapPage(WebDriver driver){
		super(driver);
	}
	
	public ForwardPage addAddress(){
		addAddressButton.click();
		log.info("Clicking add address button");
		return new ForwardPage(this.driver);
	}
	
	
	
}
