package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;
	public By search = By.xpath("//input[@type='search']");
	public By productName = By.cssSelector("h4.product-name");
	public By prodLink = By.linkText("Top Deals");
	public By increment = By.cssSelector("a.increment");
	public By addToCart = By.cssSelector(".product-action button");
	public By cartIcon = By.cssSelector("img[alt='Cart']");
	public By proceedToCheckout = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	public By cartProductName = By.cssSelector("p.product-name");
	public By applyBtn = By.cssSelector(".promoBtn");
	public By placeOrderBtn = By.xpath("//button[contains(text(),'Place Order')]");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}

	public String searchProductName() {
		return driver.findElement(productName).getText().split("-")[0].trim();
	}

	public void searchProdLink() {
		driver.findElement(prodLink).click();
	}

	public void doProdIncrement() {
		driver.findElement(increment).click();
	}

	public void addToCartBtn() {
		driver.findElement(addToCart).click();
	}

	public void getCartIcon() {
		driver.findElement(cartIcon).click();
		driver.findElement(proceedToCheckout).click();
	}

	public String getCartProductName() {
		return driver.findElement(cartProductName).getText().split("-")[0].trim();
	}

	public boolean applyBtnVisible() {
		return driver.findElement(applyBtn).isEnabled();
	}

	public boolean placeOrderBtnVisible() {
		return driver.findElement(placeOrderBtn).isEnabled();
	}

}
