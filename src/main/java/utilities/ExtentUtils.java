package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;

public class ExtentUtils {
	private static ExtentReports extent;
	private static ExtentTest test;
	private static ExtentSparkReporter htmlReporter;

	public static void setupReport(String tcName) {
	
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\seema\\eclipse-workspace\\SnappyShopper\\output\\" +tcName+".html");
			System.out.println("new extent report is created" +sparkReporter);
		    extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			
			System.out.println("new extent dfsdfreport is created" +sparkReporter);
	
	}

	public static void createTest(String testName) {
		System.out.println("testName is " +testName);
		if (extent == null) {
			throw new RuntimeException("ERROR: ExtentReports is NULL. Call setupReport() first!");
		}
		test = extent.createTest(testName);
	
	}

	public static void logTestInfo(String message) {
		test.info(message);
	}

	
	public static void logFailure(WebDriver driver, String testName, String errorMessage) {
		String screenshotPath = ScreenshotUtil.takeScreenshot(driver, testName);
		if (screenshotPath != null) {
			test.fail(errorMessage, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			
		} else {
			test.fail(errorMessage);
		}
	}
	
	public static void logPass(WebDriver driver, String testName, String successMessage) {
	    String screenshotPath = ScreenshotUtil.takeScreenshot(driver, testName);
	    if (screenshotPath != null) {
	        test.pass(successMessage, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	    } else {
	        test.pass(successMessage);
	    }
	}
	
	public static void logStepWithScreenshot(WebDriver driver, String stepName, String message) {
        String screenshotPath = ScreenshotUtil.takeScreenshot(driver, stepName);
        if (screenshotPath != null) {
            test.info(message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.info(message);
        }
    }


	public static void finalizeReport() {
		extent.flush();
	}
}
