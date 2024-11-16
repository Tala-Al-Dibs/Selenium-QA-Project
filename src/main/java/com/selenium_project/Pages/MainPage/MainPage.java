package com.selenium_project.Pages.MainPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium_project.Entities.User;
import com.selenium_project.Utilities.Excel.ExcelUtil;
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
  

    // public void searchByUsername(String username) {
    //     WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.searchInput));
    //     WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(MainPageLocators.searchButton));

    //     searchInput.clear();  // Clear any previous input
    //     searchInput.sendKeys(username);  // Enter the username to search
    //     searchButton.click();  // Click the search button
    // }

    // //    Method to perform search by username
    // public void searchByUsername(String username) {
    //     WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.searchInput));
    //     searchInput.clear();  // Clear any previous input
    //     searchInput.sendKeys(username);
    // }
 // Method to perform search by username
 public void searchByUsername(String username) {
    WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.searchInput));
    WebElement searchResultitems = wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.searchResultItems));

    searchInput.clear();  // Clear any previous input
    searchInput.sendKeys(username);  // Enter the username to search
    searchResultitems.click();  // Click the search button
}
    // Method to get the list of search results
    public List<WebElement> getSearchResults() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MainPageLocators.searchResultItems));
    }

    // Method to verify that the search result contains the expected username
    public boolean isUserInSearchResults(String username) {
        List<WebElement> searchResultUsernames = driver.findElements(MainPageLocators.searchResultUsernames);
        for (WebElement element : searchResultUsernames) {
            if (element.getText().equals(username)) {
                return true;  // Username is found in search results
            }
        }
        return false;  // Username not found
    }

    // Method to search and verify user from Excel data
    public boolean searchUserFromExcel() {
        List<User> users = ExcelUtil.getUsers();
        for (User user : users) {
            searchByUsername(user.getUsername());  // Perform search by username from Excel
            if (!isUserInSearchResults(user.getUsername())) {
                return false;  // User is not found in search results
            }
        }
        return true;  // All users were found in search results
    }





    // public void searchByUsername(String username) {
    //     WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.searchInput));
    //     searchInput.clear();
    //     searchInput.sendKeys(username);
    // }
    // // Method to get list of usernames from the search results
    // public List<String> getSearchResultUsernames() {
    //     wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MainPageLocators.searchResultItems));
    //     List<WebElement> usernameElements = driver.findElements(MainPageLocators.searchResultUsernames);
    //     return usernameElements.stream().map(WebElement::getText).collect(Collectors.toList());
    // }

    // // Method to check if specific username appears in search results
    // public boolean isUsernameInSearchResults(String username) {
    //     List<String> usernames = getSearchResultUsernames();
    //     return usernames.contains(username);
    // }
   
}