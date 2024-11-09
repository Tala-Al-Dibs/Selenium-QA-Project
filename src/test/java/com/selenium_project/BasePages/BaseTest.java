package com.selenium_project.BasePages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.selenium_project.Utilities.Configurations.WebDriverFactory;
import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;
public class BaseTest {
    
    protected WebDriver driver;


    @BeforeSuite
    public static void setUpp () {

    }
    @Parameters("browser")
    @BeforeMethod
    public void setUp (@Optional("chrome") String browser) throws IOException {

        driver = WebDriverFactory.createDriver(browser);       
        driver.get(WebsiteTestingConfigurations.testUri);
        driver.manage().window().maximize();
    }

 SignInTests
    @AfterSuite
    public static void tearDown () {
        WebDriverFactory.quitDriver();
    }

    
}
=======
    @AfterSuite
    public static void tearDown () {
        WebDriverFactory.quitDriver();
    }
    
}
 Post-Test
