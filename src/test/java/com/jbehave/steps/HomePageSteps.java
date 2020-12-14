package com.jbehave.steps;

import org.junit.Assert;

import com.jbehave.pages.HomePage;

import net.thucydides.core.annotations.Step;

public class HomePageSteps {

    HomePage homePage;

    @Step
    public void navigateToLoginPage() {
    	homePage.clickLogInLink();
    }
    
    @Step
    public void navigateToSigninPage() {
    	homePage.clickSignUpLink();
    }
    
    @Step
    public void navigateToAboutUsPage() {
    	homePage.clickAboutUsLink();
    }

    @Step
    public void navigateToContactPage() {
    	homePage.clickContactLink();
    }
    
    @Step
    public void navigateToCartPage() {
    	homePage.clickCartLink();
    }
    
    @Step
    public void navigateToHomePage() {
    	homePage.clickHomeLink();
    }
    
    @Step
    public void verifyLoginSuccess(String userName) {
        Assert.assertTrue("Login failed", homePage.getUserName().contains(userName));
    }

    @Step
    public void openHomePage() {
    	homePage.open();
    	homePage.getDriver().manage().window().maximize();
    }
    
    @Step
    public void logout() {
    	homePage.clickLogOutLink();
    	Assert.assertTrue("Logout failed", homePage.isLoginDisplayed());
    }
}