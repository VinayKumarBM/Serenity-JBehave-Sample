package com.jbehave.steps;

import static org.junit.Assert.*;

import com.jbehave.pages.PlaceOrderPage;
import com.jbehave.utils.DateUtils;
import com.jbehave.utils.ElementOperations;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class PlaceOrderPageSteps {
    
    PlaceOrderPage placeOrderPage;

    @Step
    public void enterOrderDetails(String name, String country, String city, String creditCard, String month, String year) {
    	assertTrue("Order Total did not match", placeOrderPage.getOrderTotal().contains(Serenity.sessionVariableCalled("cartTotal")));
    	Serenity.setSessionVariable("name").to(name);
    	Serenity.setSessionVariable("creditCard").to(creditCard);
    	placeOrderPage.enterName(name);
    	placeOrderPage.enterCountryName(country);
    	placeOrderPage.enterCity(city);
    	placeOrderPage.enterCreditCard(creditCard);
    	placeOrderPage.enterMonth(month);
    	placeOrderPage.enterYear(year);
    	placeOrderPage.clickPurchaseButton();
    }

    @Step
	public void verifyTheOrderDetails(String message) {
		assertEquals("Order was not confirmed", message, placeOrderPage.getOrderConfirmation());
		String orderDetails = placeOrderPage.getOrderDetails();
		assertTrue("Total on Order Details did not match", orderDetails.contains(Serenity.sessionVariableCalled("cartTotal")));
		assertTrue("Name on Order Details did not match", orderDetails.contains(Serenity.sessionVariableCalled("name")));
		assertTrue("Credit Card on Order Details did not match", orderDetails.contains(Serenity.sessionVariableCalled("creditCard")));
		assertTrue("Date on Order Details did not match", orderDetails.contains(DateUtils.changeDateByMonths(-1,"d/M/yyyy")));
		placeOrderPage.clickOrderConfirmOKButton();
	}

	public void verifyAlertMessageOnOrderPage(String alertMsg) {
		assertEquals("Message did not match", alertMsg, ElementOperations.getAlertMessage(placeOrderPage.getDriver()));
	}

}