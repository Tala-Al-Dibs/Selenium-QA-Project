package com.selenium_project.CommentPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium_project.BasePages.BaseCommentPage;
import com.selenium_project.Entities.User;

import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;
import com.selenium_project.Utilities.Excel.ExcelUtil;

public class CommentTest extends BaseCommentPage{
    
    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws IOException {
        ExcelUtil.loadUsersFromExcel(WebsiteTestingConfigurations.ExcelFilePath);
        List<User> users = ExcelUtil.getUsers();

        return new Object[][] { { users.get(0) } };
    }

    @Test(dataProvider = "excelData")
    public void enterComment (User user) {
        String comment = user.getComment();
        commentPage.inputComment(comment);
        assertEquals(commentPage.inputCommentText(), comment);
    }

    @Test(dataProvider = "excelData")
    public void sendComment(User user) {
        String comment = user.getComment();
        commentPage.inputComment(comment);
        commentPage.clickSendButton();
        String actualCommentText = commentPage.lastCommentText();  
        assertEquals(actualCommentText, comment);

    }    

}
