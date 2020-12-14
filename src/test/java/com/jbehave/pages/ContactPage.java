package com.jbehave.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ContactPage extends PageObject{
	
	@FindBy(id = "exampleModalLabel")
	private WebElementFacade contactPopup;

	@FindBy(id = "recipient-email")
	private WebElementFacade contactEmailField;

	@FindBy(id = "recipient-name")
	private WebElementFacade contactNameField;
	
	@FindBy(id = "message-text")
	private WebElementFacade messageTextarea;

	@FindBy(xpath = "//button[text()='Send message']")
	private WebElementFacade sendMessageButton;

	@FindBy(xpath = "//div[@id='exampleModal']//button[text()='Close']")
	private WebElementFacade closeButton;

	@FindBy(xpath = "//h5[text()='New message']/..//button[@aria-label='Close']")
	private WebElementFacade closeContactPopup;

	public void enterContactEmail(String contactEmail) {
		contactPopup.waitUntilVisible();
		contactEmailField.clear();
		contactEmailField.type(contactEmail);
	}

	public void enterContactName(String contactName) {
		contactNameField.clear();
		contactNameField.type(contactName);
	}
	
	public void enterMessage(String message) {
		messageTextarea.clear();
		messageTextarea.type(message);
	}

	public void clickSendMessageButton() {
		sendMessageButton.click();
	}

	public void clickCloseButton() {
		closeButton.click();
	}

	public void closeLoginPopup() {
		closeContactPopup.click();
	}
}
