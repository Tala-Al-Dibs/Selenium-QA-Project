package com.selenium_project.BasePages;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.selenium_project.Pages.LogInPage.SignInPage;
import com.selenium_project.Utilities.Configurations.WebDriverFactory;

public class BaseSignInPage extends BaseTest {

    protected static SignInPage signInPage;

    @BeforeMethod
    @Parameters("chrome")
    public void setUpSignIn (@Optional("chrome") String browser) throws IOException {
        super.setUp(browser);
        super.setUpp();
        signInPage = new SignInPage(driver);
    }

    @AfterMethod
    public void tearDownSignIn () {
        WebDriverFactory.quitDriver();
    }
    
    
}
