package AjinkyaProject;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

import AjinkyaProject.TestComponents.BaseTest;
import ajinkyaproject01.pageobjects.CartPage;
import ajinkyaproject01.pageobjects.CheckOutPage;
import ajinkyaproject01.pageobjects.ConfirmationPage;
import ajinkyaproject01.pageobjects.LandingPage;
import ajinkyaproject01.pageobjects.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;
import AjinkyaProject.TestComponents.Retry;

public class ErrorValidationTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void loginerrorValidationTest() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String productName = "ADIDAS ORIGINAL";
		String countryName = "India";
		landingPage.loginApplication("dvbende@gmail.com", "Learning@12345");
		Assert.assertEquals("Incorrect emai or password.", landingPage.getErrorMessage());
		
	
	}
	
	@Test
	public void productErrorValidationTest() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String productName = "ADIDAS ORIGINAL";
		String productName1 = "ADIDAS ORIGINAL1";
		String countryName = "India";
		ProductCatalog productCatalog =landingPage.loginApplication("dvbende@gmail.com", "Learning@1234");
		List<WebElement>products= productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
		CartPage cartPage = productCatalog.goToCart();
		Boolean match = cartPage.verifyProductDisplay(productName1);
		Assert.assertFalse(match);
		
}
}