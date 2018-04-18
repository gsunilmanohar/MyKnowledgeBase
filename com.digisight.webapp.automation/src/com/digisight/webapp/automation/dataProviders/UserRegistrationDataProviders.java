package com.digisight.webapp.automation.dataProviders;

import java.util.Date;

import org.testng.annotations.DataProvider;

public class UserRegistrationDataProviders {

	@SuppressWarnings("deprecation")
	@DataProvider
	public static Object[][] AdminEmail() {
		Date date = new Date();
		String array[] = date.toLocaleString().split(" ");
		String AdminEmailID1 = "admin." + date.getDate() + array[0] + date.getHours() + date.getMinutes() + date.getSeconds() + "@digisight.nett";
		String AdminEmail[] = { "Practice Administrator", AdminEmailID1, "Sunil@123", "AdminCheck", "User", "Roselind", "WS" };
		Object[][] dataSet = new Object[][] { AdminEmail };
		return dataSet;
	}

	@SuppressWarnings("deprecation")
	@DataProvider
	public static Object[][] PhyEmail() {
		Date date = new Date();
		String array[] = date.toLocaleString().split(" ");
		String PhyEmailID1 = "phy1check." + date.getDate() + array[0] + date.getHours() + date.getMinutes() + date.getSeconds() + "@digisight.nett";
		String PhyEmailID2 = "phy2check." + date.getDate() + array[0] + date.getHours() + date.getMinutes() + date.getSeconds() + "@digisight.nett";
		String PhyEmailID3 = "phy3check." + date.getDate() + array[0] + date.getHours() + date.getMinutes() + date.getSeconds() + "@digisight.nett";
		String Phy1[] = { "Physician", PhyEmailID1, "Sunil@123", "Phy1", "Test1", "San Bruno", "CA", "998877661" };
		String Phy2[] = { "Physician", PhyEmailID2, "Sunil@123", "Phy2", "Test2", "MaryGold", "TX", "998877662" };
		String Phy3[] = { "Physician", PhyEmailID3, "Sunil@123", "Phy3", "Test3", "McLean", "IR", "998877663" };
		Object[][] dataSet = new Object[][] { Phy1, Phy2, Phy3 };
		return dataSet;
	}
}
