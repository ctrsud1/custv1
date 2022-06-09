package com.customer.testcases;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;


import com.customer.utilities.ReadConfig;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.*;

public class BaseClass {
	
	ReadConfig rc = new ReadConfig();
	
	public String baseURL=rc.getAppURL();
	public String username=rc.getUserName();
	public String password=rc.getPassword();
	public static WebDriver driver;
	
	public static Logger Logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		Logger = Logger.getLogger("customerv1");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",rc.getchromepath() );
			driver=new ChromeDriver();
			System.out.println("chrome browser opened");
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", rc.getIEpath());
			driver=new EdgeDriver();
			System.out.println("Edge browser opened");
		}

		
				
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	/* public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty(("user.dir")+"/Screenshots/"+tname+".png"));
		FileUtils.copyFile(source,target);
		System.out.println("Screenshot taken");
		
		
		
	} */
	
	
	
}