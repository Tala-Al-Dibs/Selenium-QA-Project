package com.selenium_project.BasePages;

import org.openqa.selenium.WebDriver;

import com.selenium_project.Utilities.Configurations.WebDriverFactory;
import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected WebDriver getDriver() {
        return driver.get();
    }

    protected void setUp(String browser) {
        driver.set(WebDriverFactory.createDriver(browser));
        getDriver().manage().window().maximize();
        
        getDriver().get(WebsiteTestingConfigurations.testUri); // Replace with your application's URL
    }


    protected void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

