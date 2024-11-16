package com.selenium_project.Utilities.Excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.selenium_project.Entities.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelUtil {

     private static List<User> users = new ArrayList<>();
     private static List<String> posts = new ArrayList<>();
     private static List<String> searchQueries = new ArrayList<>();

    public static void loadUsersFromExcel(String filePath) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        users.clear();

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            User user = new User(
                getCellValue(row.getCell(0)), // username
                getCellValue(row.getCell(1)), // password
                getCellValue(row.getCell(2)), // email
                getCellValue(row.getCell(3)), // firstName
                getCellValue(row.getCell(4)), // lastName
                getCellValue(row.getCell(5)), // gender
                getCellValue(row.getCell(6)), // dateOfBirth
                getCellValue(row.getCell(7)), // location
                getCellValue(row.getCell(8)), // phoneNumber
                getCellValue(row.getCell(9)), // bio
                getCellValue(row.getCell(10)), // post
                getCellValue(row.getCell(11)), // comment
                getCellValue(row.getCell(12)), // reply
                getCellValue(row.getCell(13)), // editedBio
                getCellValue(row.getCell(14)), // message
                getCellValue(row.getCell(15)), // homeSearch
                getCellValue(row.getCell(16)) // bookmarkSearch
            );
            users.add(user);

        }

        workbook.close();
        file.close();
    }
    public static List<String> getSearchQueries() {
        return searchQueries;
    }
    public static List<User> getUsers() {
        return users;
    }
    public static List<String> getPosts() {
        return posts;
    }
  
    public static User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    // Helper method to get the cell value as a String
    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }
    public static void loadPostsFromExcel(String filePath) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        posts.clear(); 

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            String postDescription = getCellValue(row.getCell(10)); 
            if (!postDescription.isEmpty()) {
                posts.add(postDescription);  
            }
        }

        workbook.close();
        file.close();
    }
      // Load search queries for usernames from Excel file
      public static void loadSearchQueriesFromExcel(String filePath) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        searchQueries.clear();

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            String searchQuery = getCellValue(row.getCell(15));  // Column for 'homeSearch'
            if (searchQuery != null && !searchQuery.isEmpty()) {
                searchQueries.add(searchQuery);
            }
        }

        workbook.close();
        file.close();
    }
    
}

