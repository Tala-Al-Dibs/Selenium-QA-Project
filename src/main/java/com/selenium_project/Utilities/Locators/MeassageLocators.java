package com.selenium_project.Utilities.Locators;

import org.openqa.selenium.By;

public class MeassageLocators {

    public static By firstFrind = By.cssSelector(".friend-list>.friend-list-item:nth-child(1)");
    public static By inputMessageField = By.id("input-message-text");
    public static By sendMessageButton = By.className("sendButtons");
    public static By sentMessageContent = By.cssSelector(".text-right:last-child");

}
