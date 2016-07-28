package com.epam.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMailPage {
	
	private WebDriver driver;
	
	public OpenMailPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//div[@class='asl T-I-J3 J-J5-Ji']")
	private WebElement spamButton;
	
	public void sendToSpum(){		
		spamButton.click();
	}

}
