package com.selenium_project.Pages.PostPage;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;
import com.selenium_project.Utilities.Excel.ExcelUtil;
import com.selenium_project.Utilities.Locators.PostLocators;

public class PostPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PostPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void createPost(String description) {
        WebElement postInput = wait.until(ExpectedConditions.visibilityOfElementLocated(PostLocators.postInputDescription));
        postInput.clear();
        postInput.sendKeys(description);
        WebElement postButton = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.postButton));
        postButton.click();
    }

 
public void editPost(String updatedDescription) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(PostLocators.postContainer)).click();
    wait.until(ExpectedConditions.elementToBeClickable(PostLocators.threeDotsIcon)).click();
    wait.until(ExpectedConditions.elementToBeClickable(PostLocators.editButton)).click();
    
    WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(PostLocators.editpostInputDescription));
    
    descriptionInput.clear();
    descriptionInput.sendKeys(updatedDescription);
    
    ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + updatedDescription + "';", descriptionInput);

    wait.until(ExpectedConditions.elementToBeClickable(PostLocators.submiteditButton)).click();
    driver.navigate().refresh();

    wait.until(ExpectedConditions.textToBePresentInElementLocated(PostLocators.postContainer, updatedDescription));
}

  
    
    public void deletePost() {
        WebElement postContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(PostLocators.postContainer));
        WebElement threeDotsIcon = postContainer.findElement(PostLocators.threeDotsIcon);
        threeDotsIcon.click();
    
        WebElement deleteOption = wait.until(ExpectedConditions.visibilityOfElementLocated(PostLocators.deleteOptionInDropdown));
        deleteOption.click();
    
        wait.until(ExpectedConditions.invisibilityOf(postContainer)); 
    }
    
    public String getPostDescription() {
        WebElement descriptionElement = driver.findElement(PostLocators.postInputDescription);
        return descriptionElement.getText();
    }
    public boolean isPostDisplayedByDescription(String description) {
        return driver.findElements(PostLocators.postInputDescription).size() > 0;
    }

    public String getCurrentPostDescription() {
        return driver.findElement(By.cssSelector(".post-content h2")).getText();
    }
    
    public boolean isPostDeleted(String description) {
        return driver.findElements(By.xpath("//div[contains(text(), '" + description + "')]")).size() == 0;
    }

    public void reactToPost(String reactionType) {
        WebElement postContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(PostLocators.postContainer));
        WebElement reactButton = postContainer.findElement(PostLocators.reactButton);
        reactButton.click();

        // Click the corresponding reaction based on the passed argument
        switch (reactionType.toUpperCase()) {
            case "LIKE":
                wait.until(ExpectedConditions.elementToBeClickable(PostLocators.likeReaction)).click();
                break;
            case "LOVE":
                wait.until(ExpectedConditions.elementToBeClickable(PostLocators.loveReaction)).click();
                break;
            case "HAHA":
                wait.until(ExpectedConditions.elementToBeClickable(PostLocators.hahaReaction)).click();
                break;
            case "WOW":
                wait.until(ExpectedConditions.elementToBeClickable(PostLocators.wowReaction)).click();
                break;
            case "SAD":
                wait.until(ExpectedConditions.elementToBeClickable(PostLocators.sadReaction)).click();
                break;
            case "ANGRY":
                wait.until(ExpectedConditions.elementToBeClickable(PostLocators.angryReaction)).click();
                break;
            default:
                System.out.println("Invalid reaction type.");
        }
    }
}