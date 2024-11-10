package com.selenium_project.SignUpPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
        ExcelUtil.loadUsersFromExcel(WebsiteTestingConfigurations.ExcelFilePathSignUp);
        List<User> users = ExcelUtil.getUsers();

        return new Object[][] { { users.get(1) } };
    }

    @Test(dataProvider = "excelData")
    public void aenterUserNameToSignUpPage(User user) {
        signUpPage.clickCreateAccount();
        String username = user.getUsername();
        signUpPage.inputUsername(username);
        assertEquals(signUpPage.getInputUsernameText(), username);
    }

    @Test(dataProvider = "excelData")
    public void benterPasswordToSignUpPage(User user) {
        signUpPage.clickCreateAccount();
        signUpPage.inputUsername(user.getUsername());
        signUpPage.inputEmail(user.getEmail());
        signUpPage.inputPassword(user.getPassword());
        signUpPage.inputFirstName(user.getFirstName());
        signUpPage.inputLastName(user.getLastName());
        signUpPage.selectGenderFemale();
        signUpPage.inputDateOfBirth(user.getDateOfBirth());
        signUpPage.inputLocation(user.getLocation());
        signUpPage.inputPhoneNumber(user.getPhoneNumber());
        signUpPage.clickSignUpButton();

        assertTrue(signUpPage.getHelloUsername());
    }
    
}
