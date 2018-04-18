package com.digisight.webapp.automation.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.digisight.webapp.automation.BaseClass;
import com.digisight.webapp.automation.dataProviders.UserRegistrationDataProviders;
import com.digisight.webapp.automation.pages.AdminPage;
import com.digisight.webapp.automation.pages.UserRegistrationPage;

public class PhyRegTests extends BaseClass{
	static String adminLoginID, practiceID, adminLoginPassword;
	
	@Test(priority=1, dataProvider="AdminEmail",dataProviderClass=UserRegistrationDataProviders.class)
	public void AdminReg(String AccountType, String userEmailID, String password, String fName, String lName, String city, String state) {
		UserRegistrationPage signUpPage = PageFactory.initElements(BaseDriver, UserRegistrationPage.class);
		signUpPage.getSignUp().click();
		signUpPage.getPhySignUp().click();
		Selection(signUpPage.getAccType(), AccountType);
		signUpPage.getEmail().sendKeys(userEmailID);
		adminLoginID=userEmailID;
		signUpPage.getPwd().sendKeys(password);
		adminLoginPassword=password;
		signUpPage.getPracticeEmail().sendKeys(userEmailID);
		signUpPage.getFName().sendKeys(fName);
		signUpPage.getLName().sendKeys(lName);
		signUpPage.getCity().sendKeys(city);
		signUpPage.getState().sendKeys(state);
		signUpPage.getAcceptToS().click();
		signUpPage.getRegister().click();
		signUpPage.getAdministerPractice().click();
		checkAlert();
		practiceID=signUpPage.getAdministerPractice().getText();
		System.out.println("PracticeID="+practiceID);
	}
	
	@Test(priority=2, dataProvider="PhyEmail",dataProviderClass=UserRegistrationDataProviders.class)
	public void PhyReg(String AccountType, String userEmailID, String password, String fName, String lName, String city, String state, String licenseNumber) {
		UserRegistrationPage signUpPage = PageFactory.initElements(BaseDriver, UserRegistrationPage.class);
		signUpPage.getSignUp().click();
		signUpPage.getPhySignUp().click();
		Selection(signUpPage.getAccType(), AccountType);
		signUpPage.getEmail().sendKeys(userEmailID);
		signUpPage.getPwd().sendKeys(password);
		signUpPage.getFName().sendKeys(fName);
		signUpPage.getLName().sendKeys(lName);
		signUpPage.getCity().sendKeys(city);
		signUpPage.getState().sendKeys(state);
		signUpPage.getLicenseNumber().sendKeys(licenseNumber);
		signUpPage.SpecialitySelection();
		signUpPage.getAcceptToS().click();
		signUpPage.getRegister().click();
		signUpPage.getConnectPractice().click();
		signUpPage.getPhysicianPracticeID().sendKeys(practiceID);
		signUpPage.getSearchPractice().click();
		signUpPage.getSelectPractice().click();
		signUpPage.getAcceptConnectPracticeTerms().click();
		signUpPage.getConnectPracticeSubmit().click();
	}
	
	@Test(priority=3)
	public void AdminLogin() {
		AdminPage adminLogin = PageFactory.initElements(BaseDriver, AdminPage.class);
		adminLogin.getLogin().click();
		adminLogin.getLoginUserName().sendKeys(adminLoginID);
		adminLogin.getLoginPassword().sendKeys(adminLoginPassword);
		adminLogin.getSignIn().click();
		adminLogin.getAdminPractice().click();
	}
}
