package com.selenium_project.SignUpPage;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium_project.BasePages.BaseSignUpPage;
import com.selenium_project.Entities.User;
import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;
import com.selenium_project.Utilities.Excel.ExcelUtil;

public class SignUpPageTest extends BaseSignUpPage {

    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws IOException {
        ExcelUtil.loadUsersFromExcel(WebsiteTestingConfigurations.ExcelFilePath);
        List<User> users = ExcelUtil.getUsers();

        return new Object[][] { { users.get(0) } };
    }

    // @Test(dataProvider = "excelData")
    // public void aenterUserNameToSignUpPage(User user) {
    //     signUpPage.clickCreateAccount();
    //     String username = user.getUsername();
    //     signUpPage.inputUsername(username);
    //     assertEquals(signUpPage.getInputUsernameText(), username,
    //             "The username entered should match the username provided.");
    // }
    
}
