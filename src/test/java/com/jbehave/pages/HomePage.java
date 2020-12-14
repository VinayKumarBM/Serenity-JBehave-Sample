package com.jbehave.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.demoblaze.com/index.html")
public class HomePage extends PageObject{

	private Logger log = LoggerFactory.getLogger(getClass().getName());

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	private WebElementFacade homeLink;

	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	private WebElementFacade contactLink;

	@FindBy(xpath = "//a[contains(text(),'About us')]")
	private WebElementFacade aboutUsLink;

	@FindBy(xpath = "//a[contains(text(),'Cart')]")
	private WebElementFacade cartLink;

	@FindBy(id = "login2")
	private WebElementFacade logInLink;

	@FindBy(id = "logout2")
	private WebElementFacade logOutLink;

	@FindBy(id = "signin2")
	private WebElementFacade signUpLink;

	@FindBy(id = "nameofuser")
	private WebElementFacade userNameText;

	public void clickHomeLink() {
		homeLink.click();
	}

	public void clickContactLink() {
		contactLink.click();
	}

	public void clickAboutUsLink() {
		aboutUsLink.click();
	}

	public void clickCartLink() {
		cartLink.click();
	}

	public void clickLogInLink() {
		logInLink.click();
	}

	public void clickLogOutLink() {
		logOutLink.click();
	}

	public void clickSignUpLink() {
		signUpLink.click();
	}

	public String getUserName() {
		userNameText.waitUntilVisible();
		String userName = userNameText.getText();
		log.info("Login Message: "+userName);
		return userName;
	}

	public boolean isLoginDisplayed() {
		return logInLink.isCurrentlyVisible();
	}
}
