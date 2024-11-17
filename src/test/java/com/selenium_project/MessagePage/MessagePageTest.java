// package com.selenium_project.MessagePage;

// import static org.testng.Assert.assertEquals;
// import static org.testng.Assert.assertTrue;

// import java.io.IOException;
// import java.util.List;

// import org.testng.annotations.DataProvider;
// import org.testng.annotations.Test;

// import com.selenium_project.BasePages.BaseMessagePage;
// import com.selenium_project.Entities.User;
// import com.selenium_project.Utilities.Configurations.WebsiteTestingConfigurations;
// import com.selenium_project.Utilities.Excel.ExcelUtil;

// public class MessagePageTest extends BaseMessagePage {

//     @DataProvider(name = "excelDataMeassage")
//     public Object[][] excelDataProvider() throws IOException {
//         ExcelUtil.loadUsersFromExcel(WebsiteTestingConfigurations.ExcelFilePathSignUp);
//         List<User> users = ExcelUtil.getUsers();

//         return new Object[][] { { users.get(0) } };
//     }

//     @Test
//     public void chooseAFriend () throws IOException {
//         meassagePage.selectFirstFriend();
//         assertTrue(meassagePage.firstFrindIsSelected());
        
//     }

//     @Test(dataProvider = "excelDataMeassage")
//     public void sendAMessage (User user) throws IOException {
//         meassagePage.selectFirstFriend();
//         meassagePage.inputMessage(user.getMessage());
//         meassagePage.clickSendMessageButton();
//         assertEquals(user.getMessage(), meassagePage.getLastSentMessageContent());
        
//     }
// }
