package ajinkyaproject01.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AjinkyaProject.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {// inheritance
	
	WebDriver driver;// local driver variable
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;// confirmation message element
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);// we are calling the constructor of parent class(AbstractComponent) here
		this.driver = driver;// initializing local driver variable
		PageFactory.initElements(driver, this);// this will initialize all the @FindBy elements
		
	}
	
	public String getConfirmationMessage() {// method to get confirmation message
		return confirmationMessage.getText();
	}

}
