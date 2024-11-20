package com.selenium_project.MessagePage;

import java.io.IOException;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium_project.BasePages.BaseMessagePage;
import com.selenium_project.Entities.User;
import com.selenium_project.Pages.LogInPage.SignInPage;
import com.selenium_project.Pages.MessagePage.MeassagePage;
import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;

public class ParallelMessageTest  {
    WebDriver driver;
    MeassagePage meassagePage;
    SignInPage signInPage;

   
    @Test
    public void chooseAFriend () throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get(WebsiteTestingConfigurations.testUri); 
        signInPage = new SignInPage(driver);
        signInPage.inputUsername("john_doe123");
        signInPage.inputPassword("password");
        signInPage.clickSignInButton();

        meassagePage = new MeassagePage(driver);

        meassagePage.clickMessageIcon();
        meassagePage.selectFirstFriend();
        assertTrue(meassagePage.firstFrindIsSelected());

        if (driver!=null)
        driver.quit(); 
        
    }

    // @Test
    // public void sendAMessage () throws IOException {
    //     driver = new ChromeDriver();
    //     driver.manage().window().maximize();
        
    //     driver.get(WebsiteTestingConfigurations.testUri); 
    //     signInPage = new SignInPage(driver);
    //     signInPage.inputUsername("john_doe123");
    //     signInPage.inputPassword("password");
    //     signInPage.clickSignInButton();

    //     meassagePage = new MeassagePage(driver);

    //     meassagePage.clickMessageIcon();
    //     meassagePage.selectFirstFriend();
    //     String message = "hello! how are you doing?";
    //     meassagePage.inputMessage(message);
    //     meassagePage.clickSendMessageButton();
    //     assertEquals(message, meassagePage.getLastSentMessageContent());

    //     if (driver!=null)
    //     driver.quit();
        
    // }

    
}
