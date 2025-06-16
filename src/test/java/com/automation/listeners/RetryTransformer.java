package com.automation.listeners;

import com.automation.utility.reportUtils.LogUtil;
import com.automation.testUtils.RetryFailedTests;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        LogUtil.logInfo("Applying retry logic dynamically");
        annotation.setRetryAnalyzer(RetryFailedTests.class); // Apply retry logic dynamically
    }
}