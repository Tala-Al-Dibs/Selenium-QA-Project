package com.selenium_project.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {
    private int passed = 0;
    private int failed = 0;
    private int skipped = 0;

    @Override
    public void onTestSuccess(ITestResult result) {
        passed++;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failed++;
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skipped++;
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("=====================================");
        System.out.println("tests=" + context.getAllTestMethods().length +
                           " passed=" + passed +
                           " failed=" + failed +
                           " skipped=" + skipped);
        System.out.println("=====================================");
    }
}

