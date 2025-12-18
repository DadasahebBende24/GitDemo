package ajinkyaproject01.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import AjinkyaProject.TestComponents.BaseTest;
import ajinkyaproject01.pageobjects.CartPage;
import ajinkyaproject01.pageobjects.CheckOutPage;
import ajinkyaproject01.pageobjects.ConfirmationPage;
import ajinkyaproject01.pageobjects.LandingPage;
import ajinkyaproject01.pageobjects.ProductCatalog;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalog productCatalog;
	public CheckOutPage checkoutpage;
	public ConfirmationPage confirmationpage;

	@Given("the user is on the landing page")
	public void the_user_is_on_the_landing_page() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		landingPage = launchApplication();

	}

	@Given("logged in user name is {string} and password is {string}")
	// @Given("^the user logged in with username (.+) and password (.+)$")
	public void the_user_logged_in_with_username_and_password(String username, String password) {
		// Write code here that turns the phrase above into concrete actions

		productCatalog = landingPage.loginApplication(username, password);

	}

	@When("I add product {string} to Cart")
	public void i_add_product_to_cart(String productName) throws InterruptedException {
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(productName);

	}

	// @When("^checkout product name (.+) and submit the order$")
	@When("Checkout {string} and submit the order")
	public void checkout_and_submit_the_order(String productName) throws InterruptedException {
		CartPage cartPage = productCatalog.goToCart();
		System.out.println(productName);
		Thread.sleep(3000);
		Boolean match = cartPage.verifyProductDisplay(productName);
		System.out.println(match);
		// Assert.assertTrue(match);
		checkoutpage = cartPage.goToCheckout();
		checkoutpage.selectCountry("india");
		confirmationpage = checkoutpage.submitOrder();
	}

	@Then("{string} message is displayed on ConfirmationPage")
	public void message_is_displayed_on_confirmation_page(String string) {
		// Write code here that turns the phrase above into concrete actions
		String confirmMessage = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	}

	@Then("^\"([^\"]*)\" message is displayed$")
	public void something_message_is_displayed(String strArg1) throws Throwable {

		Assert.assertEquals(strArg1, landingPage.getErrorMessage());
		driver.close();
	}


}
