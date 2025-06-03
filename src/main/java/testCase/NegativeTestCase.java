package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseFramework.BaseClass;
import Pages.CheckTest;
import Pages.LoginPage;
import utilities.ExtentUtils;

public class NegativeTestCase extends BaseClass {
	
	@Test
	public void loginNegativeCase() {

		LoginPage loginPage = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.getloginButton()));

		ExtentUtils.logTestInfo("Navigated to SnappyShop Application Page");
		
		//Entering Invalidvalid credentials
		loginPage.enterEmail(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("InvalidPassword"));
		System.out.println("Entering the Invalid Credential Username and Password is : " +prop.getProperty("validEmail")+"  "+prop.getProperty("InvalidPassword"));
		ExtentUtils.logPass(driver,"credentialInvalid", "Invalid Email & Password Entered ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		loginPage.clickLogin();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70000));
		
		
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath ("//span[contains(text(), 'validation error')]")));
		System.out.println(errorMessage.getText());

		
		String expectedErrorMessage = "There was a validation error, please make sure your details are correct.";
	  //  Validate message text 
	//WebElement element = driver.findElement(By.xpath ("//span[contains(text(), 'validation error')]")); 
		String actualErrorMessage = errorMessage.getText();
		System.out.println("Actual Error Message: " +actualErrorMessage);
	
		
		if (actualErrorMessage.equals(expectedErrorMessage)) { 
			System.out.println("Error message validation passed and Actual Error message is: " +"  "+actualErrorMessage);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	        Assert.assertTrue(actualErrorMessage.equals(expectedErrorMessage), "PASSED!");
			ExtentUtils.logPass(driver,"InValidloginTest", "Error message validation passed");
			ExtentUtils.logTestInfo("Negative TestCase for Invalid Credential is Passed");
			
			System.out.println("Error message validation passed and Negative Testcase is PASS");
		} else
		{
			ExtentUtils.logFailure(driver, "Invalidcredentials", "Error Message is not displayed correctly");
			Assert.fail("Error message validation on Invalid credential is FAILED");
	        System.out.println("Error message validation is FAILED! Expected: \"" +
			 expectedErrorMessage + "\", but found: \"" + actualErrorMessage + "\""); }
		}
	
}