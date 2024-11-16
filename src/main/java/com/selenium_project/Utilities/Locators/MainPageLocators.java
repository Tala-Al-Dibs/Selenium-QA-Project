package com.selenium_project.Utilities.Locators;

import org.openqa.selenium.By;

public class MainPageLocators {
    //News locaters
    public static final By newsContainer = By.className("news-container"); 
    public static final By newsTitle = By.xpath("//div[@class='news-item']/p"); 
    public static final By newsImage = By.cssSelector(".news-item img"); 

    public static final By searchInput = By.className("search-input");
    public static final By searchResultItems = By.cssSelector(".search-result-item");

    public static final By searchResultUsernames = By.cssSelector(".search-result-item .search-first-last-name p:nth-child(2)");
    public static final By firstSearchResult = By.cssSelector(".search-first-last-name > p:nth-child(1)");
}

