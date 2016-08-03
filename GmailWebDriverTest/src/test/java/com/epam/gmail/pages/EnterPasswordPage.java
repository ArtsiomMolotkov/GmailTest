package com.epam.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.tests.SpamTest;

public class EnterPasswordPage {
	
	private WebDriver driver;
	
	@FindBy(id="Passwd")
	private WebElement inputPassword;
	
	@FindBy(id="signIn")
	private WebElement signInButton;
	
	@FindBy(id="PersistentCookie")
	private WebElement staySignedRadioButton;
	
	
	public EnterPasswordPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	/**
	 * Why do you keep StaySignedButton variable in test class if it used only here?
	 * Rework
     */
	
	public InboxMenuPage passwordEnter(String password){
		
		inputPassword.sendKeys(password);
		if (SpamTest.StaySignedButton==false){
			staySignedRadioButton.click();
			SpamTest.StaySignedButton=true;
		}
		signInButton.click();
		return new InboxMenuPage(this.driver);
	}

}
