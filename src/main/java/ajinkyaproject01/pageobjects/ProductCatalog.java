package ajinkyaproject01.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AjinkyaProject.AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {// inheritance
	
	WebDriver driver;// local driver variable
	
	@FindBy(css=".mb-3")
	List<WebElement> products;// list of products
	
	@FindBy(css=".ng-animating")
	WebElement spinner;// spinner element
	
	@FindBy(css=".toast-container")
	WebElement toastMessage;// toast message element
	
	By productsBy = By.cssSelector(".mb-3");// products locator
	By addToCartBy = By.cssSelector(".card-body button:last-of-type");// add to cart button
	By toastMessageBy = By.cssSelector("#toast-container");// toast message element
	
	public ProductCatalog(WebDriver driver) {
		super(driver);// we are calling the constructor of parent class(AbstractComponent) here
		this.driver = driver;// initializing local driver variable
		PageFactory.initElements(driver, this);// this will initialize all the @FindBy elements
		
	}
	

	
	public List<WebElement> getProductList() {// method to get list of products
		
		waitForElementToAppear(spinner);
		return products;
		
	}
	
	public WebElement getProductByName(String productName) {// method to get product by name
		WebElement prod = getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);// lambda function to filter product by name
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException {
		
		WebElement prod= getProductByName(productName);
		prod.findElement(addToCartBy).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
	}
	

}
