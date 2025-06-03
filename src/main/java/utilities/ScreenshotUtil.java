	package utilities;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.io.FileHandler;
	import java.io.File;
	import java.io.IOException;

	public class ScreenshotUtil {
	    public static String takeScreenshot(WebDriver driver, String testName) {
	        try {
	            
	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	          //String path = "test-output/screenshots/" + testName + ".png";
	            String path = "C:\\Users\\seema\\eclipse-workspace\\SnappyShopper\\output" + testName + ".png";
	            FileHandler.copy(src, new File(path));
	            return path;
	        } catch (IOException e) {
	            System.out.println("Failed to take screenshot: " + e.getMessage());
	            return null;
	        }
	    }
	}
