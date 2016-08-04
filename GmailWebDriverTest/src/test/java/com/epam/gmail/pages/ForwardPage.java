package com.epam.gmail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForwardPage extends BasePage {
		
	@FindBy(xpath = "//div[@class='PN']/input[@type='text']")
	private WebElement inputAddressField;
	
	@FindBy(xpath = "//button[@=name'next']")
	private WebElement nextButton;
	
	private final static Logger log = LogManager.getLogger("eventLogger");
		
	public ForwardPage(WebDriver driver){	
		super(driver);
	}
	
	public void addressEnter(String address){
		inputAddressField.sendKeys(address);
		log.info("Inputing into field address :"+address);				
	}
	
	public void clickNextButton(){
		nextButton.click();
		log.info("Clicking next button");				
	}

}
