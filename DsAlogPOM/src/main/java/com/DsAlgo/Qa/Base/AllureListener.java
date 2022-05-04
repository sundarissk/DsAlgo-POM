package com.DsAlgo.Qa.Base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class AllureListener extends Baseclass implements ITestListener {

	// Baseclass bp = new Baseclass();

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	// Text attachments for Allure
	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshotAllure(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	// Text attachments for Allure
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	// HTML attachments for Allure (Not Using this time)
	@Attachment(value = "{0}", type = "text/html")
	public static String attachHtml(String html) {
		return html;
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println("I am in onStart method " + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", Baseclass.getDriver());
		saveTextLog("I am in onStart method " + iTestContext.getName());
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println("I am in onFinish method " + iTestContext.getName());
		// saveScreenshotAllure(Baseclass.driver);
		saveTextLog("I am in onFinish method " + iTestContext.getName());
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
		saveTextLog("I am in onTestStart method " + getTestMethodName(iTestResult) + " Start");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
		// saveScreenshotAllure(Baseclass.driver);
		saveTextLog("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
		saveScreenshotAllure(Baseclass.driver);
		saveTextLog("I am in onTestFailure method " + getTestMethodName(iTestResult) + " Failed and screenshot taken");

		/*
		 * Object testClass = iTestResult.getInstance(); WebDriver driver
		 * =((Baseclass)testClass).getDriver(); if(driver instanceof WebDriver) {
		 * System.out.println("I am in onTestFailure method " +
		 * getTestMethodName(iTestResult) + " failed");
		 * saveScreenshotAllure(Baseclass.driver);
		 */
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
		saveTextLog("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
		saveTextLog("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}
}
