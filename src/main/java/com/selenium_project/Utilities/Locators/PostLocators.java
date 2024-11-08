package com.selenium_project.Utilities.Locators;

import org.openqa.selenium.By;

public class PostLocators {


     // Create Post
     public static final By postInputDescription = By.className("description-input");
     public static final By postInputPrivacyDropdown = By.className("custom-dropdown-selected");
     public static final By publicOption = By.xpath("//li[text()='Public']");
     public static final By privateOption = By.xpath("//li[text()='Private']");
     public static final By postButton = By.cssSelector(".postPlaceButtons button"); 

     // Edit Post
     public static final By postContainer = By.className("post-container");
     public static final By threeDotsIcon = By.className("threedots");
     public static final By editOptionInDropdown = By.xpath("//div[@class='dropdownMenu']//img[@alt='edit']"); 

     // React to Post
     public static final By reactButton = By.className("react-container");
     public static final By likeReaction = By.xpath("//img[@alt='LIKE']");
     public static final By loveReaction = By.xpath("//img[@alt='LOVE']");
     public static final By hahaReaction = By.xpath("//img[@alt='HAHA']");
     public static final By wowReaction = By.xpath("//img[@alt='WOW']");
     public static final By sadReaction = By.xpath("//img[@alt='SAD']");
     public static final By angryReaction = By.xpath("//img[@alt='ANGRY']");
 
     // Delete Post
     public static final By deleteOptionInDropdown = By.xpath("//button[contains(@class, 'deletebutton')]");

     public static final By deleteButton = By.xpath("//button[contains(@class, 'deletebutton')]"); 
}
