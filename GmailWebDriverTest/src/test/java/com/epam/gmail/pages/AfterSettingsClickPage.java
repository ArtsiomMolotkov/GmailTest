package com.epam.gmail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AfterSettingsClickPage {
	
	private final static Logger log = LogManager.getLogger("eventLogger");

	private WebDriver driver;
	/**
	 * Russian language used in locators
	 */
//	@FindBy(xpath = "//div[contains(text(),'?????????')]")
	@FindBy(xpath = "//div[class='J-N-Jz']")	
	private WebElement settingsButton1;
	
	public AfterSettingsClickPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	

	}
	
	public GeneralSettingsPage openGeneralSettings(){
		settingsButton1.click();
		log.info("Clicking Settings button");
		return new GeneralSettingsPage(this.driver);
	}
	
	

}
