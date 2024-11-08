package com.selenium_project.Pages.MainPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium_project.Utilities.Locators.MainPageLocators;

public class MainPage {
      private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to get current news title
    public String getNewsTitle() {
        WebElement newsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.newsTitle));
        return newsTitle.getText();
    }

    // Method to get current news image source
    public String getNewsImageSource() {
        WebElement newsImage = wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.newsImage));
        return newsImage.getAttribute("src");
    }

    // Method to refresh the page and load new news
    public void refreshNews() {
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.newsContainer));
    }
}
