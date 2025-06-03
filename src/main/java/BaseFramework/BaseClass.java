package BaseFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.ExtentUtils;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;

	@BeforeClass
	public void setup() throws IOException {
		// Load config file

		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(
					"C:\\Users\\seema\\eclipse-workspace\\SnappyShopper\\Config\\Config.properties");
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		 String name = getClass().getSimpleName();  
		 System.out.println("Testcase name is : " +name);
		 ExtentUtils.setupReport(name); 
		 ExtentUtils.createTest(getClass().getSimpleName());
		
		System.out.println("initializing  the  the WebDriver");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\seema\\eclipse-workspace\\SnappyShopper\\Resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		System.out.println("Launching snappy Shopper URL");
	    ExtentUtils.logPass(driver, name, "Url is Launched Successfully"); 
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
			driver.quit();
			ExtentUtils.finalizeReport();
		}
	}

}
