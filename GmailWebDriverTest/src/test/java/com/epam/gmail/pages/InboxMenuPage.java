package com.epam.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxMenuPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//div[@class='T-I J-J5-Ji T-I-KE L3']")
	private WebElement createNewMessageButton;
	
	@FindBy(xpath="//div[@class='UI']")
	private WebElement openInboxMailButton;
	
	public InboxMenuPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	public NewMessagePage createNewMessage(){		
		createNewMessageButton.click();
		return new NewMessagePage(this.driver);
	}
	
	public OpenMailPage openInboxMail(){		
		openInboxMailButton.click();
		return new OpenMailPage(this.driver);
	}
	

}
