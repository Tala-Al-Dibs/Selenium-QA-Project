package com.selenium_project.Pages.PostPage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
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
   
    
    // public void createPost(String description, String privacy) {
    //     try {
    //         WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(PostLocators.postInputDescription));
    //         descriptionInput.sendKeys(description);
    
    //         WebElement privacyDropdown = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.postInputPrivacyDropdown));
    //         privacyDropdown.click();
    
    //         if (privacy.equalsIgnoreCase("Public")) {
    //             WebElement publicOption = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.publicOption));
    //             publicOption.click();
    //         } else {
    //             WebElement privateOption = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.privateOption));
    //             privateOption.click();
    //         }
    
    //         WebElement postButton = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.postButton));
    //         postButton.click();
    //     } catch (TimeoutException e) {
    //         System.out.println("Timeout while waiting for elements in createPost method.");
    //         throw e;  
    //     }
    // }

// Updated createPost method
public void createPost(String description, String privacy) {
    try {
        WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(PostLocators.postInputDescription));
        descriptionInput.sendKeys(description);

        WebElement postButton = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.postButton));

        // If the button is covered by another element, execute JavaScript click
        if (postButton.isEnabled() && postButton.isDisplayed()) {
            // Use JavaScript click as a fallback
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", postButton);
        } else {
            System.out.println("Post button is not clickable.");
        }

        // Handle any alert that appears after clicking the post button
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException e) {
            // Handle no alert exception if no alert is present
        }

    } catch (TimeoutException e) {
        System.out.println("Timeout while waiting for elements in createPost method.");
        throw e;
    } catch (Exception e) {
        System.out.println("Error occurred: " + e.getMessage());
    }
}

    // public void editPost(String newDescription) {
    //     WebElement threeDots = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.threeDotsIcon));
    //     threeDots.click();
    
    //     WebElement editOption = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.editOptionInDropdown));
    //     editOption.click();
    
    //     WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(PostLocators.postInputDescription));
    //     descriptionInput.clear(); 
    //     descriptionInput.sendKeys(newDescription);  
    // }
    
    public void editPost(String newDescription) {
        try {
            WebElement threeDots = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.threeDotsIcon));
            threeDots.click();
    
            WebElement editOption = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.editOptionInDropdown));
            editOption.click();
    
            WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(PostLocators.postInputDescription));
            descriptionInput.clear();
            descriptionInput.sendKeys(newDescription);
    
            WebElement postButton = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.postButton));
            postButton.click();
    
            try {
                Alert alert = driver.switchTo().alert();
                System.out.println("Alert text: " + alert.getText());
                alert.accept();  
            } catch (NoAlertPresentException e) {
            }
    
        } catch (TimeoutException e) {
            System.out.println("Timeout while waiting for elements in editPost method.");
            throw e;
        }
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

    // // Delete a post
    // public void deletePost() {
    //     WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.deleteButton));
    //     deleteButton.click();
    // }
    public void deletePost() {
        try {
            // Wait and click the 3 dots (menu) for post options
            WebElement threeDots = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.threeDotsIcon));
            threeDots.click();
            System.out.println("Clicked three dots."); // Debugging line
    
            // Wait and click the Delete option in the dropdown
            WebElement deleteOption = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.deleteOptionInDropdown));
            deleteOption.click();
            System.out.println("Clicked delete option."); // Debugging line
    
            // Wait and click the confirm delete button
            WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(PostLocators.deleteButton));
            deleteButton.click();
            System.out.println("Clicked delete button."); // Debugging line
    
            // Handle any alert that may appear after deleting the post
            try {
                Alert alert = driver.switchTo().alert();
                System.out.println("Alert text: " + alert.getText());
                alert.accept();  // Close the alert
            } catch (NoAlertPresentException e) {
                System.out.println("No alert present after deletion.");
            }
    
            // Wait for the post to disappear from the UI
            wait.until(ExpectedConditions.invisibilityOfElementLocated(PostLocators.postInputDescription));
            System.out.println("Post should be deleted now."); // Debugging line
    
        } catch (TimeoutException e) {
            System.out.println("Timeout while waiting for elements in deletePost method.");
            throw e;
        }
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
                    By.xpath("//div[contains(text(), '" + description + "')]"))); // Adjust XPath if needed
            System.out.println("Post found: " + description); // Debugging line
            return post;
        } catch (TimeoutException e) {
            System.out.println("Post not found: " + description); // Debugging line
            return null;
        }
    }
}
