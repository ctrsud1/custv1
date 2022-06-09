package com.customer.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.customer.pageobjects.LoginPage;
import com.customer.utilities.XLUtils;

public class TC_LoginTest_002 extends BaseClass 

{
	@Test(dataProvider="UserData")
	public void loginTest(String user, String pwd) throws InterruptedException, IOException
	
	{
		driver.get(baseURL);
		Logger.info("Sucessfully opened URL..");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		Logger.info("User name entered");
		lp.setPassword(pwd);
		Logger.info("Password entered");
		lp.clickLogin();
		Logger.info("Clicked on Login button");


		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			
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

	
	@DataProvider(name="UserData")
	public String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\customer\\testData\\UserData.xlsx";
		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String [][] logexceldata = new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logexceldata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logexceldata;
	}
}
