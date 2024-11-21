package com.selenium_project.Utilities.Locators;

import org.openqa.selenium.By;

public class SignInPageLocators {
    
    public static By signinInputUsername = By.cssSelector(".signin-input[name=\"username\"]");
    public static By signinInputPassword = By.cssSelector(".signin-input[name=\"password\"]");
    public static By signinInButton = By.className("signin-button");
    public static By helloUsername = By.cssSelector(".leftPart > h1");
    public static By badC = By.className("signin-message");

}
