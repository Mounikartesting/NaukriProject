package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.interfaceelements.LoginPageInterfaceElement;
import com.pageobjectmanager.PageObjectManager;
import com.reusablemethods.BaseClass;
import com.utility.FileReaderManager;

public class LoginPage extends BaseClass implements LoginPageInterfaceElement {
	@FindBy(id=username_id)
	private WebElement email;
	
	@FindBy(xpath=password_xpath)
	private WebElement password;
	
	@FindBy(linkText=login_linkText)
	private WebElement login;
	
	private WebElement expected;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public void validLogin() throws InterruptedException{
		Thread.sleep(3000);
		inputPassing(email,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("Email"));
		inputPassing(password,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("Password"));
		elementClick(login);
}
	
}
