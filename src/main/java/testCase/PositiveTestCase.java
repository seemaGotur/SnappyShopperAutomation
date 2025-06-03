package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseFramework.BaseClass;
import Pages.LoginPage;
import Pages.MyAccountPage;
import utilities.ExtentUtils;

public class PositiveTestCase extends BaseClass {

	@Test
	public void loginTest() {

		LoginPage loginPage = new LoginPage(driver);
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		WebElement logoutButton = loginPage.getlogOutButton();
		/* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50)); */
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.getloginButton()));

		ExtentUtils.logTestInfo("Navigated to Login Page");
		
		//Entering valid credentials
		loginPage.enterEmail(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		System.out.println("Entering the valid Credential Username and Password is : " +prop.getProperty("validEmail")+"  "+prop.getProperty("validPassword"));
		
		ExtentUtils.logPass(driver,"credential", "Valid Email&Password Entered Successfully");
	//   ExtentUtils.logStepWithScreenshot(driver, "Credential", "Valid Email&Password Entered Successfully");
		loginPage.clickLogin();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard")));
			if (logoutButton.isEnabled()) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	        Assert.assertTrue(logoutButton.isDisplayed(), "PASSED!");
			System.out.println("User logged into appliction successfully ");
			ExtentUtils.logPass(driver,"loginTest", "LogOut Button Is Enabled , User is able to login to application successfully");
			ExtentUtils.logTestInfo("Positive TestCase for Login is Passed ");
			System.out.println("User is able to view Logout Button - Positive TestCase for Login is PASS ");
		} else {
			ExtentUtils.logFailure(driver, "loginTest", "LogOut Button Is not Enabled");
			Assert.fail(" LogOut button is NOT visible. Test FAILED!");
			System.out.println("User is Unable to view Logout Button - Positive TestCase for Login is Fail ");
		}
	
	}
}