package com.selenium_project.Pages.SignUpPage;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium_project.Utilities.Locators.SignInPageLocators;
import com.selenium_project.Utilities.Locators.SignUpPageLocators;

@SuppressWarnings("unused")
public class SignUpPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void inputUsername(String username) {
        WebElement inputUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpPageLocators.signupInputUsername));
        inputUsername.clear();
        inputUsername.sendKeys(username);
        wait.until(ExpectedConditions.textToBePresentInElementValue(SignUpPageLocators.signupInputUsername, username));
    }

    public String getInputUsernameText( ) {
        WebElement inputUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpPageLocators.signupInputUsername));
        return inputUsername.getAttribute("value");
    }

    public void inputEmail(String email) {
        WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpPageLocators.signupInputEmail));
        inputEmail.sendKeys(email);
    }

    public void inputPassword(String password) {
        WebElement inputPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpPageLocators.signupInputPassword));
        inputPassword.sendKeys(password);
    }

    public void inputFirstName(String firstName) {
        WebElement inputFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpPageLocators.signupInputFirstName));
        inputFirstName.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        WebElement inputLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpPageLocators.signupInputLastName));
        inputLastName.sendKeys(lastName);
    }

    public void selectGenderMale() {
        WebElement genderMale = wait.until(ExpectedConditions.elementToBeClickable(SignUpPageLocators.signupGenderMale));
        genderMale.click();
    }

    public void clickCreateAccount() {
        WebElement newAccountLink = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpPageLocators.creatAccount));
        newAccountLink.click();
    }

    public void selectGenderFemale() {
        WebElement genderFemale = wait.until(ExpectedConditions.elementToBeClickable(SignUpPageLocators.signupGenderFemale));
        genderFemale.click();
    }

    public void inputDateOfBirth(String dateOfBirth) {
        WebElement inputDateOfBirth = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpPageLocators.signupInputDateOfBirth));
        inputDateOfBirth.sendKeys(dateOfBirth);
    }

    public void inputLocation(String location) {
        WebElement inputLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpPageLocators.signupInputLocation));
        inputLocation.sendKeys(location);
    }

    public void inputPhoneNumber(String phoneNumber) {
        WebElement inputPhoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpPageLocators.signupInputPhoneNumber));
        inputPhoneNumber.sendKeys(phoneNumber);
    }

    public void clickSignUpButton() {
        WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(SignUpPageLocators.signupButton));
        scrollToElement(signUpButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signUpButton);
    }

    public Boolean allFieldsMessage () {
        WebElement allFieldsMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SignUpPageLocators.signUpMeassage));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", allFieldsMessage);
        return allFieldsMessage.isDisplayed();
    }
    

    public void scrollToElement(WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
}


    public Boolean getHelloUsername() {
        WebElement helloUser = wait.until(ExpectedConditions.visibilityOfElementLocated(SignInPageLocators.helloUsername));
        return helloUser.isDisplayed();
    }
}
