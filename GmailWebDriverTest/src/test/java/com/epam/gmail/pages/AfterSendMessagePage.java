package com.epam.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AfterSendMessagePage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//span[@class='gb_3a gbii']")
	private WebElement signOutButton;

	public AfterSendMessagePage(WebDriver driver){	
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public SignOutPage signOut(){
		signOutButton.click();
		return new SignOutPage(this.driver);
	}
	

}
