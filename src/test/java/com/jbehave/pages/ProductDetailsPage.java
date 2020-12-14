package com.jbehave.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ProductDetailsPage extends PageObject{
	
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@FindBy(css = "h2.name")
	private WebElementFacade productNameText;

	@FindBy(css = "h3.price-container")
	private WebElementFacade productPriceText;
	
	@FindBy(css = "#more-information>p")
	private WebElementFacade productDescriptionText;

	@FindBy(xpath = "//a[text()='Add to cart']")
	private WebElementFacade addToCartButton;
	
	public String getProductName() {
		String productName = productNameText.getText();
		log.info("Product: "+productName);
		return productName;
	}
	
	public String getProductDescription() {
		String productDescription = productDescriptionText.getText();
		log.info("Product Description: "+productDescription);
		return productDescription;
	}
	
	public String getProductPrice() {
		String productPrice = productPriceText.getText();
		log.info("Price: "+productPrice);
		return productPrice;
	}
	
	public void addProductToCart() {
		addToCartButton.click();
	}
}
