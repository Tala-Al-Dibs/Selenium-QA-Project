package com.selenium_project.Pages.MessagePage;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.selenium_project.Utilities.Locators.MeassageLocators;

@SuppressWarnings("unused")
public class MeassagePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MeassagePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void clickMessageIcon() {
        WebElement messageIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(MeassageLocators.messageIconOnHeader));
        messageIcon.click();
    }

    public void selectFirstFriend() {
        WebElement firstFriend = wait.until(ExpectedConditions.elementToBeClickable(MeassageLocators.firstFrind));
        firstFriend.click();
    }

    public Boolean firstFrindIsSelected () {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(MeassageLocators.chatRoom)).isDisplayed();
    }

    public void inputMessage(String message) {
        WebElement inputMessageField = wait.until(ExpectedConditions.visibilityOfElementLocated(MeassageLocators.inputMessageField));
        inputMessageField.sendKeys(message);
    }

    public void clickSendMessageButton() {
        WebElement sendMessageButton = wait.until(ExpectedConditions.elementToBeClickable(MeassageLocators.sendMessageButton));
        sendMessageButton.click();
    }

    public String getLastSentMessageContent() {
        WebElement sentMessageContent = wait.until(ExpectedConditions.visibilityOfElementLocated(MeassageLocators.sentMessageContent));
        return sentMessageContent.getText();
    }
}
