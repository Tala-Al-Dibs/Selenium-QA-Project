package com.selenium_project.BasePages;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import com.selenium_project.Entities.User;
import com.selenium_project.Pages.LogInPage.SignInPage;
import com.selenium_project.Pages.MainPage.MainPage;
import com.selenium_project.Utilities.Configurations.WebDriverFactory;
import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;
import com.selenium_project.Utilities.Excel.ExcelUtil;

public class BaseMainPage extends BaseTest {
    protected static MainPage mainpage;
    protected static SignInPage signInPage;
    public List<User> users;

    @BeforeMethod
    @Parameters("chrome")
    public void setUpPostPage(@Optional("chrome") String browser) throws IOException {
        super.setUp(browser);

        ExcelUtil.loadUsersFromExcel(WebsiteTestingConfigurations.ExcelFilePathSignUp);
        List<User> users = ExcelUtil.getUsers();

        User user = users.get(0);
        signInPage = new SignInPage(getDriver());
        signInPage.inputUsername(user.getUsername());
        signInPage.inputPassword(user.getPassword());
        signInPage.clickSignInButton();

        mainpage = new MainPage(getDriver());
    }

    @AfterMethod
    public void tearDownPostPage() {
        WebDriverFactory.quitDriver();
    }
}
