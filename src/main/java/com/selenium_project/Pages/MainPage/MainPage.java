package com.selenium_project.Pages.MainPage;

import java.time.Duration;
import java.util.List;

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

    public String getNewsTitle() {
        WebElement newsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.newsTitle));
        return newsTitle.getText();
    }

    public String getNewsImageSource() {
        WebElement newsImage = wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.newsImage));
        return newsImage.getAttribute("src");
    }

    public void refreshNews() {
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.newsContainer));
    }

    public void searchByUsername(String username) {
        WebElement searchInput = wait
                .until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.searchInput));

        searchInput.clear();
        searchInput.sendKeys(username);
    }

    private List<WebElement> getResultItems(String username) {
        List<WebElement> searchResults = wait
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MainPageLocators.searchResultItems));
        return searchResults;
    }

    public Boolean getSearchResultText(String username) {
        // WebElement firstSearchResult = wait
        //         .until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.firstSearchResult));
        List<WebElement> searchResults = getResultItems(username);
        for (int i = 0; i < searchResults.size(); i++) {
            if (searchResults.get(i).getText().trim().contains("John Doe")) {
                return true;
            }
        }
        return false;
    }

    public boolean isUserInSearchResults(String username) {
        List<WebElement> searchResultUsernames = driver.findElements(MainPageLocators.searchResultUsernames);
        for (WebElement element : searchResultUsernames) {
            if (element.getText().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchUserFromExcel() {
        List<User> users = ExcelUtil.getUsers();
        for (User user : users) {
            searchByUsername(user.getUsername());
            if (!isUserInSearchResults(user.getUsername())) {
                return false;
            }
        }
        return true;
    }

}

