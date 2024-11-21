package com.selenium_project.signInPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium_project.BasePages.BaseSignInPage;
import com.selenium_project.Entities.User;
import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;
import com.selenium_project.Utilities.Excel.ExcelUtil;

public class signInTest extends BaseSignInPage {

    @DataProvider(name = "excelData", parallel = true)
    public Object[][] excelDataProvider() throws IOException {
        ExcelUtil.loadUsersFromExcel(WebsiteTestingConfigurations.ExcelFilePath);
        List<User> users = ExcelUtil.getUsers();
        for (User user : users) {
            if (user.getUsername() == null || user.getPassword() == null) {
                throw new IllegalArgumentException("User data cannot be null: " + user);
            }
        }
        

        return new Object[][] { { users.get(0) } };
    }

    @Test(dataProvider = "excelData")
    public void aenterUserNameToSignInPage(User user) {
        String username = user.getUsername();
        signInPage.inputUsername(username);
        assertEquals(signInPage.inputUsernameText(), username,
                "The username entered should match the username provided.");
    }

    @Test(dataProvider = "excelData")
    public void benterPasswordToSignInPage(User user) {
        String password = user.getPassword();
        signInPage.inputPassword(password);
        assertEquals(signInPage.inputPassweordText(), password);
    }

    @Test(dataProvider = "excelData")
    public void centervaluesSignIn(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        signInPage.inputUsername(username);
        signInPage.inputPassword(password);
        signInPage.clickSignInButton();
        assertTrue(signInPage.getHelloUsername());
    }

}
