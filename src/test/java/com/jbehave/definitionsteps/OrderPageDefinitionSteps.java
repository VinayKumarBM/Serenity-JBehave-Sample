package com.jbehave.definitionsteps;

import org.jbehave.core.annotations.Then;

import com.jbehave.steps.PlaceOrderPageSteps;

import net.thucydides.core.annotations.Steps;

public class OrderPageDefinitionSteps {

    @Steps
    PlaceOrderPageSteps placeOrderPageSteps; 
    
    @Then("the user enters the order details $<name>, $<country>, $<city>, $<creditCard>, $<month>, $<year>")
    public void enterOrderDetails(String name, String country, String city, String creditCard, String month, String year) {
    	placeOrderPageSteps.enterOrderDetails(name, country, city, creditCard, month, year);    	
    }
    
    @Then("the user see confirmation message $<confirmationMessage> with order details")
    public void verifyTheOrderDetails(String confirmationMessage) {
    	placeOrderPageSteps.verifyTheOrderDetails(confirmationMessage);
    }
    
    @Then("the user should see an alert message $<alertMsg>")
    public void verifyAlertMessageOnOrderPage(String alertMsg) {
    	placeOrderPageSteps.verifyAlertMessageOnOrderPage(alertMsg);
    }
}
