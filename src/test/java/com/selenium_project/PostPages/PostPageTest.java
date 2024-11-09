package com.selenium_project.PostPages;

import org.openqa.selenium.WebElement;
import com.selenium_project.BasePages.BasePostPage;
import com.selenium_project.Utilities.Excel.ExcelUtil;
import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PostPageTest extends BasePostPage {

    @BeforeClass
    public void loadTestData() throws Exception {
        // Load data from the Excel file
        ExcelUtil.loadUsersFromExcel(WebsiteTestingConfigurations.ExcelFilePath);
    }

    @DataProvider(name = "postDescriptions")
    public Object[][] postDescriptions() {
        return ExcelUtil.getPosts()
            .stream()
            .map(desc -> new Object[]{desc})
            .toArray(Object[][]::new);
    }

    @Test(dataProvider = "postDescriptions")
    public void testCreatePost(String description) {
        postpage.createPost(description, "Public");

        // Verify post creation
        Assert.assertNotNull(postpage.findPostByDescription(description),
                "Post with description '" + description + "' was not created.");
    }

    @Test
    public void testEditPost() {
        String initialDescription = "Initial description";
        String newDescription = "Updated post description";

        postpage.createPost(initialDescription, "Public");
        WebElement post = postpage.findPostByDescription(initialDescription);
        Assert.assertNotNull(post, "Original post not found.");

        postpage.editPost(newDescription);

        // Verify that the post is updated
        WebElement updatedPost = postpage.findPostByDescription(newDescription);
        Assert.assertNotNull(updatedPost, "Post description was not updated.");
    }

    @Test
    public void testReactToPost() {
        String description = "Post for reaction";
        postpage.createPost(description, "Public");

        WebElement post = postpage.findPostByDescription(description);
        Assert.assertNotNull(post, "Post to react to not found.");

        String reactionType = "LIKE";
        postpage.reactToPost(reactionType);

        // Optional: Add assertions to verify reaction is applied, if applicable.
    }

    // @Test
    // public void testDeletePost() {
    //     String description = "Post to delete";
    //     postpage.createPost(description, "Public");

    //     WebElement post = postpage.findPostByDescription(description);
    //     Assert.assertNotNull(post, "Post to delete not found.");

    //     postpage.deletePost();

    //     // Verify post deletion
    //     WebElement deletedPost = postpage.findPostByDescription(description);
    //     Assert.assertNull(deletedPost, "Post was not deleted.");
    // }
    @Test
    public void testDeletePost() {
        String description = "Post to delete";
        
        // Create the post
        postpage.createPost(description, "Public");
    
        // Find the post and ensure it exists before attempting to delete it
        WebElement post = postpage.findPostByDescription(description);
        Assert.assertNotNull(post, "Post to delete not found before deletion.");
    
        // Perform the delete operation
        postpage.deletePost();
    
        // Wait for the post to disappear (this is where it was failing)
        try {
            WebElement deletedPost = postpage.findPostByDescription(description);
            Assert.assertNull(deletedPost, "Post was not deleted.");
        } catch (Exception e) {
            System.out.println("Error when verifying post deletion: " + e.getMessage());
            Assert.fail("Error occurred when checking if the post was deleted.");
        }
    }
    
}    