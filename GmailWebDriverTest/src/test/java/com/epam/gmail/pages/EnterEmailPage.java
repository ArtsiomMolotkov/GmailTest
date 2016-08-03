package com.epam.gmail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterEmailPage {
	
	private final static Logger log = LogManager.getLogger("eventLogger");
	
	private WebDriver driver;
	
	@FindBy(id="Email")
	private WebElement inputEmail;
	
	@FindBy(id="next")
	private WebElement nextButton;
		
	public EnterEmailPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	public void openPage(String URL){
		this.driver.get(URL);
		log.info("Open page :"+URL);
	}
	
	public EnterPasswordPage emailEnter(String email){
		inputEmail.sendKeys(email);
		nextButton.click();
		log.info("Entering with email :"+email);
		return new EnterPasswordPage(this.driver);
	}
}
