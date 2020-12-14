package com.jbehave.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jbehave.utils.ElementOperations;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CartPage extends PageObject{
	
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@FindBy(xpath = "//tr[@class='success']//a[text()='Delete']")
	private List<WebElementFacade> deleteLink;

	@FindBy(xpath = "//tr[@class='success']/td[2]")
	private List<WebElementFacade> productTitleText;

	@FindBy(xpath = "//tr[@class='success']/td[3]")
	private List<WebElementFacade> priceText;
	
	@FindBy(id = "totalp")
	private WebElementFacade totalPriceText;

	@FindBy(xpath = "//button[text()='Place Order']")
	private WebElementFacade placeOrderButton;

	public int deleteAllProducts() {
		for(int i=deleteLink.size()-1; i>=0; i--) {
			deleteLink.get(i).click();
			ElementOperations.pause(2);
		}
		return getDriver().findElements(By.linkText("Delete")).size();
	}
	
	public float getCombinedPrices() {
		float total = 0.0f;
		for(WebElementFacade price: priceText) {
			total = total+ Float.valueOf(price.getText());
		}
		log.info("Combined Total: "+total);
		return total;
	}
	
	public List<String> getProductsInCart() {
		List<String> productList = new ArrayList<String>();
		for(WebElementFacade product: productTitleText) {
			productList.add(product.getText());
		}
		log.info("Cart Products: "+productList);
		return productList;
	}
	
	public float getTotal() {
		String total = totalPriceText.getText();
		log.info("Total: "+total);
    	Serenity.setSessionVariable("cartTotal").to(total);
		return Float.valueOf(total);
	}
	
	public void clickPlaceOrderButton() {
		placeOrderButton.click();
	}
}
