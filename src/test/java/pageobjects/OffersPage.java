package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	public WebDriver driver;
	public By search = By.xpath("//input[@type='search']");
	public By prodName = By.cssSelector(".table-bordered tr td:nth-child(1)");

	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}

	public String searchProductName() {
		return driver.findElement(prodName).getText();
	}

}
