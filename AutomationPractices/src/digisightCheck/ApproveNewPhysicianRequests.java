package digisightCheck;

import org.openqa.selenium.By;

public class ApproveNewPhysicianRequests extends RegistrationCheck{
	static String adminEmailID = "paadmin@digisight.nett";
	public static void main(String args[]) {
		System.setProperty("webdriver.firefox.bin", "/Applications/Firefox");
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
		driver.manage().window().maximize();
		LoginWithRegisteredUser(adminEmailID);
			checkAlert();
			System.out.println("Skipped the sightbook popup - On Login.");
		driver.findElement(By.xpath("//a[text()='Administer Practice']")).click();
			checkAlert();
			System.out.println("Skipped the sightbook popup - On Admin Page.");
			int rowCount=driver.findElements(By.xpath("//h2[text()='Pending Participants']/following::tbody[1]/tr")).size();
		for(int noOfPhysicians=1; noOfPhysicians<=rowCount; noOfPhysicians++) {
			System.out.println(rowCount);
			ApproveRequests();
		}
				System.out.println("Now signing out the user "+adminEmailID);
	    driver.findElement(By.id("sign_out")).click();
	    			System.out.println("Successfully signed out the Admin user.");
	    driver.quit();
	    			System.out.println("Closed the Web-Browser.");
	}
	
	public static void ApproveRequests() {
			if(driver.findElement(By.xpath("//h2[text()='Pending Participants']/following::button[text()='Accept'][1]"))!=null) {
				driver.findElement(By.xpath("//h2[text()='Pending Participants']/following::button[text()='Accept'][1]")).click();
				checkAlert();
				}
			else
				driver.findElement(By.xpath("//h2[text()='Pending Participants']/following::button[text()='Accept']")).click();
			System.out.println("Accepted the Add Request and Skipped the sightbook popup - On Admin Page.");

	}
}

		
		//To read the table data row wise.
		/*
		 * List<WebElement> tableData=driver.findElements(By.xpath("//h2[text()='Pending Participants']/following::table[1]"));
		 * List<String> RowData=new ArrayList<String>();
		 * for(int i=0; i<tableData.size(); i++){
		 * RowData.add(tableData.get(i).getText());
		 * System.out.println(tableData.get(i).getText());
		 * }
		 */
