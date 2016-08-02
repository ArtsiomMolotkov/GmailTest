package com.epam.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AfterSettingsClickPage {
	private WebDriver driver;
	
//	@FindBy(xpath = "//div[contains(text(),'Настройки')]")
	@FindBy(xpath = "//div[class='J-N-Jz']")	
	private WebElement settingsButton1;
	
	public AfterSettingsClickPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public GeneralSettingsPage openGeneralSettings(){
		settingsButton1.click();
		return new GeneralSettingsPage(this.driver);
	}
	
	

}
