package com.selenium_project.PostPages;

import static org.testng.Assert.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium_project.BasePages.BasePostPage;
import com.selenium_project.Utilities.Excel.ExcelUtil;
import com.selenium_project.Utilities.Locators.PostLocators;
import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PostPageTest extends BasePostPage {

    @DataProvider(name = "postDescriptions")
    public Object[][] postDescriptionsProvider() throws IOException {
        ExcelUtil.loadPostsFromExcel(WebsiteTestingConfigurations.ExcelFilePath);  
        List<String> postDescriptions = ExcelUtil.getPosts(); 

        Object[][] data = new Object[postDescriptions.size()][1];
        for (int i = 0; i < postDescriptions.size(); i++) {
            data[i][0] = postDescriptions.get(i);
        }
        return data;
    }

    @Test(dataProvider = "postDescriptions")
    public void testCreatePost(String description) throws IOException, InterruptedException {
        postpage.createPost(description);
        postpage.acceptAlert();
        assertTrue(postpage.isPostDisplayedByDescription(description), "Post creation failed: Post not found.");
    }

    
//     @Test(dataProvider = "postDescriptions")
// public void testCreateAndEditPost(String postDescription) throws InterruptedException {
//     postpage.createPost(postDescription);
//     postpage.acceptAlert();
    
//     String newDescription = "Updated: " + postDescription; 
//     postpage.editPost(newDescription);
    
//     // Assert the edited post description matches
//     assertEquals(postpage.getEditedPostDescription(), newDescription);
// }

    

    
//     @Test(dataProvider = "postDescriptions")
//     public void testDeletePost(String description) throws InterruptedException {
//         postpage.createPost(description);
//         postpage.acceptAlert();
//         String descriptionBeforeDelete = postpage.getCurrentPostDescription();
        
//         postpage.deletePost();
        
//         Assert.assertTrue(postpage.isPostDeleted(descriptionBeforeDelete), "Post deletion failed: Post still exists.");
//     }
    

    @Test(dataProvider = "postDescriptions")
    public void testReactToPost(String description) throws InterruptedException {
        postpage.createPost(description);
        postpage.acceptAlert();
        
        postpage.reactToPost("LOVE");
        
        Assert.assertTrue(postpage.isPostDisplayedByDescription(description), "Post creation failed: Post not found.");
    }
}
