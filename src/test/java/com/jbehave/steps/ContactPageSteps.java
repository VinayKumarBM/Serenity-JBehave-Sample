package com.jbehave.steps;

import com.jbehave.pages.ContactPage;

import net.thucydides.core.annotations.Step;

public class ContactPageSteps {
    
    ContactPage contactPage;

    @Step
    public void enterContactDetails(String contactEmail, String contactName, String contactMessage) {
    	contactPage.enterContactEmail(contactEmail);
    	contactPage.enterContactName(contactName);
    	contactPage.enterMessage(contactMessage);
    	contactPage.clickSendMessageButton();
    }

}