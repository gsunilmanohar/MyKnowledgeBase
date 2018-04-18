package elementById;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class FindElementByID {
    WebDriver driver;
    @BeforeTest
    public void setUp() throws Exception {
//      @SuppressWarnings("unused")
//		String chrome_path = System.getProperty("user.dir")+"/chromedriver";  // setting the driver executable for chrome browser
//      driver = new ChromeDriver();											// created a new instance for chrome driver
		System.setProperty("webdriver.firefox.bin","/Applications/Firefox");
        System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize(); 
    }
    
    @Test
    public void findElementById() throws InterruptedException
    {
        driver.navigate().to("http://store.webkul.com");
        Thread.sleep(1000);
        driver.findElement(By.id("search")).sendKeys("MarketPlace for shopify");
        Thread.sleep(5000);
    }
     
    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }
}