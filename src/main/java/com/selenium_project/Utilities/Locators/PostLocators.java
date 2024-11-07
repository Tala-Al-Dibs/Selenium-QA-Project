package com.selenium_project.Utilities.Locators;

import org.openqa.selenium.By;

public class PostLocators {


     // Create Post
     public static final By postInputDescription = By.id("post-input-description");
     public static final By postInputPrivacy = By.id("post-input-privacy");
     public static final By postButton = By.className("post-button");
 
     // Edit Post
     public static final By editButton = By.className("edit-button");
 
     // React to Post
     public static final By reactButton = By.className("react-button");
     public static final By likeReaction = By.id("like-reaction");
     public static final By loveReaction = By.id("love-reaction");
     public static final By hahaReaction = By.id("haha-reaction");
     public static final By wowReaction = By.id("wow-reaction");
     public static final By sadReaction = By.id("sad-reaction");
     public static final By angryReaction = By.id("angry-reaction");
 
     // Delete Post
     public static final By deleteButton = By.className("delete-button");
  
}
