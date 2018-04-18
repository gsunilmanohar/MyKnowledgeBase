package com.digisight.webapp.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.digisight.webapp.automation.PageObject;

public class AdminPage extends PageObject {

	@SuppressWarnings("unused")
	private WebDriver driver;

	public AdminPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//a[text()='LOGIN']")
	private WebElement login;

	public WebElement getLogin() {
		return login;
	}

	@FindBy(id = "user_session_username")
	private WebElement loginUserName;

	public WebElement getLoginUserName() {
		return loginUserName;
	}

	@FindBy(id = "user_session_password")
	private WebElement loginPassword;

	public WebElement getLoginPassword() {
		return loginPassword;
	}

	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signIn;

	public WebElement getSignIn() {
		return signIn;
	}
	
	@FindBy(linkText = "Administer Practice")
	private WebElement adminPractice;

	public WebElement getAdminPractice() {
		return adminPractice;
	}
}
