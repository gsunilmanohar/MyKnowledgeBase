package com.digisight.webapp.automation.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.digisight.webapp.automation.PageObject;

public class UserRegistrationPage extends PageObject {

	private WebDriver driver;

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(linkText = "SIGNUP")
	private WebElement signUp;

	public WebElement getSignUp() {
		return signUp;
	}

	@FindBy(linkText = "Healthcare Professionals area")
	private WebElement phySignUp;

	public WebElement getPhySignUp() {
		return phySignUp;
	}

	@FindBy(id = "user_physician_attributes_account_type")
	private WebElement accType;

	public WebElement getAccType() {
		return accType;
	}

	@FindBy(id = "user_email")
	private WebElement email;

	public WebElement getEmail() {
		return email;
	}

	@FindBy(id = "user_password")
	private WebElement pwd;

	public WebElement getPwd() {
		return pwd;
	}

	@FindBy(id = "user_physician_attributes_practice_email")
	private WebElement practiceEmail;

	public WebElement getPracticeEmail() {
		return practiceEmail;
	}

	@FindBy(id = "user_physician_attributes_information_attributes_first_name")
	private WebElement fName;

	public WebElement getFName() {
		return fName;
	}

	@FindBy(id = "user_physician_attributes_information_attributes_last_name")
	private WebElement lName;

	public WebElement getLName() {
		return lName;
	}

	@FindBy(id = "user_physician_attributes_information_attributes_country")
	private WebElement country;

	public WebElement getCountry() {
		return country;
	}

	@FindBy(id = "user_physician_attributes_information_attributes_city")
	private WebElement city;

	public WebElement getCity() {
		return city;
	}

	@FindBy(id = "user_physician_attributes_information_attributes_state")
	private WebElement state;

	public WebElement getState() {
		return state;
	}

	@FindBy(id = "user_physician_attributes_information_attributes_license_number")
	private WebElement licenseNumber;

	public WebElement getLicenseNumber() {
		return licenseNumber;
	}

	@FindBy(xpath = "//input[@name='legalTerms']")
	private WebElement acceptToS;

	public WebElement getAcceptToS() {
		return acceptToS;
	}

	public void SpecialitySelection() {
		Random CheckBoxNumber = new Random();
		int SpeOption = CheckBoxNumber.nextInt(8) + 3;
		driver.findElement(By.xpath(".//*[@id='mdInfo']/label[" + SpeOption + "]/input")).click();
	}

	@FindBy(xpath = "//button[text()='Register']")
	private WebElement register;

	public WebElement getRegister() {
		return register;
	}

	@FindBy(name = "Administer Practice")
	private WebElement administerPractice;

	public WebElement getAdministerPractice() {
		return administerPractice;
	}

	@FindBy(xpath = "//p[contains(text(),'Practice ID:')]")
	private WebElement adminPracticeID;

	public WebElement getAdminPracticeID() {
		return adminPracticeID;
	}

	@FindBy(xpath = "//a[text()='Connect with your Practice']")
	private WebElement connectPractice;

	public WebElement getConnectPractice() {
		return connectPractice;
	}

	@FindBy(id = "practice_id")
	private WebElement physicianPracticeID;

	public WebElement getPhysicianPracticeID() {
		return physicianPracticeID;
	}
	
	@FindBy(xpath="//button[text()='Search']")
	private WebElement searchPractice;
	
	public WebElement getSearchPractice() {
		return searchPractice;
	}
	
	@FindBy(xpath="//input[@name='practice_id']")
	private WebElement selectPractice;
	
	public WebElement getSelectPractice() {
		return selectPractice;
	}
	
	@FindBy(xpath="//input[@name='terms']")
	private WebElement acceptConnectPracticeTerms;
	
	public WebElement getAcceptConnectPracticeTerms() {
		return acceptConnectPracticeTerms;
	}
	
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement connectPracticeSubmit;
	
	public WebElement getConnectPracticeSubmit() {
		return connectPracticeSubmit;
	}
}
