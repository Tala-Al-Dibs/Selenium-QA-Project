package com.selenium_project.BasePages;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.selenium_project.Pages.LogInPage.SignInPage;
import com.selenium_project.Pages.SignUpPage.SignUpPage;
import com.selenium_project.Utilities.Configurations.WebDriverFactory;

public class BaseSignUpPage extends BaseTest {

    protected static SignUpPage signUpPage;

    @BeforeMethod
    @Parameters("chrome")
    public void setUpSignIn (@Optional("chrome") String browser) throws IOException {
        super.setUp(browser);
        super.setUpp();
        signUpPage = new SignUpPage(driver);
    }

    @AfterMethod
    public void tearDownSignIn () {
        WebDriverFactory.quitDriver();
    }
    
}
