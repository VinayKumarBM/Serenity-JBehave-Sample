package com.jbehave.definitionsteps;

import org.jbehave.core.annotations.When;

import com.jbehave.steps.ContactPageSteps;
import com.jbehave.steps.HomePageSteps;

import net.thucydides.core.annotations.Steps;

public class ContactPageDefinitionSteps {

	@Steps
    HomePageSteps homePageSteps;
    @Steps
    ContactPageSteps contactPageSteps; 
    
    @When("the user enters the contact details $<contactEmail>, $<contactName> and $<contactMessage> on the Contact popup")
    public void enterContactDetails(String contactEmail, String contactName, String contactMessage) {
    	homePageSteps.navigateToContactPage();
    	contactPageSteps.enterContactDetails(contactEmail, contactName, contactMessage);    	
    }
}
