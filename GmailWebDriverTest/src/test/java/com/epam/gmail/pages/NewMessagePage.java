package com.epam.gmail.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewMessagePage {
	
	private final static Logger log = LogManager.getLogger("eventLogger");
	
	private WebDriver driver;
	
	@FindBy(xpath="//textarea[@name='to']")
	private WebElement inputTo;
	
	@FindBy(xpath="//input[@name='subjectbox']")
	private WebElement inputSubject;
	
	@FindBy(xpath="//div[@aria-label='Тело письма']")
	private WebElement inputMessage;
	
	@FindBy(xpath="//div[@id=':7t']")
	private WebElement sendButton;
	
	
	public NewMessagePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public AfterSendMessagePage writeNewMessage(String to,String subject, String message_text) throws InterruptedException{
		inputTo.clear();
		inputTo.sendKeys(to);
		inputTo.submit();
		log.info("Filling the TO form with values: "+to);
		inputSubject.clear();
		inputSubject.sendKeys(subject);
		inputSubject.submit();
		log.info("Filling the SUBJECT form with values: "+subject);
		inputMessage.click();
		inputMessage.sendKeys(message_text);
		log.info("Filling the MESSAGE form with values: "+message_text);
		sendButton.click();
		log.info("Clicking send button");
		return new AfterSendMessagePage(this.driver);
	}
	

}
