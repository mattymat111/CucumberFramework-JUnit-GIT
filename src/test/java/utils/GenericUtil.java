package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtil {
	
	public WebDriver driver;
	
	public GenericUtil(WebDriver driver) {
		this.driver = driver;
	}
	
		public void SwitchWindowToChild() {
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> it = s1.iterator();
			String parentWindow = it.next();
			String childWindow = it.next();
			driver.switchTo().window(childWindow);
		}

}
