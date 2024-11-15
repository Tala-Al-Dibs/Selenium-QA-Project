package com.selenium_project.MainPage;


import org.testng.annotations.Test;

import com.selenium_project.BasePages.BaseMainPage;
import com.selenium_project.Entities.User;
import com.selenium_project.Utilities.Excel.ExcelUtil;
import com.selenium_project.Utilities.Locators.MainPageLocators;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MainPageTest extends BaseMainPage {


    // Test to verify that the news title is visible and not empty
    @Test(priority = 1)
    public void testGetNewsTitle() {
        String newsTitle = mainpage.getNewsTitle();
        Assert.assertNotNull(newsTitle, "News title should not be null");
        Assert.assertFalse(newsTitle.isEmpty(), "News title should not be empty");
    }

    // Test to verify that the news image source is available
    @Test(priority = 2)
    public void testGetNewsImageSource() {
        String newsImageSource = mainpage.getNewsImageSource();
        Assert.assertNotNull(newsImageSource, "News image source should not be null");
        Assert.assertTrue(newsImageSource.startsWith("http"), "News image source should be a valid URL starting with http/https");
    }

    // Test to verify the refresh functionality loads new news
    @Test(priority = 3)
    public void testRefreshNews() {
        String initialNewsTitle = mainpage.getNewsTitle();
        mainpage.refreshNews();
        String refreshedNewsTitle = mainpage.getNewsTitle();

        Assert.assertNotNull(refreshedNewsTitle, "Refreshed news title should not be null");
        Assert.assertFalse(refreshedNewsTitle.isEmpty(), "Refreshed news title should not be empty");
        Assert.assertNotEquals(initialNewsTitle, refreshedNewsTitle, "News title should be different after refresh");
    }

    @Test
    public void testSearchByUsername() {
        // Get the list of users from the loaded Excel data
        List<User> users = ExcelUtil.getUsers();

        // For each user, perform search and verify they appear in the search results
        for (User user : users) {
            String username = user.getUsername();

            // Perform search by username
            mainpage.searchByUsername(username);

            // Verify that the user appears in the search results
            boolean isUserFound = mainpage.isUserInSearchResults(username);
            Assert.assertTrue(isUserFound);
        }
    }

    @Test
    public void testSearchResults() {
        // Perform search and get results
        mainpage.searchByUsername("jake");  // Replace with a valid test username

        // Get the search results
        List<WebElement> results = mainpage.getSearchResults();

        // Assert that search results are displayed
        Assert.assertFalse(results.isEmpty());
    }

    

   

}
