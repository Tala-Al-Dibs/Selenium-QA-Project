package com.selenium_project;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

    public static Object[][] readExcel(String filePath) {
        Object[][] data = new Object[1][2]; // One row for the test data, two columns for name and age

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
            for (int i = 0; i < 2; i++) { // Loop through the first two rows
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell keyCell = row.getCell(0); // First column (key)
                    Cell valueCell = row.getCell(1); // Second column (value)
                    if (keyCell != null && valueCell != null) {
                        data[0][i] = valueCell.toString(); // Store value in the data array
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
