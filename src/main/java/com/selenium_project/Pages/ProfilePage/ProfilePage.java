package com.selenium_project.Pages.ProfilePage;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.selenium_project.Utilities.Locators.ProfilePageLocators;

public class ProfilePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickEditButton() {
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(ProfilePageLocators.editButton));
        editButton.click();
    }

    public void inputUsername(String username) {
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(ProfilePageLocators.usernameInput));
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void inputFirstName(String firstName) {
        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(ProfilePageLocators.firstNameInput));
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(ProfilePageLocators.lastNameInput));
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void inputEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(ProfilePageLocators.emailInput));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void inputPhoneNumber(String phoneNumber) {
        WebElement phoneNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(ProfilePageLocators.phoneNumberInput));
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phoneNumber);
    }

    public void inputGender(String gender) {
        WebElement genderInput = wait.until(ExpectedConditions.visibilityOfElementLocated(ProfilePageLocators.genderInput));
        genderInput.clear();
        genderInput.sendKeys(gender);
    }

    public void inputBio(String bio) {
        WebElement bioInput = wait.until(ExpectedConditions.visibilityOfElementLocated(ProfilePageLocators.bioInput));
        bioInput.clear();
        bioInput.sendKeys(bio);
    }

    public void clickSaveButton() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(ProfilePageLocators.saveButton));
        saveButton.click();
    }

    public void clickCancelButton() {
        WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(ProfilePageLocators.cancelButton));
        cancelButton.click();
    }

    public void clickUploadProfilePictureButton() {
        WebElement uploadProfilePictureButton = wait.until(ExpectedConditions.elementToBeClickable(ProfilePageLocators.uploadProfilePictureButton));
        uploadProfilePictureButton.click();
    }

    public void uploadProfilePicture(String filePath) {
        WebElement fileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(ProfilePageLocators.fileInput));
        fileInput.sendKeys(filePath);
    }

    public void clickProfileLink() {
        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(ProfilePageLocators.profileLink));
        profileLink.click();
    }

    public void clickAboutLink() {
        WebElement aboutLink = wait.until(ExpectedConditions.elementToBeClickable(ProfilePageLocators.aboutLink));
        aboutLink.click();
    }

    public void clickImagesLink() {
        WebElement imagesLink = wait.until(ExpectedConditions.elementToBeClickable(ProfilePageLocators.imagesLink));
        imagesLink.click();
    }

    public void clickVideosLink() {
        WebElement videosLink = wait.until(ExpectedConditions.elementToBeClickable(ProfilePageLocators.videosLink));
        videosLink.click();
    }

    public void clickHideLastNameButton() {
        WebElement hideLastNameButton = wait.until(ExpectedConditions.elementToBeClickable(ProfilePageLocators.hideLastNameButton));
        hideLastNameButton.click();
    }

    public void clickHideFirstNameButton() {
        WebElement hideFirstNameButton = wait.until(ExpectedConditions.elementToBeClickable(ProfilePageLocators.hideFirstNameButton));
        hideFirstNameButton.click();
    }

    public void clickHideEmailButton() {
        WebElement hideEmailButton = wait.until(ExpectedConditions.elementToBeClickable(ProfilePageLocators.hideEmailButton));
        hideEmailButton.click();
    }

    public void clickHidePhoneNumberButton() {
        WebElement hidePhoneNumberButton = wait.until(ExpectedConditions.elementToBeClickable(ProfilePageLocators.hidePhoneNumberButton));
        hidePhoneNumberButton.click();
    }

    public void clickHideGenderButton() {
        WebElement hideGenderButton = wait.until(ExpectedConditions.elementToBeClickable(ProfilePageLocators.hideGenderButton));
        hideGenderButton.click();
    }

    public void clickAddFriendButton() {
        WebElement addFriendButton = wait.until(ExpectedConditions.elementToBeClickable(ProfilePageLocators.addFriendButton));
        addFriendButton.click();
    }

    public void clickRemoveFriendButton() {
        WebElement removeFriendButton = wait.until(ExpectedConditions.elementToBeClickable(ProfilePageLocators.removeFriendButton));
        removeFriendButton.click();
    }
}
