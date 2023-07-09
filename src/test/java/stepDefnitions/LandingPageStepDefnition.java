package stepDefnitions;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import pageobjects.PageObjectManager;
import utils.TestContextSetup;

public class LandingPageStepDefnition {
	public TestContextSetup testContextSetup;
	public PageObjectManager pageObjectManager;
	public LandingPage landingPage;

	public LandingPageStepDefnition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on the GreenCart Landing Page.")
	public void user_is_on_the_green_cart_landing_page() throws IOException {
		// testContextSetup.driver = testContextSetup.testBase.WebDriverManger();
	}

	// User searched with Short name <Name> and extracted actual name of the
	// Product.
	@When("^User searched with Short name (.+) and extracted actual name of the Product.$")
	public void user_searched_with_short_name_and_extracted_actual_name_of_the_product(String shortName)
			throws InterruptedException {

		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.prodNameHomePage = landingPage.searchProductName();
		System.out.println("\n"+testContextSetup.prodNameHomePage + " is extracted from the Home page.");
	}

	@When("User searched with Short name {string} and added four times of the Product and added to cart.")
	public void user_searched_with_short_name_and_added_four_times_of_the_product_and_added_to_cart(String shortName)
			throws InterruptedException {
		// landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.prodNameHomePage = landingPage.searchProductName();
		System.out.println("\n"+testContextSetup.prodNameHomePage + " is extracted from the Home page.");
		for (int i = 1; i < 3; i++) {
			landingPage.doProdIncrement();
			System.out.println("POST GIT 1");
		}

		landingPage.addToCartBtn();
	}

	// User verifies product name and Apply and Place Order button should be visible
	@Then("User verifies product name and Apply and Place Order button should be visible.")
	public void user_verifies_product_name_and_apply_and_place_order_button_should_be_visible() {
		// landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.getCartIcon();
		String cartProductName = landingPage.getCartProductName();
		System.out.println("\n"+cartProductName + " is extracted from the Cart page."+"\n");
		
		Assert.assertTrue(landingPage.applyBtnVisible());
		Assert.assertTrue(landingPage.placeOrderBtnVisible());

		Assert.assertEquals(cartProductName, testContextSetup.prodNameHomePage);
	}

}
