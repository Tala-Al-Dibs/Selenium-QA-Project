package com.selenium_project.SignUpPage;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.selenium_project.Pages.LogInPage.SignInPage;
import com.selenium_project.Pages.MessagePage.MeassagePage;
import com.selenium_project.Pages.SignUpPage.SignUpPage;
import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;

public class ParallelSignUpTest {

    WebDriver driver;
    SignUpPage signUpPage;
    
    @Test
    public void chooseAFriend () throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        signUpPage = new SignUpPage(driver);
        
        driver.get(WebsiteTestingConfigurations.testUri); 

        signUpPage.clickCreateAccount();

        signUpPage.clickSignUpButton();

        assertTrue(signUpPage.allFieldsMessage());


        
        if (driver!=null)
        driver.quit(); 
        
    }
}
