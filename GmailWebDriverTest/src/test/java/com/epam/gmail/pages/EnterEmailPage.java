package com.epam.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterEmailPage {
	
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
	}
	
	public EnterPasswordPage emailEnter(String email){
		inputEmail.sendKeys(email);
		nextButton.click();
		return new EnterPasswordPage(this.driver);
	}
}
