package com.jbehave.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jbehave.utils.ElementOperations;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ProductLandingPage extends PageObject{
	
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	private final String PRODUCT_CATEGORIES_PATH = "//div/a[text()='%s']";
	private final String PRODUCT_NAME_PATH = "//h4/a[text()='%s']";
	private final String PRODUCT_COST_PATH = "//h4/a[text()='%s']/../../h5";
	private final String PRODUCT_DETAILS_PATH = "//h4/a[text()='%s']/../../p";
	
	@FindBy(css = "h4.card-title>a")
	private WebElementFacade productName;
	
	@FindBy(xpath = "//button[@class='page-link'][text()='Previous']")
	private WebElementFacade previousLink;
	
	@FindBy(xpath = "//button[@class='page-link'][text()='Next']")
	private WebElementFacade nextLink;
	
	private WebElement getWebElement(String path, String value) {
		return new WebDriverWait(getDriver(), getImplicitWaitTimeout().toMillis())
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(String.format(path, value))));
	}		
	
	public void selectProductCategory(String category) {
		getWebElement(PRODUCT_CATEGORIES_PATH, category).click();
		ElementOperations.pause(5);
	}
	
	public String getProductCost(String product) {
		String cost = getWebElement(PRODUCT_COST_PATH, product).getText();
		log.info(product+" cost: "+cost);
		return cost.trim();
	}
	
	public String getProductDetails(String product) {
		String details = getWebElement(PRODUCT_DETAILS_PATH, product).getText();
		log.info(product+" Details:\n"+details);
		return details.trim();
	}
	
	public void clickOnProduct(String product) {
		getWebElement(PRODUCT_NAME_PATH, product).click();
	}
	
	public String getFirstProductName() {
		String name = productName.getText();
		log.info("Product Name: "+name);
		return name.trim();
	}
	
	public void clickNextLink() {
		nextLink.click();
		ElementOperations.pause(3);
	}
	
	public void clickPreviousLink() {
		previousLink.click();
		ElementOperations.pause(3);
	}
}
