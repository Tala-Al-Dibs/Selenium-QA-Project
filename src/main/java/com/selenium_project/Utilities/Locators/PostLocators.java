package com.selenium_project.Utilities.Locators;

import org.openqa.selenium.By;

public class PostLocators {


     // Create Post
     public static final By postInputDescription = By.className("description-input");
     public static final By postDescription = By.className("post-content");

     public static final By postButton = By.className("submit-button"); 

     // Edit Post
     public static final By postContainer = By.className("post-container");
     public static final By threeDotsIcon = By.className("threedots");
     public static final By editButton = By.className("editbutton"); 

     public static final By submiteditButton = By.className("update-button"); 
     // public static final By editpostInputDescription = By.className("edit-textarea");
     
     public static final By editpostInputDescription = By.xpath("//textarea[contains(@class, 'edit-textarea')]");

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

     public static final By deleteButton = By.className("deletebutton"); 
}