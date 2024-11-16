package com.selenium_project.MainPage;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium_project.BasePages.BaseMainPage;
import com.selenium_project.Entities.User;
import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;
import com.selenium_project.Utilities.Excel.ExcelUtil;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;

public class MainPageTest extends BaseMainPage {

    @DataProvider(name = "excelDataSearch")
    public Object[][] excelDataProvider() throws IOException {
        ExcelUtil.loadUsersFromExcel(WebsiteTestingConfigurations.ExcelFilePathSignUp);
        List<User> users = ExcelUtil.getUsers();

        return new Object[][] { { users.get(0) } };
    }


    @Test
    public void testGetNewsTitle() {
        String newsTitle = mainpage.getNewsTitle();
        assertNotNull(newsTitle, "News title should not be null");
        assertFalse(newsTitle.isEmpty(), "News title should not be empty");
    }

    @Test
    public void testGetNewsImageSource() {
        String newsImageSource = mainpage.getNewsImageSource();
        Assert.assertNotNull(newsImageSource, "News image source should not be null");
        Assert.assertTrue(newsImageSource.startsWith("http"), "News image source should be a valid URL starting with http/https");
    }

    @Test
    public void testRefreshNews() {
        String initialNewsTitle = mainpage.getNewsTitle();
        mainpage.refreshNews();
        String refreshedNewsTitle = mainpage.getNewsTitle();
        assertTrue((initialNewsTitle!=refreshedNewsTitle)||(initialNewsTitle==refreshedNewsTitle));
    }

    @Test(dataProvider = "excelDataSearch")
    public void testSearchByUsername(User user) {
        mainpage.searchByUsername(user.getHomeSearch());
        assertTrue(mainpage.getSearchResultText(user.getHomeSearch()));
    }

}
