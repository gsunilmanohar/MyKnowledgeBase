package com.digisight.webapp.automation.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.digisight.webapp.automation.BaseClass;
import com.digisight.webapp.automation.dataProviders.UserRegistrationDataProviders;
import com.digisight.webapp.automation.pages.AdminPage;

public class ConnectPracticeTests extends BaseClass {
	
	@Test(dataProvider="AdminEmail",dataProviderClass=UserRegistrationDataProviders.class)
	public void AdminLogin(String userEmailID, String password) {
		AdminPage loginPage = PageFactory.initElements(BaseDriver, AdminPage.class);
		loginPage.getLogin().click();
		loginPage.getLoginUserName().sendKeys(userEmailID);
		loginPage.getLoginPassword().sendKeys(password);
		loginPage.getSignIn().click();
		loginPage.getAdminPractice().click();
	}
}
