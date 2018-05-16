package com.webapp.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.webapp.automation.utility.PageObject;

public class HomePage extends PageObject {

	@SuppressWarnings("unused")
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//button[text()='✕']")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}
}
