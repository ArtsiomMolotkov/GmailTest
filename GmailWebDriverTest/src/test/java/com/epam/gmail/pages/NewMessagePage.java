package com.epam.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewMessagePage {
	
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
		inputSubject.clear();
		inputSubject.sendKeys(subject);
		inputSubject.submit();
		inputMessage.click();
		inputMessage.sendKeys(message_text);
		sendButton.click();
		return new AfterSendMessagePage(this.driver);
	}
	

}
