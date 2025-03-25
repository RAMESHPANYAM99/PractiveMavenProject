package com.test.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyListeners implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports report;
	public ExtentTest test;
	
	public void onStart(ITestContext context) {
	    sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/Myreports.html");
	    sparkReporter.config().setTheme(Theme.DARK);
	    sparkReporter.config().setDocumentTitle("AutomationReport");
	    sparkReporter.config().setReportName("WallMartInterviewQuestion");
	    
	    report = new ExtentReports();
	    
	    report.attachReporter(sparkReporter);
	    report.setSystemInfo("Browser", "Chrome");
	    report.setSystemInfo("OS", "MAC");
	    report.setSystemInfo("Environment", "UAT");
	    report.setSystemInfo("Executor", "Panyam");
	    
	    
	  }
	
	public void onTestStart(ITestResult result) {
		System.out.println("On Start of Test case");
		  }
	 
	public void onTestSuccess(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.PASS, "Test case passed is: "+result.getName());
		  }
	 
	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.FAIL, "Reason for failure is: "+result.getThrowable());
		test.log(Status.FAIL, "Test case passed is: "+result.getName());
		  }
	 
	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.SKIP, "Test case skipped is: "+result.getName());
		
		  }
	 
	public void onFinish(ITestContext context) {
		report.flush();
		  }
	

}
