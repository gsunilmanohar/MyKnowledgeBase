package com.webapp.automation.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.webapp.automation.pages.HomePage;
import com.webapp.automation.utility.BaseClass;


public class HomePageTest extends BaseClass{

	@Test
	public static void FirstTimePopUpHandling() {
		HomePage popUpHandling = PageFactory.initElements(BaseDriver, HomePage.class);
		popUpHandling.getCloseButton().click();
	}
}
