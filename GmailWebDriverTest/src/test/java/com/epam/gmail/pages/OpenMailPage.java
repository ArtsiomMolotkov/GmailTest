package com.epam.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMailPage {
	/**
	 * You've created one separated class only for one click() action?
	 */
	
	private WebDriver driver;
	
	public OpenMailPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//div[@aria-label='В спам!']")
	private WebElement spamButton;

	/**
	 * Rename method to sendToSpam
	 */
	
	public void sendToSpum(){		
		spamButton.click();
	}

}
