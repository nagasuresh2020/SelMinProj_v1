package com.SelMiniProj.testCases;

import java.io.IOException;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SelMiniProj.pageObjects.LoginPage;

public class TC_LoginTest_01 extends BaseClass 
{
	@Test
	public void loginTest() throws IOException
	{
		logger.info("URL Opened.");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered Username.");
		
		lp.setPassword(password);
		logger.info("Entered Password.");
		
		lp.clickSubmit();
		
		//Validated Login Form
		//if(driver.getTitle().equals("Welcome Page"))
		if(driver.getTitle().equals("Welcome Page"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed.");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed.");
		}
		
	}
}
