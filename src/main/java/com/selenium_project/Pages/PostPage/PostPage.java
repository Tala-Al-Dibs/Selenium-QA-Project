package com.selenium_project.Pages.PostPage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.selenium_project.Utilities.Locators.PostLocators;
import com.selenium_project.Utilities.Excel.ExcelUtil;

public class PostPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PostPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to create post using description and privacy
    public void createPost(String description, String privacy) {
        WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(PostLocators.postInputDescription));
        descriptionInput.sendKeys(description);
        WebElement privacyInput = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.postInputPrivacy));
        privacyInput.sendKeys(privacy);
        WebElement postButton = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.postButton));
        postButton.click();
    }

    // Edit an existing post
    public void editPost(String newDescription) {
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.editButton));
        editButton.click();
        WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(PostLocators.postInputDescription));
        descriptionInput.clear();
        descriptionInput.sendKeys(newDescription);
    }

    // React to a post with a specific reaction type
    public void reactToPost(String reactionType) {
        WebElement reactButton = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.reactButton));
        reactButton.click();

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
                throw new IllegalArgumentException("Invalid reaction type: " + reactionType);
        }
    }

    // Delete a post
    public void deletePost() {
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.deleteButton));
        deleteButton.click();
    }

    public void createPostsFromExcel(String excelFilePath, String privacy) {
        try {
            ExcelUtil.loadUsersFromExcel(excelFilePath);

            for (String postDescription : ExcelUtil.getPosts()) {
                createPost(postDescription, privacy);
                System.out.println("Created post with description: " + postDescription);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading posts from Excel: " + e.getMessage());
        }
    }

    public WebElement findPostByDescription(String description) {
        try {
            WebElement post = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(), '" + description + "')]")
            ));
            return post;
        } catch (Exception e) {
            System.out.println("Post with description '" + description + "' not found.");
            return null;
        }
    }
}
