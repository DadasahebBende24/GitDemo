package ajinkyaproject01.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AjinkyaProject.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	
	WebDriver driver;// local driver variable
	
	@FindBy(css=".totalRow button")
	 private WebElement checkoutButton;// checkout button element
	
	@FindBy(css="tr td:nth-child(3)")
	 private List<WebElement> productnames;// list of products in cart
	
	
	
	
	public OrderPage(WebDriver driver) {
	
	 		super(driver);// we are calling the constructor of parent class(AbstractComponent) here
	 		this.driver = driver;// initializing local driver variable
	 		PageFactory.initElements(driver, this);// this will initialize all the @FindBy elements
	 		
	}
	
	public Boolean verifyOrderDisplay(String productName) {// method to verify product is displayed in cart
		 Boolean match = productnames.stream().anyMatch(cartProduct->cartProduct.getText().equals(productName));
		 return match;
	 }
	 
		

}
