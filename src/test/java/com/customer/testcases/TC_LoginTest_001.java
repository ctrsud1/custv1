package com.customer.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.customer.pageobjects.LoginPage;




public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		Logger.info("Sucessfully opened URL..");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("User name entered");
		lp.setPassword(password);
		Logger.info("Password entered");
		lp.clickLogin();
		Logger.info("Clicked on Login button");


		if (driver.getTitle().equals("Dashboard / nopCommerce administration11")) {
			
			Thread.sleep(5000);
			lp.clickLogout();
			Logger.info("Logout and test passed");
			Assert.assertTrue(true);
		} else {
			//captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			Logger.info("Logout failed");
		}

	}

}