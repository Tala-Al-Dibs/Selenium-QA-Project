package com.selenium_project.BasePages;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.selenium_project.Entities.User;
import com.selenium_project.Pages.LogInPage.SignInPage;
import com.selenium_project.Pages.PostPage.PostPage;
import com.selenium_project.Utilities.Configurations.WebDriverFactory;
import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;
import com.selenium_project.Utilities.Excel.ExcelUtil;



public class BasePostPage extends BaseTest{
    protected static PostPage postpage;
    protected static SignInPage signInPage;

    @BeforeMethod
    @Parameters("chrome")
    public void setUpPostPage(@Optional("chrome") String browser) throws IOException {
        // Load users and login data from Excel
        ExcelUtil.loadUsersFromExcel(WebsiteTestingConfigurations.ExcelFilePathSignUp);
        List<User> users = ExcelUtil.getUsers();

        // Set up the WebDriver and log in
        User user = users.get(0);
        super.setUp(browser); 
        super.setUpp();

        signInPage = new SignInPage(driver);
        signInPage.inputUsername(user.getUsername());
        signInPage.inputPassword(user.getPassword());
        signInPage.clickSignInButton();

        postpage = new PostPage(driver);
    }

    @DataProvider(name = "postDescriptions")
    public Object[][] postDescriptionsProvider() throws IOException {
        ExcelUtil.loadPostsFromExcel(WebsiteTestingConfigurations.ExcelFilePath);  
        List<String> postDescriptions = ExcelUtil.getPosts(); 

        Object[][] data = new Object[postDescriptions.size()][1];
        for (int i = 0; i < postDescriptions.size(); i++) {
            data[i][0] = postDescriptions.get(i);
        }
        return data;
    
}


    // @AfterMethod
    // public void tearDownPostPage() {
    //     WebDriverFactory.quitDriver();
    // }
}
