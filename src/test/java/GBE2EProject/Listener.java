package GBE2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import libraryy.base;
import resources.ExtentReporter;


public class Listener extends base implements ITestListener{
	 ExtentTest test;
	//ExtentReports extent=ExtentReporter.getReport();
	 //create new ExtentReporter to inherit the object of the class
	ExtentReporter rep= new ExtentReporter();
	//get the properties of getReport method
	ExtentReports extent=rep.getReport();
	//ThreadLocal helps not to overwrite test result when running in parallel mode
	ThreadLocal< ExtentTest> testLocal= new ThreadLocal< ExtentTest>();
	
	//above lines of code shouldn't be in any of the listeners method hence it will overwrite
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//rep=new ExtentReporter();
		
		
		//result.getMethod().getMethodName() helps to get the exact methodname without hardcoding
		test=extent.createTest(result.getMethod().getMethodName());
		testLocal.set(test);
		//ITestListener.super.onTestStart(result);
		
			}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestSuccess(result);
		//only used when running code sequentially
		//test.log(Status.PASS, "TEST PASSED, THANKS");
		testLocal.get().log(Status.PASS, "TEST PASSED, THANKS");
	}

	public void onTestFailure(ITestResult result) {
		//only used when running code sequentially
	//test.fail(result.getThrowable());
		testLocal.get().fail(result.getThrowable());

	WebDriver driver=null;
	String testMethodName=	result.getMethod().getMethodName();
	
	try {
		driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (Exception e) {}
	
		try {
			testLocal.get().addScreenCaptureFromPath(getScreenShot(testMethodName, driver), result.getMethod().getMethodName());
			//getScreenShot(testMethodName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		//ITestListener.super.onTestFailure(result);
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestSkipped(result);
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}


	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onStart(context);
	}


	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extent.flush();
	}


	}
