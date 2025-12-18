package AjinkyaProject.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ajinkyaproject01.pageobjects.CartPage;
import ajinkyaproject01.pageobjects.OrderPage;

public class AbstractComponent {// base class for all page objects
	
	WebDriver driver;// local driver variable
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;// cart header element
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement ordersHeader;// orders header element
	
	public AbstractComponent(WebDriver driver) {//	 constructor
		
		this.driver = driver;// initializing local driver variable
	    PageFactory.initElements(driver, this);// this will initialize all the @FindBy elements
	}

	public void waitForElementToAppear(WebElement element) {// method to wait for element to appear
	WebDriverWait wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToDisappear(WebElement element) throws InterruptedException {// method to wait for element to disappear
		Thread.sleep(1000);
//	WebDriverWait wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(10));
//	wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public CartPage goToCart() {// method to navigate to cart page
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrders() {// method to navigate to orders page
		ordersHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
		
	}

}