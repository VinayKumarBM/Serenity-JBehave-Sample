package com.jbehave.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class AboutUsPage extends PageObject{
	
	@FindBy(id = "videoModalLabel")
	private WebElementFacade aboutUsPopup;

	@FindBy(xpath = "//button[@title='Play Video']")
	private WebElementFacade playVideoButton;
	
	@FindBy(xpath = "//div[@id='videoModal']//button[text()='Close']")
	private WebElementFacade closeButton;

	@FindBy(xpath = "//h5[text()='About us']/..//button[@aria-label='Close']")
	private WebElementFacade closeLoginPopup;

	public void playTheVideo() {
		aboutUsPopup.waitUntilVisible();
		playVideoButton.click();
	}

	public boolean isPlayButtonDisplayed() {
		return playVideoButton.isCurrentlyVisible();
	}
	
	public void clickCloseButton() {
		closeButton.click();
	}

	public void closeLoginPopup() {
		closeLoginPopup.click();
	}
	
}
