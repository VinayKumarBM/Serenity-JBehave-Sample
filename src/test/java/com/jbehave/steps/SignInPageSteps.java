package com.jbehave.steps;

import com.jbehave.pages.SignInPage;

import net.thucydides.core.annotations.Step;

public class SignInPageSteps {
    
    SignInPage signInPage;

    @Step
    public void enterSignUpDetails(String userName, String password) {
    	signInPage.enterUserName(userName);
    	signInPage.enterPassword(password);
    	signInPage.clickSignUpButton();
    }
}