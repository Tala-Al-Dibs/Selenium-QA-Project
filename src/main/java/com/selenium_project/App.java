package com.selenium_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// import java.io.IOException;
// import java.util.*;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;

// import com.selenium_project.Entities.User;
// import com.selenium_project.Utilities.Excel.ExcelUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Thread chromeThread = new Thread(() -> runTest("chrome"));
        Thread firefoxThread = new Thread(() -> runTest("firefox"));
        Thread edgeThread = new Thread(() -> runTest("edge"));

        // Start all threads
        chromeThread.start();
        firefoxThread.start();
        edgeThread.start();
    }

    public static void runTest(String browser) {
        WebDriver driver = null;
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }

            // Perform test actions
            driver.manage().window().maximize();
            driver.get("http://localhost:3000/profile/7");
            System.out.println("Browser: " + browser + " - Page title is: " + driver.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    

        // WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();
        // driver.get("http://localhost:3000/");

        // WebElement i = driver.findElement(By.cssSelector(".signin-input[name=\"username\"]"));
        // i.sendKeys("hh");
        // System.out.println(i.getText());
        // System.out.println( "Hello World!" );
        //     try {
        //         ExcelUtil.loadUsersFromExcel("src/main/java/com/selenium_project/resources/UsersInfoExcel.xlsx");
    
        //         List<User> allUsers = ExcelUtil.getUsers();
        //         System.out.println("All Users: " + allUsers);
    
        //         User user = ExcelUtil.findUserByUsername("john_doe123");
        //         if (user != null) {
        //             System.out.println("Found User: " + user);
        //         } else {
        //             System.out.println("User not found.");
        //         }
    
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
    }
}
