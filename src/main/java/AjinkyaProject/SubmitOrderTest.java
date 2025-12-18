package AjinkyaProject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import AjinkyaProject.TestComponents.BaseTest;
import ajinkyaproject01.pageobjects.CartPage;
import ajinkyaproject01.pageobjects.CheckOutPage;
import ajinkyaproject01.pageobjects.ConfirmationPage;
import ajinkyaproject01.pageobjects.LandingPage;
import ajinkyaproject01.pageobjects.OrderPage;
import ajinkyaproject01.pageobjects.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SubmitOrderTest extends BaseTest {
	 String productName = "ZARA COAT 3";
	@Test(dataProvider = "GetData", groups = { "Purchase" })
	public void submitOrderTest(HashMap<String, String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("This is standalone java class");

		String countryName = "India";
		ProductCatalog productCatalog = landingPage.loginApplication(input.get("email"), input.get("password"));
		String productName = input.get("productName");
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(input.get("productName"));
		CartPage cartPage = productCatalog.goToCart();
		Boolean match = cartPage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartPage.goToCheckout();
		checkoutpage.selectCountry(countryName);
		ConfirmationPage confirmationpage = checkoutpage.submitOrder();
		String confirmMessage = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = {"submitOrderTest"})
		public void orderHistoryTest() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ProductCatalog productCatalog = landingPage.loginApplication("dvbende@gmail.com", "Learning@1234");
		OrderPage ordersPage = productCatalog.goToOrders();
		Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));

	}
	
	
	
	
	/*
	 * public String getScreenshot(String testCaseName, WebDriver driver) throws
	 * IOException {
	 * 
	 * TakesScreenshot ts = (TakesScreenshot)driver; File src =
	 * ts.getScreenshotAs(OutputType.FILE); File file = new
	 * File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
	 * FileUtils.copyFile(src, file); return
	 * System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	 * 
	 * }
	 */

	@DataProvider(name = "GetData")
	public Object[][] getData() throws IOException {

		/*
		 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
		 * "dvbende@gmail.com"); map.put("password", "Learning@1234");
		 * map.put("productName", "ADIDAS ORIGINAL");
		 * 
		 * HashMap<String, String> map1 = new HashMap<String, String>();
		 * map1.put("email", "dvbende@gmail.com"); map1.put("password",
		 * "Learning@1234"); map1.put("productName", "ADIDAS ORIGINAL");
		 * 
		 * return new Object[][] { { map }, { map1 } };
		 */
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//main//java//ajinkyaproject01//data//PurchaseOrder.json");
		//List<HashMap<String, String>> data = getJsonDataToMap("C://User//Dadasaheb//eclipse-workspace//SeleniumFramworkDesign//src//main//java//ajinkyaproject01//data//PurchaseOrder.json");
		
		return new Object[][] { { data.get(0) }, {data.get(1) } };
		
		
	}

	/*
	 * @DataProvider(name = "GetData1") public Object[][] getData1() { return new
	 * Object[][] { { "dvbende@gmail.com", "Learning@1234", "ADIDAS ORIGINAL" }, {
	 * "dvbende@gmail.com", "Learning@1234", "ADIDAS ORIGINAL" } };
	 * 
	 * }
	 */
}