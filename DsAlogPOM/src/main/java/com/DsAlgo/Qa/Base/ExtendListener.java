package com.DsAlgo.Qa.Base;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtendListener extends Baseclass implements ITestListener {

	// Sequencial running Below code will work
	// For parallel run neead ThreadLocal to maintain result accurate
	Baseclass bp = new Baseclass();

	ExtentReports extent = ExtentReporterBase.extentReporterGenerator();
	ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName() + " " + bp.getbroswername());
		System.out.println(result.getMethod().getMethodName() + " : " + bp.getbroswername() + " " + " Method Started");
		extentTest.set(test);
		System.out.println("Driver name: " + bp.getbroswername());
		extentTest.get().log(Status.INFO, "Test Info");
		extentTest.get().log(Status.INFO,
				result.getMethod().getMethodName() + " : " + bp.getbroswername() + " " + " Method Started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest.get().log(Status.PASS, "Test Passed");
		extentTest.get().log(Status.INFO,
				result.getMethod().getMethodName() + " : " + bp.getbroswername() + " " + " Method Success");

		System.out.println(result.getMethod().getMethodName() + " : " + bp.getbroswername() + " " + " Method Success");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());

		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName()),
					result.getMethod().getMethodName() + " " + bp.getbroswername());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result.getMethod().getMethodName() + " : " + bp.getbroswername() + " " + " Method Failed");
		extentTest.get().log(Status.INFO,
				result.getMethod().getMethodName() + " : " + bp.getbroswername() + " " + " Method Failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Test Skipped");
		try {
			extentTest.get().skip(result.getThrowable());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ITestListener.super.onTestSkipped(result);
		System.out.println(result.getMethod().getMethodName() + " : " + " Method skipped");
		extentTest.get().log(Status.INFO, result.getMethod().getMethodName() + " : " + " Method skipped");

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		System.out.println("Execution Completed");

	}

}
