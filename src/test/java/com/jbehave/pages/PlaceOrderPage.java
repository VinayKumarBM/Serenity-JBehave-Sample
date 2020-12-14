package com.jbehave.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class PlaceOrderPage extends PageObject{
	
	private Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@FindBy(id = "orderModalLabel")
	private WebElementFacade placeOrderPopup;

	@FindBy(id = "totalm")
	private WebElementFacade totalText;
	
	@FindBy(id = "name")
	private WebElementFacade nameField;

	@FindBy(id = "country")
	private WebElementFacade countryField;
	
	@FindBy(id = "city")
	private WebElementFacade cityField;

	@FindBy(id = "card")
	private WebElementFacade creditCardField;
	
	@FindBy(id = "month")
	private WebElementFacade monthField;
	
	@FindBy(id = "year")
	private WebElementFacade yearField;

	@FindBy(xpath = "//button[text()='Purchase']")
	private WebElementFacade purchaseButton;
	
	@FindBy(xpath = "//div[@id='orderModal']//button[text()='Close']")
	private WebElementFacade closeButton;

	@FindBy(xpath = "//h5[text()='Place order']/..//button[@aria-label='Close']")
	private WebElementFacade closePlaceOrderPopup;
	
	@FindBy(xpath = "//div[@data-animation='pop']/h2")
	private WebElementFacade orderConfirmText;
	
	@FindBy(xpath = "//div[@data-animation='pop']/p")
	private WebElementFacade orderDetailsText;
	
	@FindBy(xpath = "//div[@data-animation='pop']//button[text()='OK']")
	private WebElementFacade orderConfirmOkButton;
	
	public String getOrderTotal() {
		placeOrderPopup.waitUntilVisible();
		log.info("Total: "+totalText.getText());
		return totalText.getText();
	}
	
	public void enterName(String name) {		
		nameField.clear();
		nameField.type(name);
	}

	public void enterCountryName(String countryName) {
		countryField.clear();
		countryField.type(countryName);
	}
	
	public void enterCity(String city) {
		cityField.clear();
		cityField.type(city);
	}

	public void enterCreditCard(String creditCard) {
		creditCardField.clear();
		creditCardField.type(creditCard);
	}
	
	public void enterMonth(String month) {
		monthField.clear();
		monthField.type(month);
	}
	
	public void enterYear(String year) {
		yearField.clear();
		yearField.type(year);
	}
	
	public void clickPurchaseButton() {
		purchaseButton.click();
	}

	public void clickCloseButton() {
		closeButton.click();
	}

	public void closeLoginPopup() {
		closePlaceOrderPopup.click();
	}
	
	public String getOrderConfirmation() {
		orderConfirmText.waitUntilVisible();
		log.info("Confirmation Message: "+orderConfirmText.getText());
		return orderConfirmText.getText();
	}
	
	public String getOrderDetails() {		
		log.info("Order Details:\n"+orderDetailsText.getText());
		return orderDetailsText.getText();
	}
	
	public void clickOrderConfirmOKButton() {
		orderConfirmOkButton.click();
	}
}
