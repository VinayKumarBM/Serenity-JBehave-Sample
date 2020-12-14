package com.jbehave.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class SignInPage extends PageObject{
	
	@FindBy(id = "signInModalLabel")
	private WebElementFacade signInPopup;

	@FindBy(id = "sign-username")
	private WebElementFacade userNameField;

	@FindBy(id = "sign-password")
	private WebElementFacade passwordField;

	@FindBy(xpath = "//button[text()='Sign up']")
	private WebElementFacade signUpButton;

	@FindBy(xpath = "//div[@id='signInModal']//button[text()='Close']")
	private WebElementFacade closeButton;

	@FindBy(xpath = "//h5[text()='Sign up']/..//button[@aria-label='Close']")
	private WebElementFacade closeSigninPopup;

	public void enterUserName(String userName) {
		signInPopup.waitUntilVisible();
		userNameField.clear();
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	public void clickSignUpButton() {
		signUpButton.click();
	}

	public void clickCloseButton() {
		closeButton.click();
	}

	public void closeLoginPopup() {
		closeSigninPopup.click();
	}
	
}
