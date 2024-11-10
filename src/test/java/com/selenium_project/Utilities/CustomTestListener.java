package com.selenium_project.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomTestListener implements ITestListener {
    private AtomicInteger passed = new AtomicInteger(0);
    private AtomicInteger failed = new AtomicInteger(0);
    private AtomicInteger skipped = new AtomicInteger(0);

    @Override
    public void onTestSuccess(ITestResult result) {
        passed.incrementAndGet();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failed.incrementAndGet();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        skipped.incrementAndGet();
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("=====================================");
        System.out.println("tests=" + context.getAllTestMethods().length +
                           " passed=" + passed.get() +
                           " failed=" + failed.get() +
                           " skipped=" + skipped.get());
        System.out.println("=====================================");
    }
}
