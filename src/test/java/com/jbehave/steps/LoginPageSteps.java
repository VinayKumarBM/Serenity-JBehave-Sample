package com.jbehave.steps;

import org.junit.Assert;

import com.jbehave.pages.LogInPage;
import com.jbehave.utils.ElementOperations;

import net.thucydides.core.annotations.Step;

public class LoginPageSteps {
    
    LogInPage loginPage;

    @Step
    public void enterLoginCredentials(String userName, String password) {
    	loginPage.enterUserName(userName);
    	loginPage.enterPassword(password);
    	loginPage.clickLoginButton();
    }

    @Step
	public void verifyAlertMessage(String message) {
		Assert.assertEquals("Invalid message", message, ElementOperations.getAlertMessage(loginPage.getDriver()));
	}
}