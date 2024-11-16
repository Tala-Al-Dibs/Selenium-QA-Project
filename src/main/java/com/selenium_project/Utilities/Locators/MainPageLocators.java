package com.selenium_project.Utilities.Locators;

import org.openqa.selenium.By;

public class MainPageLocators {
    //News locaters
    public static final By newsContainer = By.className("news-container"); 
    public static final By newsTitle = By.xpath("//div[@class='news-item']/p"); 
    public static final By newsImage = By.cssSelector(".news-item img"); 

    //search by username locators
    // public static final By searchInput = By.cssSelector(".search-input");  
    // public static final By searchResultsContainer = By.cssSelector(".search-results"); 
    // public static final By searchResultItem = By.cssSelector(".search-result-item");  
    // public static final By searchResultInfo = By.cssSelector(".search-result-info"); 
    // public static final By searchInput = By.id("search-username");  // Assuming the search input has the ID "search-username"
    // public static final By searchButton = By.id("search-button");  

    // public static final By searchResultItems = By.cssSelector(".result-item");

    // Locator for the usernames within each search result item
    // public static final By searchResultUsernames = By.cssSelector(".result-item .username");
    public static final By searchInput = By.className("search-input");
    public static final By searchResultItems = By.cssSelector(".search-result-item");
    public static final By searchResultUsernames = By.cssSelector(".search-result-item .search-first-last-name p:nth-child(2)"); // For checking the username
}