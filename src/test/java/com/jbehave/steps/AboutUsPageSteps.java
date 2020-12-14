package com.jbehave.steps;

import org.junit.Assert;

import com.jbehave.pages.AboutUsPage;

import net.thucydides.core.annotations.Step;

public class AboutUsPageSteps {
    
    AboutUsPage aboutUsPage;

    @Step
    public void playTheVideo() {
    	aboutUsPage.playTheVideo();
    }
    
    @Step
    public void verifyVideoIsPlaying() {
    	Assert.assertFalse("Video did not play", aboutUsPage.isPlayButtonDisplayed());
    	aboutUsPage.clickCloseButton();
    }
}