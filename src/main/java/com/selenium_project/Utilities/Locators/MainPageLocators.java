package com.selenium_project.Utilities.Locators;

import org.openqa.selenium.By;

public class MainPageLocators {
    public static final By newsContainer = By.className("news-container"); 
    public static final By newsTitle = By.xpath("//div[@class='news-item']/p"); 
    public static final By newsImage = By.cssSelector(".news-item img"); 
}
