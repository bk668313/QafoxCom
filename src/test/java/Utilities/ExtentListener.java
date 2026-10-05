package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import TestBase.BaseClass;


public class ExtentListener extends BaseClass implements ITestListener  {
	
	public static ExtentReports extent = ExtentReportUtility.getExtentReport();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportUtility.test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportUtility.test.log(Status.PASS, "Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportUtility.test.log(Status.FAIL, "Test Failed: " + result.getName());
        ExtentReportUtility.test.log(Status.FAIL, result.getThrowable());

        try {
            String screenshotPath = capturescreen(result.getName());

            if (screenshotPath != null && !screenshotPath.isEmpty()) {
                ExtentReportUtility.test.addScreenCaptureFromPath(screenshotPath);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   

	@Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportUtility.test.log(Status.SKIP, "Test Skipped: " + result.getName());
        
    }
    

    
	@Override
	public void onFinish(ITestContext context)
	{
	    extent.flush();

	    String pathOfExtentReport =
	            System.getProperty("user.dir") + File.separator + "reports"
	                    + File.separator + ExtentReportUtility.reportName;

	    File extentReport = new File(pathOfExtentReport);
	    
	    if(extentReport.exists())
	    {
	    
	    try
	    {
	        Desktop.getDesktop().browse(extentReport.toURI());
	    }
	    catch(IOException e)
	    {
	        e.printStackTrace();
	    }
	}
	
	}
	
    }
