package com.jbehave.definitionsteps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.jbehave.steps.AboutUsPageSteps;
import com.jbehave.steps.HomePageSteps;

import net.thucydides.core.annotations.Steps;

public class AboutusPageDefinitionSteps {

	@Steps
    HomePageSteps homePageSteps;
    @Steps
    AboutUsPageSteps aboutUsPageSteps;
    
    @When("the user plays the video on the About Us pop")
    public void userPlaysTheVideoOnTheAboutUsPop() {
    	homePageSteps.navigateToAboutUsPage();
    	aboutUsPageSteps.playTheVideo();
    }

    @Then("the user should see the video playing")
    public void userShouldSeeTheVideoPlaying() {
    	aboutUsPageSteps.verifyVideoIsPlaying();
    }
}
