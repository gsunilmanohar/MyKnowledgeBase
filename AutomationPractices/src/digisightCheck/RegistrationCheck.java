package digisightCheck;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegistrationCheck {
	static WebDriver driver = new FirefoxDriver();
	static Date date = new Date();
	@SuppressWarnings("deprecation")
	static String array[] = date.toLocaleString().split(" ");
	@SuppressWarnings("deprecation")
	static String Admin = "Admin" + date.getDate() + array[0] + date.getHours() + date.getMinutes() + date.getSeconds();
	@SuppressWarnings("deprecation")
	static String PhyName = "Phy" + date.getDate() + array[0] + date.getHours() + date.getMinutes() + date.getSeconds();
	@SuppressWarnings("deprecation")
	static String LicenseNumber = date.getDate() + array[0] + date.getHours() + "" + date.getMinutes() + ""+ date.getSeconds();
	static String practiceID;
	static Random CheckBoxNumber = new Random();
	static int SpeOption = CheckBoxNumber.nextInt(8) + 3;
	static int LoginFailureFlag;
	public static void delay1() throws InterruptedException { Thread.sleep(1000); }
	public static void delay3() throws InterruptedException { Thread.sleep(3000); }
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.firefox.bin", "/Applications/Firefox");
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
		driver.manage().window().maximize();
		String practiceIDs = AdminUserRegistration();
		System.out.println(practiceIDs);
		driver.findElement(By.id("sign_out")).click();
		delay3();
		try {
			for (int noOfNewRegistrations = 0; noOfNewRegistrations < 5; noOfNewRegistrations++) {
				PhyName = PhyName.concat(String.valueOf((noOfNewRegistrations)));
				LicenseNumber = LicenseNumber + noOfNewRegistrations;
				NewUserRegistration();
				delay3();
				ConnectToPractice(practiceIDs);
				driver.findElement(By.id("sign_out")).click();
				delay3();
			}
		} catch (Exception e) {
			System.out.println("Failed to Register new user and Connect to Practice");
			System.out.println("--------------------------------------------------------");
		}
		// driver.findElement(By.id("sign_out")).click();
		String adminEmailID = Admin+"@digisight.nett";
		ApproveNewPhysicianRequests.ApproveAllPhysicians(adminEmailID);
	}

	public static void checkAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			if (driver.switchTo().alert() != null)
				alert.accept();
		} catch (Exception e) {
		}
	}

	public static void LoginWithRegisteredUser(String emailID) {
		driver.navigate().to("https://aws-qa2.digisight.net");
		driver.findElement(By.linkText("LOGIN")).click();
		driver.findElement(By.id("user_session_username")).sendKeys(emailID);
		driver.findElement(By.id("user_session_password")).sendKeys("Sunil@123");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	}

	public static void NewUserRegistration() throws InterruptedException {
		driver.navigate().to("https://aws-qa2.digisight.net");
		driver.findElement(By.linkText("SIGNUP")).click();
		driver.findElement(By.linkText("Healthcare Professionals area")).click();
		System.out.println("Navigated to Registration Page");
		Select UserAccType = new Select(driver.findElement(By.id("user_physician_attributes_account_type")));
		UserAccType.selectByVisibleText("Physician");
		System.out.println("Select the Account type as Physician");
		System.out.println("Physcian Name used for registration: " + PhyName + " Test");
		driver.findElement(By.id("user_email")).sendKeys(PhyName + "@digisight.nett");
		System.out.println("*****************************************************************");
		System.out.println("Email ID : " + PhyName + "@digisight.nett" + " is used for registration.");
		System.out.println("*****************************************************************");
		driver.findElement(By.id("user_password")).sendKeys("Sunil@123");
		System.out.println("Login ID: " + PhyName + "@digisight.nett" + "\nPassword: Sunil@123");
		driver.findElement(By.id("user_physician_attributes_information_attributes_first_name")).sendKeys(PhyName);
		driver.findElement(By.id("user_physician_attributes_information_attributes_last_name")).sendKeys("Test");
		driver.findElement(By.id("user_physician_attributes_information_attributes_city")).sendKeys("RoseLand");
		driver.findElement(By.id("user_physician_attributes_information_attributes_state")).sendKeys("TX");
		driver.findElement(By.id("user_physician_attributes_information_attributes_license_number")).sendKeys(LicenseNumber);
		System.out.println("License Number: " + LicenseNumber);
		driver.findElement(By.xpath(".//*[@id='mdInfo']/label[" + SpeOption + "]/input")).click();
		System.out.println("Accepted Terms of Service");
		driver.findElement(By.xpath("//input[@name='legalTerms']")).click();
		System.out.println("Registering the New Physician Login");
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		System.out.println("Registered and Successfully Logged in as " + PhyName + "@digisight.nett");
		driver.findElement(By.xpath("//a[text()='Connect with your Practice']")).click();
		System.out.println("Navigated to Connect to Practice Page");
		delay3();
	}
	
	
	public static String AdminUserRegistration() throws InterruptedException {
		driver.navigate().to("https://aws-qa2.digisight.net");
		driver.findElement(By.linkText("SIGNUP")).click();
		driver.findElement(By.linkText("Healthcare Professionals area")).click();
		System.out.println("Navigated to Registration Page");
		Select UserAccType = new Select(driver.findElement(By.id("user_physician_attributes_account_type")));
		UserAccType.selectByVisibleText("Practice Administrator");
		System.out.println("Select the Account type as Practice Administrator");
		System.out.println("Admin Name used for registration: " + Admin + " Test");
		driver.findElement(By.id("user_email")).sendKeys(Admin + "@digisight.nett");
		System.out.println("*****************************************************************");
		System.out.println("Email ID : " + Admin + "@digisight.nett" + " is used for registration.");
		System.out.println("*****************************************************************");
		driver.findElement(By.id("user_password")).sendKeys("Sunil@123");
		System.out.println("Login ID: " + Admin + "@digisight.nett" + "\nPassword: Sunil@123");
		driver.findElement(By.id("user_physician_attributes_information_attributes_first_name")).sendKeys(Admin);
		driver.findElement(By.id("user_physician_attributes_information_attributes_last_name")).sendKeys("Test");
		driver.findElement(By.id("user_physician_attributes_information_attributes_city")).sendKeys("RoseLand");
		driver.findElement(By.id("user_physician_attributes_information_attributes_state")).sendKeys("TX");
		System.out.println("Accepted Terms of Service");
		driver.findElement(By.xpath("//input[@name='legalTerms']")).click();
		System.out.println("Registering the New Physician Login");
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		System.out.println("Registered and Successfully Logged in as " + Admin + "@digisight.nett");
		delay3();
		checkAlert();
		driver.findElement(By.xpath("//a[text()='Administer Practice']")).click();
		delay1();
		practiceID = driver.findElement(By.xpath("//p[contains(text(),'Practice ID:')]")).getText();
		String practiceIDs[] = practiceID.split(" ");
		return practiceIDs[2];
	}

	public static void ConnectToPractice(String practiceIDs) throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Connect with your Practice']")).click();
		delay1();
		driver.findElement(By.xpath("//input[@name='practice_id']")).sendKeys(practiceIDs);
		delay1();
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		delay1();
		System.out.println("Searched the Practice " + practiceIDs + " successfully to connect.");
		driver.findElement(By.xpath("//input[@name='practice_id']")).click();
		delay1();
		System.out.println("Selected the Practice using the ID: " + practiceIDs);
		driver.findElement(By.xpath("//input[@name='terms']")).click();
		delay1();
		System.out.println("Agreed the Terms for connecting as Physician");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		delay1();
		System.out.println("Submitted the practice connection request successfully.");
	}
}
