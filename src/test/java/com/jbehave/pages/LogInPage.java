package com.jbehave.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class LogInPage extends PageObject{

	@FindBy(id = "logInModalLabel")
	private WebElementFacade logInPopup;

	@FindBy(id = "loginusername")
	private WebElementFacade userNameField;

	@FindBy(id = "loginpassword")
	private WebElementFacade passwordField;

	@FindBy(xpath = "//button[text()='Log in']")
	private WebElementFacade loginButton;

	@FindBy(xpath = "//div[@id='signInModal']//button[text()='Close']")
	private WebElementFacade closeButton;

	@FindBy(xpath = "//h5[text()='Log in']/..//button[@aria-label='Close']")
	private WebElementFacade closeLoginPopup;

	public void enterUserName(String userName) {
		logInPopup.waitUntilVisible();
		userNameField.clear();
		userNameField.type(userName);
	}

	public void enterPassword(String password) {
		passwordField.clear();
		passwordField.type(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void clickCloseButton() {
		closeButton.click();
	}

	public void closeLoginPopup() {
		closeLoginPopup.click();
	}
}
