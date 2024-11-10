package com.selenium_project.Pages.PostPage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

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
    public void createPost(String description, String privacy) {
        WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(PostLocators.postInputDescription));
        descriptionInput.sendKeys(description);
    
        WebElement privacyDropdown = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.postInputPrivacyDropdown));
        privacyDropdown.click();
    
        if (privacy.equalsIgnoreCase("Public")) {
            WebElement publicOption = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.publicOption));
            publicOption.click();
        } else {
            WebElement privateOption = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.privateOption)); // Adjust the locator for "Private"
            privateOption.click();
        }
    
        WebElement postButton = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.postButton));
        postButton.click();
    }
    

    public void editPost(String newDescription) {
        WebElement threeDots = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.threeDotsIcon));
        threeDots.click();
    
        WebElement editOption = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.editOptionInDropdown));
        editOption.click();
    
        WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(PostLocators.postInputDescription));
        descriptionInput.clear(); 
        descriptionInput.sendKeys(newDescription);  
    }
    
    

   // React to a post with a specific reaction type
public void reactToPost(String reactionType) {
    WebElement reactButton = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.reactButton));
    reactButton.click();

    Map<String, By> reactionMap = new HashMap<>();
    reactionMap.put("LIKE", PostLocators.likeReaction);
    reactionMap.put("LOVE", PostLocators.loveReaction);
    reactionMap.put("HAHA", PostLocators.hahaReaction);
    reactionMap.put("WOW", PostLocators.wowReaction);
    reactionMap.put("SAD", PostLocators.sadReaction);
    reactionMap.put("ANGRY", PostLocators.angryReaction);

    By reactionLocator = reactionMap.get(reactionType.toUpperCase());

    if (reactionLocator != null) {
        wait.until(ExpectedConditions.elementToBeClickable(reactionLocator)).click();
    } else {
        throw new IllegalArgumentException("Invalid reaction type: " + reactionType);
    }
}

    // Delete a post
    public void deletePost() {
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.deleteButton));
        deleteButton.click();
    }
    

    // public void createPostsFromExcel(String excelFilePath, String privacy) {
    //     try {
    //         ExcelUtil.loadUsersFromExcel(excelFilePath);

    //         for (String postDescription : ExcelUtil.getPosts()) {
    //             createPost(postDescription, privacy);
    //             System.out.println("Created post with description: " + postDescription);
    //         }

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         System.out.println("Error reading posts from Excel: " + e.getMessage());
    //     }
    // }

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
