package com.SelMiniProj.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//@FindBy(name="email")
	@FindBy(xpath="//input[@name='email' and @type='text']")
	@CacheLookup
	WebElement 	txtUserName;
	
	//@FindBy(xpath="//input[@name='password' and @type='password']")
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[text()='Login']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//button/b[text()='Log Out']")
	@CacheLookup
	WebElement btnLogOut;	
	
	public void setUsername(String uname)
	{
			txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	
	public void clickLogOut()
	{
		btnLogOut.click();
	}
	
	public void clearUsername()
	{
			txtUserName.clear();
	}
	
	public void clearPassword()
	{
		txtPassword.clear();
	}
	
	
}
	