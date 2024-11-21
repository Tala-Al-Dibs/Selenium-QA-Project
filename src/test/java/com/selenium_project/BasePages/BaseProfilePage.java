package com.selenium_project.BasePages;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.selenium_project.Entities.User;
import com.selenium_project.Pages.LogInPage.SignInPage;
import com.selenium_project.Pages.ProfilePage.ProfilePage;
import com.selenium_project.Utilities.Configurations.WebDriverFactory;
import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;
import com.selenium_project.Utilities.Excel.ExcelUtil;

public class BaseProfilePage extends BaseTest {

    protected static ProfilePage profilePage;
    protected static  SignInPage signInPage;

    @BeforeMethod
    @Parameters("chrome")
    @DataProvider(name = "excelDataSetUp")
    public void setUpMessage(@Optional("chrome") String browser) throws IOException {
        ExcelUtil.loadUsersFromExcel(WebsiteTestingConfigurations.ExcelFilePathSignUp);
        List<User> users = ExcelUtil.getUsers();

        User user =  users.get(0);
        super.setUp(browser); 
        
        signInPage = new SignInPage(getDriver());
        signInPage.inputUsername(user.getUsername());
        signInPage.inputPassword(user.getPassword());
        signInPage.clickSignInButton();

        profilePage = new ProfilePage(getDriver());

        profilePage.clickProfilePictureImg();
    }
    

    @AfterMethod
    public void tearDownComments() {
        WebDriverFactory.quitDriver();
    }
}
