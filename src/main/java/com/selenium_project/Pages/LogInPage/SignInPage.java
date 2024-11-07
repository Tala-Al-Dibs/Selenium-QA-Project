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
        inputUsername.sendKeys(username);
    }

    public void inputPassword(String password) {
        WebElement inputPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(SignInPageLocators.signinInputPassword));
        inputPassword.sendKeys(password);
    }

    public void clickSignInButton() {
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(SignInPageLocators.signinInButton));
        signInButton.click();
    }
}
