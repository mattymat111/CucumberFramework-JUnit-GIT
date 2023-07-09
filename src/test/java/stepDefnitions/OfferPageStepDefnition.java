package stepDefnitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pageobjects.LandingPage;
import pageobjects.OffersPage;
import pageobjects.PageObjectManager;
import utils.GenericUtil;
import utils.TestContextSetup;

public class OfferPageStepDefnition {
	public String prodNameOfferPage;
	public TestContextSetup testContextSetup;
	public OffersPage offersPage;
	public LandingPage landingPage;
	public PageObjectManager pageObjectManager;
	public GenericUtil genericUtil;

	// Single responsibility principle, loosely coupled, Factory Design Pattern

	public OfferPageStepDefnition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.offersPage = testContextSetup.pageObjectManager.getOffersPage();
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	//User searched with Short name <Name> in Offers page to check if the Product exists.
	@Then("^User searched with Short name (.+) in Offers page to check if the Product exists.$")
	public void user_searched_for_same_short_name_in_offers_page_to_check_if_the_product_exists(String offerName)
			throws InterruptedException {

		switchToOffersPage();
		//offersPage = testContextSetup.pageObjectManager.getOffersPage();
		offersPage.searchItem(offerName);
		Thread.sleep(2000);
		prodNameOfferPage = offersPage.searchProductName();
		System.out.println("\n"+prodNameOfferPage + " is extracted from the Offers page."+"\n");

		Assert.assertEquals(testContextSetup.prodNameHomePage, prodNameOfferPage);
	}

	public void switchToOffersPage() {
		//landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchProdLink();
		testContextSetup.genericUtil.SwitchWindowToChild();
	}

}
