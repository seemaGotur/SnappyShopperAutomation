package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "input-42")
    private WebElement emailField;

    @FindBy(id = "input-47")
    private WebElement passwordField;
    
    @FindBy(xpath ="//span[contains(text(), 'validation error')]")
    private WebElement errorMessage;
    
  
    @FindBy(xpath ="//span[contains(text(), 'Log out')]")
    private WebElement logOut;
    
    @FindBy(xpath ="//div[contains(@class, 'c-ss-member-quick-button')]")
    private WebElement allWebElement;
    
	/*
	 * @FindBy(xpath = "//button[@type='submit']") private WebElement loginButton;
	 */
    
    @FindBy(xpath ="  //button[@type='submit' and @data-cy='ss-login-form-submit-button']")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }
    
	
        public WebElement getloginButton() {
            return loginButton;
        }
        
        public WebElement getlogOutButton() {
            return logOut;
        }
        
        public WebElement getallWebElement() {
            return allWebElement;
        }
        
        
        public WebElement getErrorMessage()
        { 
        	return errorMessage;
        }

}