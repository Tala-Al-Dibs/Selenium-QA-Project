package com.selenium_project.Pages.LogInPage;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.selenium_project.Utilities.Locators.SignInPageLocators;

@SuppressWarnings("unused")
public class SignInPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void inputUsername(String username) {
        WebElement inputUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(SignInPageLocators.signinInputUsername));
        inputUsername.clear();
        inputUsername.sendKeys(username);
    }

    public void inputPassword(String password) {
        WebElement inputPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(SignInPageLocators.signinInputPassword));
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }

    public void clickSignInButton() {
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(SignInPageLocators.signinInButton));
        signInButton.click();
    }

    public String inputUsernameText() {
        WebElement inputUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(SignInPageLocators.signinInputUsername));
        return inputUsername.getAttribute("value");    
    }

    public String inputPassweordText() {
        WebElement inputPassweord = wait.until(ExpectedConditions.visibilityOfElementLocated(SignInPageLocators.signinInputPassword));
        return inputPassweord.getAttribute("value");    
    }

    public Boolean getHelloUsername() {
        WebElement helloUser = wait.until(ExpectedConditions.visibilityOfElementLocated(SignInPageLocators.helloUsername));
        return helloUser.isDisplayed();
    }
}
