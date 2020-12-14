package com.jbehave.definitionsteps;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.jbehave.steps.HomePageSteps;
import com.jbehave.steps.LoginPageSteps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class LoginPageDefinitionSteps {

	@Steps
	HomePageSteps homePageSteps;
	@Steps
	LoginPageSteps loginPageSteps;

	@Given("the user is on the Store home page")
	public void launchTheStoreApplication() {
		homePageSteps.openHomePage();
	}

	@Then("the user navigates to home page")
	public void navigateToHomePage() {
		homePageSteps.navigateToHomePage();
	}
	
	@When("the user enters the credentials $<userName> and $<password> on the Login popup")
	public void enterUserCredentials(String userName, String password) {
		if(userName.contains("%s")) {
			System.out.println(Serenity.sessionVariableCalled("userName").toString());
			userName = Serenity.sessionVariableCalled("userName").toString();
		}
		homePageSteps.navigateToLoginPage();
		loginPageSteps.enterLoginCredentials(userName, password);
	}

	@Then("the user $<userName> should be logged into the store")
	public void verifyUserIsLoggedIn(String userName) {
		if(userName.contains("%s")) {
			System.out.println(Serenity.sessionVariableCalled("userName").toString());
			userName = Serenity.sessionVariableCalled("userName").toString();
		}
		homePageSteps.verifyLoginSuccess(userName);
	}

	@Then("the user should see a message $<message>")
	@Alias("the user should see an alert message '$message'")
	public void verifyMessage(String message) {
		loginPageSteps.verifyAlertMessage(message);
	}

	@Then("the user logs out of the Store")
	public void userLogout() {
		homePageSteps.logout();
	}
}
