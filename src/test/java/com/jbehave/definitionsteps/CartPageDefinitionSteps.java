package com.jbehave.definitionsteps;

import org.jbehave.core.annotations.Then;

import com.jbehave.steps.CartPageSteps;
import com.jbehave.steps.HomePageSteps;

import net.thucydides.core.annotations.Steps;

public class CartPageDefinitionSteps {

	@Steps
	HomePageSteps homePageSteps;
	@Steps
    CartPageSteps cartPageSteps;
    
    @Then("the user sees the products in cart")
    public void verifyCartDetalis() {
    	homePageSteps.navigateToCartPage();
    	cartPageSteps.verifyCartDetalis();    	
    }
    
    @Then("the user deletes all the products on cart")
    public void deleteAllProductsInCart() {
    	cartPageSteps.deleteAllProductsInCart();
    }
    
    @Then("the user places an order")
    public void placeAnOrder() {
    	cartPageSteps.placeOrder();
    }
}
