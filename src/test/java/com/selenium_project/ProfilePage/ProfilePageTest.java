package com.selenium_project.ProfilePage;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium_project.BasePages.BaseProfilePage;
import com.selenium_project.Entities.User;
import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;
import com.selenium_project.Utilities.Excel.ExcelUtil;

public class ProfilePageTest extends BaseProfilePage {
    

    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws IOException {
        ExcelUtil.loadUsersFromExcel(WebsiteTestingConfigurations.ExcelFilePath);
        List<User> users = ExcelUtil.getUsers();

        return new Object[][] { { users.get(0) } };
    }

    @Test(dataProvider = "excelData")
    public void verifyEditBio (User user) {
        profilePage.clickEditButton();
        String bio = user.getEditedBio();
        profilePage.inputBio(bio);
        assertEquals(profilePage.inputBioText(), bio);
    }

      @Test(dataProvider = "excelData")
    public void hidePhoneNumberTest(User user) {
        profilePage.clickEditButton();
        
        profilePage.clickHidePhoneNumberButton();
        
        profilePage.clickSaveButton();
        
        assertFalse(profilePage.isPhoneNumberVisible());

    }

}
