package com.epam.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOutPage {
	
	private WebDriver driver;
	
	@FindBy(id="gb_71")
	private WebElement logOffButton;

	
	public SignOutPage(WebDriver driver){	
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public EnterEmailPage logOff(){
		logOffButton.click();
		return new EnterEmailPage(this.driver);	
	}


}
