package com.selenium_project.BasePages;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.selenium_project.Entities.User;
import com.selenium_project.Pages.CommentPage.CommentPage;
import com.selenium_project.Pages.LogInPage.SignInPage;
import com.selenium_project.Utilities.Configurations.WebDriverFactory;
import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;
import com.selenium_project.Utilities.Excel.ExcelUtil;

public class BaseCommentPage extends BaseTest {

    protected static CommentPage commentPage;
    protected static  SignInPage signInPage;

    @BeforeMethod
    @Parameters("chrome")
    @DataProvider(name = "excelDataSetUp")
    public void setUpMessage(@Optional("chrome") String browser) throws IOException {
        ExcelUtil.loadUsersFromExcel(WebsiteTestingConfigurations.ExcelFilePathSignUp);
        List<User> users = ExcelUtil.getUsers();

        User user =  users.get(0);
        super.setUp(browser); 
        super.setUpp();
        
        signInPage = new SignInPage(driver);
        signInPage.inputUsername(user.getUsername());
        signInPage.inputPassword(user.getPassword());
        signInPage.clickSignInButton();

        commentPage = new CommentPage(driver);

        commentPage.clickCommentsIcon();
    }
    

    @AfterMethod
    public void tearDownComments() {
        WebDriverFactory.quitDriver();
    }
}
