package com.SelMiniProj.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SelMiniProj.pageObjects.LoginPage;
import com.SelMiniProj.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(user);	//(username); //(user);
		logger.info("User Name Provided: " + user);
		lp.setPassword(pwd);	//(password);	//pwd);
		logger.info("Password Provided: " + pwd);
		//captureScreen(driver, "Credentials");
		lp.clickSubmit();
		logger.info("Clicked Login button.");
		//Thread.sleep(3000); //3 Seconds
		
		if(driver.getTitle().equals("Welcome Page"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed.");
			
			lp.clickLogOut();
			logger.info("Clicked Log Out button.");
			//Thread.sleep(1000); //1 Second
			
		}
		else
		{
			captureScreen(driver, "loginTest");
			lp.clearUsername();
			lp.clearPassword();
			logger.info("Login Test Failed.");
			Assert.assertTrue(false);
			//driver.navigate().refresh();
			//Thread.sleep(1000); //1 Second
		}
	}
	
		
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir") + "/src/test/java/com/SelMiniProj/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				//System.out.println("Data is: " + logindata[i-1][j]);
			}
		}
		return logindata;
	
	
	
	}
	
}
