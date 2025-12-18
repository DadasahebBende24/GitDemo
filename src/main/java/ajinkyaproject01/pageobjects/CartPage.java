package ajinkyaproject01.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AjinkyaProject.AbstractComponents.AbstractComponent;
import java.util.List;
import java.util.stream.Collectors;


public class CartPage extends AbstractComponent {// inheritance

	WebDriver driver;// local driver variable
	
	@FindBy(css=".totalRow button")
	private WebElement checkoutButton;// checkout button element
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;// list of products in cart
	
	public CartPage(WebDriver driver) {
		
		 
				super(driver);// we are calling the constructor of parent class(AbstractComponent) here
				this.driver = driver;// initializing local driver variable
				PageFactory.initElements(driver, this);// this will initialize all the @FindBy elements
				
			}
		 
		 
     public Boolean verifyProductDisplay(String productName) {// method to verify product is displayed in cart
    	 List<String> names = cartProducts.stream()
    			    .map(WebElement::getText)
    			    .map(String::trim)
    			    .collect(Collectors.toList());
    			System.out.println(names);
		 Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equals(productName));		 
		 return match;
	 }
     
     public CheckOutPage goToCheckout() {// method to navigate to checkout page
		 checkoutButton.click();
		 return new CheckOutPage(driver);
	 }
	

}
