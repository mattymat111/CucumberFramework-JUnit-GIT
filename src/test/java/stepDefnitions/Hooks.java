package stepDefnitions;

import java.io.IOException;

import io.cucumber.java.After;
import utils.TestContextSetup;

public class Hooks {

	public TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup) throws IOException {
		this.testContextSetup = testContextSetup;
	}

	@After
	public void AfterScenario() throws IOException {
		testContextSetup.testBase.WebDriverManger().quit();
	}

}
