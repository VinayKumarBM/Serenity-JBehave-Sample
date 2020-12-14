package com.jbehave.definitionsteps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.jbehave.steps.HomePageSteps;
import com.jbehave.steps.ProductPageSteps;

import net.thucydides.core.annotations.Steps;

public class ProductPageDefinitionSteps {

	@Steps
	HomePageSteps homePageSteps;
	@Steps
    ProductPageSteps productPageSteps;
    
    @When("the user filters products by Category $<category>")    
    public void userFiltersProductsByCategory(String category) {
    	productPageSteps.selectProductCategory(category);
    }

    @When("the user selects the product $product from PLP")    
    public void userSelectsTheProductFromPLP(String product) {
    	productPageSteps.selectProduct(product);
    }

    @Then("the user should see all the product details of $<product> on PDP")    
    public void userShouldSeeAllTheProductDetailsOnPDP(String product) {
    	productPageSteps.verifyProductDetails(product);
    }
    
    @Then("the user verifes the Pagination of PLP")    
    public void userVerifesPaginationOfPLP() {
    	productPageSteps.verifyPagination();
    }
    
    @When("the user adds the product to cart")
    public void addToCart() {
    	productPageSteps.addToCart();
    }
    
    @Then("the user adds another product '$anotherproduct' to cart")
    public void addAnotherProductToCart(String anotherproduct) {
    	homePageSteps.navigateToHomePage();
    	productPageSteps.selectProduct(anotherproduct);   
    	productPageSteps.addToCart();
    }
}
