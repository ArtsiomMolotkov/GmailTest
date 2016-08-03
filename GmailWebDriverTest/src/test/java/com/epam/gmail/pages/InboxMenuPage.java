package com.epam.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxMenuPage {
	
	private WebDriver driver;
	
	
	@FindBy(xpath = "//div[contains(text(), 'НАПИСАТЬ')]")
	private WebElement createNewMessageButton;
	
	@FindBy(xpath="//div[@class='UI']")
	private WebElement openInboxMailButton;
	/**
	 * Clean your code from commented parts
	 */
		
//	@FindBy(xpath="//div[@aria-label='Настройки']/div")
	@FindBy(xpath="//div[@class='aos T-I-J3 J-J5-Ji']")
	private WebElement settingsButton;
	
	public InboxMenuPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	public NewMessagePage createNewMessage(){		
		createNewMessageButton.click();
		return new NewMessagePage(this.driver);
	}
	
	public AfterSettingsClickPage changeSettings(){		
		settingsButton.click();
		return new AfterSettingsClickPage(this.driver);
	}
	
	
	public OpenMailPage openInboxMail(){		
		openInboxMailButton.click();
		return new OpenMailPage(this.driver);
	}
	

}
