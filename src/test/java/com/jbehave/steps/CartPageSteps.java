package com.jbehave.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.jbehave.pages.CartPage;

import net.thucydides.core.annotations.Step;

public class CartPageSteps {
    
    CartPage cartPage;

    @Step
    public void verifyCartDetalis() {
    	assertTrue("There are no products in cart", cartPage.getProductsInCart().size()>0);
    	assertEquals("Cart Total does not match: ", cartPage.getCombinedPrices(), cartPage.getTotal(), 0.0f);
    }

    @Step
    public void deleteAllProductsInCart() {
    	assertEquals("All Products are not delted", cartPage.deleteAllProducts(), 0);
    }
    
    @Step
    public void placeAnOrder() {
    	cartPage.clickPlaceOrderButton();
    }

	public void placeOrder() {
		cartPage.clickPlaceOrderButton();
	}
}