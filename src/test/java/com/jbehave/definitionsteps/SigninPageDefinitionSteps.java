package com.jbehave.definitionsteps;

import org.jbehave.core.annotations.When;

import com.jbehave.steps.HomePageSteps;
import com.jbehave.steps.SignInPageSteps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class SigninPageDefinitionSteps {

	@Steps
    HomePageSteps homePageSteps;
    @Steps
    SignInPageSteps signInPageSteps; 
    
    @When("the user enters the $<userName> and $<password> on the Signin popup")
    public void enterUserNameAndPasswordOnTheSigninPopup(String userName, String password) {
    	userName = String.format(userName, System.currentTimeMillis());
    	Serenity.setSessionVariable("userName").to(userName);
    	homePageSteps.navigateToSigninPage();
    	signInPageSteps.enterSignUpDetails(userName, password);    	
    }
}
