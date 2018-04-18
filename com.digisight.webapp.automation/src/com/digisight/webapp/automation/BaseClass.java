package com.digisight.webapp.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	String URL = "https://aws-qa2.digisight.net";
	protected static WebDriver BaseDriver;
	
    @BeforeMethod
	public void Browser() throws Exception {
		System.setProperty("webdriver.firefox.bin","/Applications/Firefox");
        System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
        BaseDriver = new FirefoxDriver();
        BaseDriver.manage().window().maximize();
        BaseDriver.navigate().to(URL);
    }
    
    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        BaseDriver.quit();
    }
    
	public void Selection(WebElement selectionID, String selectionValue) {
    		Select UserAccType = new Select(selectionID);
    		UserAccType.selectByVisibleText(selectionValue);
    		}
    
    public void checkAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(BaseDriver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = BaseDriver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
        //exception handling
        }
    }
}
