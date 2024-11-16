package com.selenium_project.Utilities.Locators;

import org.openqa.selenium.By;

public class ProfilePageLocators {
    
    public static By editButton = By.cssSelector(".profile-info > button");
    public static By usernameInput = By.cssSelector("input[type=\"text\"][name=\"username\"]");
    public static By firstNameInput = By.cssSelector("input[type=\"text\"][name=\"first_name\"]");
    public static By lastNameInput = By.cssSelector("input[type=\"text\"][name=\"last_name\"]");
    public static By emailInput = By.cssSelector("input[type=\"email\"][name=\"email\"]");
    public static By phoneNumberInput = By.cssSelector("input[type=\"text\"][name=\"phone_number\"]");
    public static By genderInput = By.cssSelector("input[type=\"text\"][name=\"gender\"]");
    public static By bioInput = By.cssSelector("input[type=\"text\"][name=\"bio\"]");
    public static By saveButton = By.cssSelector("button.save-button");
    public static By cancelButton = By.cssSelector("button.cancel-button");
    public static By uploadProfilePictureButton = By.cssSelector("button:contains('Upload Profile Picture')");
    public static By fileInput = By.cssSelector("input[type=\"file\"]");
    public static By profileLink = By.cssSelector("a.nav-link[role=\"button\"][tabindex=\"0\"]:contains('Profile')");
    public static By aboutLink = By.cssSelector("a.nav-link[role=\"button\"][tabindex=\"0\"]:contains('About')");
    public static By imagesLink = By.cssSelector("a.nav-link[role=\"button\"][tabindex=\"0\"]:contains('Images')");
    public static By videosLink = By.cssSelector("a.nav-link[role=\"button\"][tabindex=\"0\"]:contains('Videos')");
    public static By hideLastNameButton = By.cssSelector("div.form-group input[name=\"last_name\"] + label + button.toggle-button");
    public static By hideFirstNameButton = By.cssSelector("div.form-group input[name=\"first_name\"] + label + button.toggle-button");
    public static By hideEmailButton = By.cssSelector("div.form-group input[name=\"email\"] + label + button.toggle-button");
    public static By hidePhoneNumberButton = By.cssSelector("div.form-group input[name=\"phone_number\"] + label + button.toggle-button");
    public static By hideGenderButton = By.cssSelector("div.form-group input[name=\"gender\"] + label + button.toggle-button");
    public static By addFriendButton = By.cssSelector("button.add-friend-button");
    public static By removeFriendButton = By.cssSelector("button.remove-friend-button");
    public static By profilePictureImg = By.cssSelector("div[style*='background-color: white; border-radius: 50%;'] img[src='/images/profile_pic.jpg']");
    public static By profileEditContainer = By.cssSelector("div.profile-edit-container");
    public static By bioField = By.cssSelector("div.profile-fields input[name='bio']");
    public static By phoneNumberSelector = By.cssSelector(".about-section p strong:contains('Phone Number:')");
 }

