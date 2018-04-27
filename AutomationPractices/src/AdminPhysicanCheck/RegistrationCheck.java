package AdminPhysicanCheck;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
	static String AdminEmailID = Admin + "@digisight.nett";
	@SuppressWarnings("deprecation")
	static String PhyName = "Phy" + date.getDate() + array[0] + date.getHours() + date.getMinutes() + date.getSeconds();
	@SuppressWarnings("deprecation")
	static String LicenseNumber = date.getDate() + array[0] + date.getHours() + "" + date.getMinutes() + ""+ date.getSeconds();
	static String practiceID;
	static Random CheckBoxNumber = new Random();
	static int SpeOption = CheckBoxNumber.nextInt(8) + 3;
	static int LoginFailureFlag;
	static String FILENAME="/Users/sunilg/Google Drive/Digisight/QA/TestAccounts.txt";
	
	public static void delay1() throws InterruptedException { Thread.sleep(2000); }
	
	public static void delay3() throws InterruptedException { Thread.sleep(4000); }
	
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.firefox.bin", "/Applications/Firefox");
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
		driver.manage().window().maximize();
		String practiceIDs = AdminUserRegistration();	 							System.out.println("Newly created Practice ID is "+practiceIDs);
		WritingToFile(AdminEmailID);
		driver.findElement(By.id("sign_out")).click();								delay3();
		for (int noOfNewRegistrations = 0; noOfNewRegistrations < 5; noOfNewRegistrations++) {
				delay1();
				PhyName = PhyName.concat(String.valueOf((noOfNewRegistrations)));
				LicenseNumber = LicenseNumber + noOfNewRegistrations;
				NewUserRegistration();												delay3();
				ConnectToPractice(practiceIDs);
				driver.findElement(By.id("sign_out")).click();						delay3();
				WritingToFile(PhyName+"@digisight.nett");							
		}																			delay1();
		String adminEmailID = Admin+"@digisight.nett";
		ApproveNewPhysicianRequests.ApproveAllPhysicians(adminEmailID);				delay1();
		AddLocations(adminEmailID);													delay1();
		RenameUserIDs();
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

	public static void LoginWithRegisteredUser(String emailID) throws InterruptedException {
		try {
			driver.navigate().to("https://aws-qa2.digisight.net");							delay1();
			driver.findElement(By.linkText("LOGIN")).click();									delay1();
			driver.findElement(By.id("user_session_username")).sendKeys(emailID);
			if(emailID=="adminnew@digisight.net")
				driver.findElement(By.id("user_session_password")).sendKeys("newAdmin531");
			else
				driver.findElement(By.id("user_session_password")).sendKeys("Sunil@123");
			driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		} catch (Exception e) {
			System.out.println("Failed to Login ID with Admin User\n--------------------------------------------------------");
		}
	}

	public static void NewUserRegistration() throws InterruptedException {
		try {
			driver.navigate().to("https://aws-qa2.digisight.net");
			driver.findElement(By.linkText("SIGNUP")).click();
			driver.findElement(By.linkText("Healthcare Professionals area")).click();								// System.out.println("Navigated to Registration Page");
			Select UserAccType = new Select(driver.findElement(By.id("user_physician_attributes_account_type"))); delay1();
			UserAccType.selectByVisibleText("Physician");														// System.out.println("Select the Account type as Physician");
			driver.findElement(By.id("user_email")).sendKeys(PhyName + "@digisight.nett");						// System.out.println("Physician Name used for registration: " + PhyName+"@digisight.nett");
			driver.findElement(By.id("user_password")).sendKeys("Sunil@123");										// System.out.println("Login ID: " + PhyName + "@digisight.nett" + "\nPassword: Sunil@123");
			driver.findElement(By.id("user_physician_attributes_information_attributes_first_name")).sendKeys(PhyName);
			driver.findElement(By.id("user_physician_attributes_information_attributes_last_name")).sendKeys("Test");
			driver.findElement(By.id("user_physician_attributes_information_attributes_city")).sendKeys("RoseLand");
			driver.findElement(By.id("user_physician_attributes_information_attributes_state")).sendKeys("TX");
			driver.findElement(By.id("user_physician_attributes_information_attributes_license_number")).sendKeys(LicenseNumber); // System.out.println("License Number: " + LicenseNumber);
			driver.findElement(By.xpath(".//*[@id='mdInfo']/label[" + SpeOption + "]/input")).click();			// System.out.println("Accepted Terms of Service");
			driver.findElement(By.xpath("//input[@name='legalTerms']")).click();									// System.out.println("Registering the New Physician Login");
			driver.findElement(By.xpath("//button[text()='Register']")).click();									// System.out.println("Registered and Successfully Logged in as " + PhyName + "@digisight.nett");
			driver.findElement(By.xpath("//a[text()='Connect with your Practice']")).click(); 					// System.out.println("Navigated to Connect to Practice Page");
			} catch (Exception e) {
				System.out.println("Failed to Register the new user\n--------------------------------------------------------");
			}
	}
	
	public static String AdminUserRegistration() throws InterruptedException {
		try {
			driver.navigate().to("https://aws-qa2.digisight.net");
			driver.findElement(By.linkText("SIGNUP")).click();
			driver.findElement(By.linkText("Healthcare Professionals area")).click();								// System.out.println("Navigated to Registration Page");
			Select UserAccType = new Select(driver.findElement(By.id("user_physician_attributes_account_type")));
			UserAccType.selectByVisibleText("Practice Administrator");											// System.out.println("Select the Account type as Practice Administrator");
			driver.findElement(By.id("user_email")).sendKeys(AdminEmailID);										// System.out.println("Admin Name used for registration: " + AdminEmailID);
			driver.findElement(By.id("user_password")).sendKeys("Sunil@123");										// System.out.println("Login ID: " + Admin + "@digisight.nett" + "\nPassword: Sunil@123");
			driver.findElement(By.id("user_physician_attributes_information_attributes_first_name")).sendKeys(Admin);
			driver.findElement(By.id("user_physician_attributes_information_attributes_last_name")).sendKeys("Test");
			driver.findElement(By.id("user_physician_attributes_information_attributes_city")).sendKeys("RoseLand");
			driver.findElement(By.id("user_physician_attributes_information_attributes_state")).sendKeys("TX");	// System.out.println("Accepted Terms of Service");
			driver.findElement(By.xpath("//input[@name='legalTerms']")).click();									// System.out.println("Registering the New Physician Login");
			driver.findElement(By.xpath("//button[text()='Register']")).click();							delay3(); // System.out.println("Registered and Successfully Logged in as " + Admin + "@digisight.nett");		
			} catch (Exception e) {
				System.out.println("Failed to Register Admin user\n--------------------------------------------------------");
			}
		checkAlert();
		driver.findElement(By.xpath("//a[text()='Administer Practice']")).click();					delay1();
		practiceID = driver.findElement(By.xpath("//p[contains(text(),'Practice ID:')]")).getText();
		String practiceIDs[] = practiceID.split(" ");
		return practiceIDs[2];
	}

	public static void RenameUserIDs() throws InterruptedException{
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			LoginWithRegisteredUser("adminnew@digisight.net");
			System.out.println("Following are the list of usernames set for respectice Email IDs: ");
			   for(String emailFromFile; (emailFromFile = br.readLine()) != null; ) {
				   driver.findElement(By.xpath("//a[contains(text(),'Users')]")).click();												delay1();
				   checkAlert();
				   driver.findElement(By.id("q_email_cont")).sendKeys(emailFromFile);
				   driver.findElement(By.xpath("//input[contains(@value,'Search')]")).click();
				   driver.findElement(By.xpath("//button[contains(text(),'Edit User Record')]")).click();								delay1();
				   System.out.println(emailFromFile + " " + emailFromFile.split("@")[0]);
				   driver.findElement(By.xpath("//input[contains(@id,'user_username')]")).click();
				   driver.findElement(By.xpath("//input[contains(@id,'user_username')]")).clear();
				   driver.findElement(By.xpath("//input[contains(@id,'user_username')]")).sendKeys(emailFromFile.split("@")[0]);		delay1();
				   driver.findElement(By.xpath("//input[contains(@value,'Update User')]")).click();									delay1();
			    }
		} catch (IOException e) {
			System.out.println("Failed to Rename User ID as Admin User\n--------------------------------------------------------");
		}
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();														System.out.println("Successfully signed out as Admin User after renaming.\n------------------------------");
	}

	public static void ConnectToPractice(String practiceIDs) throws InterruptedException {
		try {
			driver.findElement(By.xpath("//a[text()='Connect with your Practice']")).click();		delay1();
			driver.findElement(By.xpath("//input[@name='practice_id']")).sendKeys(practiceIDs);	delay1();
			driver.findElement(By.xpath("//button[text()='Search']")).click();  					delay1();	// System.out.println("Searched the Practice " + practiceIDs + " successfully to connect.");
			driver.findElement(By.xpath("//input[@name='practice_id']")).click();  				delay1();	// System.out.println("Selected the Practice using the ID: " + practiceIDs);
			driver.findElement(By.xpath("//input[@name='terms']")).click();						delay1();	// System.out.println("Agreed the Terms for connecting as Physician");
			driver.findElement(By.xpath("//button[text()='Submit']")).click();					delay1();	// System.out.println("Submitted the practice connection request successfully.");
			} catch (Exception e) {
				System.out.println("Failed to connect the Practice\n--------------------------------------------------------");
			}
	}
	
	public static void AddLocations(String adminEmailID) {
		try {
			LoginWithRegisteredUser(adminEmailID);
			checkAlert();																										// System.out.println("Skipped the sightbook popup - On Login.");
			driver.findElement(By.xpath("//a[text()='Administer Practice']")).click();
			for(int locationCounter = 0; locationCounter < 10;locationCounter++) {
				driver.findElement(By.id("practice_location_name")).sendKeys("Location "+locationCounter);									delay1();
				driver.findElement(By.xpath("//input[contains(@value,'Create Practice location')]")).click();									delay1();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to Add Locations.\n--------------------------------------------------------");
		}
		driver.findElement(By.id("sign_out")).click();																			System.out.println("Now signing out the Admin user\nEmail ID: " + adminEmailID);
	}

	public static void WritingToFile(String emailID) {
		try {
			Files.write(Paths.get(FILENAME), emailID.getBytes(), StandardOpenOption.APPEND);
			Files.write(Paths.get(FILENAME), "\n".getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
