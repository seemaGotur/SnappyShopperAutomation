package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	

		 WebDriver driver;
		 
		 @FindBy(xpath ="//span[contains(text(), 'Log out')]")
		    private WebElement logOut;
		  
		 public MyAccountPage(WebDriver driver) {
		        this.driver = driver;
		        PageFactory.initElements(driver, this);
		    }

		    public WebElement getlogOutButton() {
	            return logOut;
	        }
	        
		 
		public String getPageTitle() {

			return driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div/div[3]/div/div[1]"))
					.getText();
		}
		
		public String getUserName() {

			return driver.findElement(By.xpath("//input[@id='input-42']"))
					.getText();
		}
		
		public void performLogin(String email, String password) {
		
			
			WebElement element = driver.findElement(By.xpath("//input[@id='input-42']"));
			element.sendKeys("Seema");

		

		}
		
		

}
