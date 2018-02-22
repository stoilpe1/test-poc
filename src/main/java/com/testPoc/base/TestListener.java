package com.testPoc.base;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult tr) {
        System.out.println(tr.getTestContext().getCurrentXmlTest().getName() + " - Test Success");
    }
    
    @Override
    public void onTestFailure(ITestResult tr) {
        System.out.println(tr.getTestContext().getCurrentXmlTest().getName() + " - Test Failure");
    }
    
    @Override
    public void onStart(ITestContext testContext) {
        System.out.println(testContext.getCurrentXmlTest().getName() + " - Test Start");
    }
    
    @Override
    public void onFinish(ITestContext testContext) {
        System.out.println(testContext.getCurrentXmlTest().getName() + " - Test Finish");
    }

}
