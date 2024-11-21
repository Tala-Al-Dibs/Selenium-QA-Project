package com.selenium_project.BasePages;

import java.io.IOException;

import org.testng.annotations.*;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.selenium_project.Pages.LogInPage.SignInPage;

public class BaseSignInPage extends BaseTest {

    protected SignInPage signInPage;

    @BeforeMethod
    @Parameters("chrome")
    public void setUpSignIn(@Optional("chrome") String browser) throws IOException {
        super.setUp(browser);
        signInPage = new SignInPage(getDriver());
    }

    @AfterMethod
    public void tearDownSignIn() {
        super.tearDown();
    }
}

