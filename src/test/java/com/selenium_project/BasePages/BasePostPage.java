package com.selenium_project.BasePages;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.selenium_project.Pages.PostPage.PostPage;
import com.selenium_project.Utilities.Configurations.WebDriverFactory;



public class BasePostPage extends BaseTest{
        protected static PostPage postpage;

       @BeforeMethod
    @Parameters("chrome")
    public void setUpPost (@Optional("chrome") String browser) throws IOException {
        super.setUp(browser);
        super.setUpp();
        postpage = new PostPage(driver);
    }

    // @AfterMethod
    // public void tearDownPost() {
    //     WebDriverFactory.quitDriver();
    // }
}
