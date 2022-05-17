package Tests;

import org.testng.annotations.Test;
import Pages.LoginPage;

public class LoginTest extends TestsParameters{

	@Test
	public void LoginTestPositive () throws InterruptedException {
		driver.navigate().to("http://localhost:8080/skaiciuotuvas");
		
		LoginPage lp = new LoginPage(driver); // Kvietimas paimti sukurtus metodus iš LoginPage
		lp.LoginUser();
	}
	
	@Test
	public void LoginTestNegative () throws InterruptedException {
		driver.navigate().to("http://localhost:8080/skaiciuotuvas");
		
		LoginPage lp = new LoginPage(driver); // Kvietimas paimti sukurtus metodus iš LoginPage
		lp.LoginUserNegative();
	}
	
}
