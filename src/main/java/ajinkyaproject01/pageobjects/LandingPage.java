package ajinkyaproject01.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AjinkyaProject.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {// inheritance

	WebDriver driver;// local driver variable
	
	@FindBy(id="userEmail")// locating email field
	WebElement userEmail;// email field element
	
	@FindBy(id="userPassword")// locating password field
	WebElement userPassword;// password field element
	
	@FindBy(id="login")// locating login button
	WebElement login;// login button element
	
	@FindBy(css="[class*='flyInOut']")// locating error message
	WebElement errorMessage;// error message element
	
	
	
	public LandingPage(WebDriver driver) {// constructor
		super(driver);// we are calling the constructor of parent class(AbstractComponent) here
		this.driver = driver;// initializing local driver variable
		PageFactory.initElements(driver, this);// this will initialize all the @FindBy elements
	}

	
	public ProductCatalog loginApplication(String email, String password) {// method to login to application
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;
	}
	
	public void goTo() {// method to navigate to landing page
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
	
	public String getErrorMessage() {// method to get error message
		waitForElementToAppear(errorMessage);
		return errorMessage.getText();
	}	

}
