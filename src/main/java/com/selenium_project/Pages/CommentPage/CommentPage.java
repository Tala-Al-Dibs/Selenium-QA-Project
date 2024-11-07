package com.selenium_project.Pages.CommentPage;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium_project.Utilities.Locators.CommentLocators;

public class CommentPage {
    
    private WebDriver driver;
    private WebDriverWait wait;

    public CommentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickCommentsIcon() {
        WebElement chatIcon = wait.until(ExpectedConditions.elementToBeClickable(CommentLocators.chatIcon));
        chatIcon.click();
    }

    public void inputComment(String comment) {
        WebElement commentInput = wait.until(ExpectedConditions.visibilityOfElementLocated(CommentLocators.commentInput));
        commentInput.sendKeys(comment);
    }

    public void clickSendButton() {
        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(CommentLocators.sendButton));
        sendButton.click();
    }

    public void clickSendButtonFace() {
        WebElement sendButtonFace = wait.until(ExpectedConditions.elementToBeClickable(CommentLocators.sendButtonFace));
        sendButtonFace.click();
    }

    public void clickMoreIcon() {
        WebElement moreIcon = wait.until(ExpectedConditions.elementToBeClickable(CommentLocators.moreIcon));
        moreIcon.click();
    }

    public void editComment(String newComment) {
        WebElement editInput = wait.until(ExpectedConditions.visibilityOfElementLocated(CommentLocators.editInput));
        editInput.clear();
        editInput.sendKeys(newComment);
    }

    public void clickSaveButton() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(CommentLocators.saveButton));
        saveButton.click();
    }

    public void clickCancelButton() {
        WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(CommentLocators.cancelButton));
        cancelButton.click();
    }

    public void clickLikeButton() {
        WebElement likeButton = wait.until(ExpectedConditions.elementToBeClickable(CommentLocators.likeButton));
        likeButton.click();
    }

    public void clickReplyButton() {
        WebElement replyButton = wait.until(ExpectedConditions.elementToBeClickable(CommentLocators.replyButton));
        replyButton.click();
    }

    public void inputReply(String reply) {
        WebElement replyInput = wait.until(ExpectedConditions.visibilityOfElementLocated(CommentLocators.replyInput));
        replyInput.sendKeys(reply);
    }

    public void clickSubmitReplyButton() {
        WebElement submitReplyButton = wait.until(ExpectedConditions.elementToBeClickable(CommentLocators.submitReplyButton));
        submitReplyButton.click();
    }
}


