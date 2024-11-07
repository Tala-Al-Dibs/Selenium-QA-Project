package com.selenium_project.Utilities.Locators;

import org.openqa.selenium.By;

public class CommentLocators {
    
    public static By chatIcon = By.cssSelector("img.save[alt='Chat Icon']");
    public static By commentInput = By.cssSelector("input.commentInput.form-control");
    public static By sendButton = By.cssSelector("button.btn.btn-none > img[src=\"/images/paper-plane-top.png\"][alt=\"Send\"]");
    public static By sendButtonFace = By.cssSelector("button.btn.btn-none > img[src=\"/images/face.png\"][alt=\"Send\"]");
    public static By moreIcon = By.cssSelector("div.dropdown > img[src=\"/images/more.png\"][class=\"more\"]");
    public static By editInput = By.cssSelector("input[type=\"text\"][class=\"editInput\"]");
    public static By saveButton = By.cssSelector("button.editButton");
    public static By cancelButton = By.cssSelector("button.cancelButton");
    public static By likeButton = By.cssSelector("div.comment-like-button > img[src=\"/images/commentheartnot.png\"][alt=\"Like\"]");
    public static By replyButton = By.cssSelector("button.replyButton");
    public static By replyInput = By.cssSelector("input[type=\"text\"][class=\"replyInput\"]");
    public static By submitReplyButton = By.cssSelector("button.submitReplyButton > img[src=\"/images/paper-plane-top.png\"][alt=\"Send\"]");
}
