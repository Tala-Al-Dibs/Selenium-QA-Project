package com.selenium_project;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.selenium_project.Entities.User;
import com.selenium_project.Utilities.CustomTestListener;
import com.selenium_project.Utilities.Excel.ExcelUtil;

import static org.testng.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

/**
 * Unit test for simple App.
 */

@Listeners(CustomTestListener.class)
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void isFlase () {
        assertFalse(false);
    }

    @Test
    public void s () {
        assertEquals("please", "please");
    }

    // @DataProvider(name = "excelData")
    // public Object[][] readExcelData() throws IOException {
    //     FileInputStream file = new FileInputStream("src/main/java/com/selenium_project/resources/UsersInfoExcel.xlsx");
    //     Workbook workbook = new XSSFWorkbook(file);
    //     Sheet sheet = workbook.getSheetAt(0);

    //     Object[][] data = new Object[sheet.getPhysicalNumberOfRows() - 1][1];

    //     for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) { // skip header row
    //         Row row = sheet.getRow(i);
    //         data[i - 1][0] = row.getCell(0).getStringCellValue(); // Assuming username is in the first column
    //     }

    //     workbook.close();
    //     return data;
    // }

    // @Test(dataProvider = "excelData")
    // public void testFromExcel1(String username) {
    //     if ("john_doe123".equals(username)) {
    //         Assert.assertEquals(username, "john_doe123", "First username should be 'john_doe123'");
    //     } else if ("new_user".equals(username)) {
    //         Assert.assertNotEquals(username, "Talatt", "Second username should not be 'Talatt'");
    //     }
    // }

    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws IOException {
        // Load users from the Excel file
        ExcelUtil.loadUsersFromExcel("src/main/java/com/selenium_project/resources/UsersInfoExcel.xlsx");

        List<User> users = ExcelUtil.getUsers();
        Object[][] data = new Object[users.size()][1];

        // Populate data array with User objects
        for (int i = 0; i < users.size(); i++) {
            data[i][0] = users.get(i);
        }

        return data;
    }

    @Test(dataProvider = "excelData")
    public void testFromExcel(User user) {
        String username = user.getUsername(); 

        if ("john_doe123".equals(username)) {
            Assert.assertEquals(username, "john_doe123", "First username should be 'john_doe123'");
        } else if ("new_user".equals(username)) {
            Assert.assertNotEquals(username, "Talatt", "Second username should not be 'Talatt'");
        }

        
    }



}
