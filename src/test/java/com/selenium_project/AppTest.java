package com.selenium_project;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.selenium_project.Utilities.CustomTestListener;
import com.selenium_project.Utilities.Excel.ExcelUtil;

import static org.testng.Assert.*;

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

     @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() {
        return ExcelUtil.readExcel("src/test/resources/Book1.xlsx"); // Update the path as needed
    }

    @Test(dataProvider = "excelData")
    public void testFromExcel(String name, String age) {
        Assert.assertEquals(name, "Tala", "The name is not correct.");
        // You can add further assertions if needed
    }
}
