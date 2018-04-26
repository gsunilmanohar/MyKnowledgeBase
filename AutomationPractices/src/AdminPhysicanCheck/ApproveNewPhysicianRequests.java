package AdminPhysicanCheck;

import org.openqa.selenium.By;

public class ApproveNewPhysicianRequests extends RegistrationCheck {
	static String adminEmailID = "Admin24Apr153756@digisight.nett";

	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.firefox.bin", "/Applications/Firefox");
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
		driver.manage().window().maximize();
		ApproveAllPhysicians(adminEmailID);
		driver.quit();																										// System.out.println("Closed the Web-Browser.");
	}

	public static void ApproveRequests() {
		try {
			if (driver.findElement(By.xpath("//h2[text()='Pending Participants']/following::button[text()='Accept'][1]")) != null) {
				driver.findElement(By.xpath("//h2[text()='Pending Participants']/following::button[text()='Accept'][1]")).click();
				checkAlert();
				} else if(driver.findElement(By.xpath("//h2[text()='Pending Participants']/following::button[text()='Accept']")) != null)
			driver.findElement(By.xpath("//h2[text()='Pending Participants']/following::button[text()='Accept']")).click();			// System.out.println("Accepted the Add Request and Skipped the sightbook popup - On Admin Page.");
			} catch (Exception e) {
				System.out.println("Failed to Approve the Request.");
			}
	}

	public static void ApproveAllPhysicians(String adminemailID) throws InterruptedException {
		try {
			LoginWithRegisteredUser(adminemailID);
			checkAlert();																										// System.out.println("Skipped the sightbook popup - On Login.");
			driver.findElement(By.xpath("//a[text()='Administer Practice']")).click();
			checkAlert();																										// System.out.println("Skipped the sightbook popup - On Admin Page.");
			int rowCount = driver.findElements(By.xpath("//h2[text()='Pending Participants']/following::tbody[1]/tr")).size();
			for (int noOfPhysicians = 1; noOfPhysicians <= rowCount; noOfPhysicians++)
				ApproveRequests();																								// System.out.println(noOfPhysicians); 
			practiceID = driver.findElement(By.xpath("//p[contains(text(),'Practice ID:')]")).getText();
			String practiceIDs[] = practiceID.split(" ");
			driver.findElement(By.id("sign_out")).click();																		
			System.out.println("Now signing out the Admin user\nEmail ID: " + adminEmailID + "\nPractice ID: "+practiceIDs[2]);
		} catch (Exception e) {
			System.out.println("Failed to Approve physicians.\n------------------------------------------------------------------");
		}
		
	}
}

// To read the table data row wise.
/*
 * List<WebElement> tableData=driver.findElements(By.
 * xpath("//h2[text()='Pending Participants']/following::table[1]"));
 * List<String> RowData=new ArrayList<String>(); for(int i=0;
 * i<tableData.size(); i++){ RowData.add(tableData.get(i).getText());
 * System.out.println(tableData.get(i).getText()); }
 */
