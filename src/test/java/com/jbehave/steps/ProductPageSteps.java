package com.jbehave.steps;

import static org.junit.Assert.*;

import com.jbehave.pages.ProductDetailsPage;
import com.jbehave.pages.ProductLandingPage;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class ProductPageSteps {
    
    ProductLandingPage plp;
    ProductDetailsPage pdp;

    @Step
    public void selectProductCategory(String category) {
    	plp.selectProductCategory(category);
    }

    @Step
	public void selectProduct(String product) {
		Serenity.setSessionVariable("cost").to(plp.getProductCost(product));
		Serenity.setSessionVariable("details").to(plp.getProductDetails(product));
		plp.clickOnProduct(product);
	}
    
    @Step
    public void verifyProductDetails(String product) {
    	assertEquals("Product Name did not match", pdp.getProductName(), product);
    	assertEquals("Product Details did not match", pdp.getProductDescription(), Serenity.sessionVariableCalled("details"));
    	assertTrue("Product cost did not match", pdp.getProductPrice().contains(Serenity.sessionVariableCalled("cost")));
    }

    @Step
	public void verifyPagination() {
		String firstProduct = plp.getFirstProductName();
		plp.clickNextLink();
		assertFalse("Next link is not working", firstProduct.equals(plp.getFirstProductName()));		
		plp.clickPreviousLink();
		assertFalse("Previous link is not working", firstProduct.equals(plp.getFirstProductName()));
	}
    
    @Step
    public void addToCart() {
    	pdp.addProductToCart();
    }
}