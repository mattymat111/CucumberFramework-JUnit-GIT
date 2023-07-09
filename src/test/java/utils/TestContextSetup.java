package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageobjects.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public String prodNameHomePage;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtil genericUtil;
	
	public TestContextSetup() throws IOException {
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManger());
		genericUtil = new GenericUtil(testBase.WebDriverManger());
	}

}
