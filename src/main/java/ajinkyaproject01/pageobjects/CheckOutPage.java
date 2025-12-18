package ajinkyaproject01.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AjinkyaProject.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {// inheritance
	
	WebDriver driver;// local driver variable
	
	String countryName="India";
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;// country selection element	
	
	@FindBy(css=".action__submit")
	WebElement submit;// place order button element
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectCountry;// select country element
	
	@FindBy(css=".ta-results")
	WebElement countryList;// country list element
	
	
	public CheckOutPage(WebDriver driver) {
		super(driver);// we are calling the constructor of parent class(AbstractComponent) here
		this.driver = driver;// initializing local driver variable
		PageFactory.initElements(driver, this);// this will initialize all the @FindBy elements
		
	}
	
	
	public void selectCountry(String countryName) {// method to select country
		Actions actions = new Actions(driver);
		actions.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(countryList);
		selectCountry.click();
	}	
	
	public ConfirmationPage submitOrder() {// method to submit order
		submit.click();
		return new ConfirmationPage(driver);
		
	}

}
