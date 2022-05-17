package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestsParameters {
	
	protected static WebDriver driver;
	
	@BeforeTest
	public static void SetUp() {
		driver = new ChromeDriver();
	}
	
	@AfterTest
	public static void TearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
	}

}
