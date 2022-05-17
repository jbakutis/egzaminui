package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageParameters {

protected WebDriver driver;
	
	// Super konstruktorius leidžia puslapiams bendrauti tarpusavy. Visada toks pat

	public void PageParameters(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
