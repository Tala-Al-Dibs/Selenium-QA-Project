package com.selenium_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


import com.selenium_project.Pages.LogInPage.SignInPage;
import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;

public class CrossBrowserTest {

    private WebDriver driver;
    private SignInPage signInPage;

    @Test
    public void benterPasswordToSignInPageChrome() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(WebsiteTestingConfigurations.testUri);
        signInPage = new SignInPage(driver);
        signInPage.inputPassword("password");
        assertEquals(signInPage.inputPassweordText(), "password");
        if (driver!=null)
        driver.quit(); 
    }

    @Test
    public void benterPasswordToSignInPageFireFox() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(WebsiteTestingConfigurations.testUri);
        signInPage = new SignInPage(driver);
        signInPage.inputPassword("password");
        assertEquals(signInPage.inputPassweordText(), "password");
        if (driver!=null)
        driver.quit(); 
    }

    @Test
    public void benterPasswordToSignInPageEdge() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(WebsiteTestingConfigurations.testUri);
        signInPage = new SignInPage(driver);
        signInPage.inputPassword("password");
        assertEquals(signInPage.inputPassweordText(), "password");
        if (driver!=null)
        driver.quit(); 
    }
}
