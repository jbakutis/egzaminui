package Tests;

import org.testng.annotations.Test;
import Pages.CalculatorPage;

public class LogoutTest extends TestsParameters{

	@Test
	public void LogouTestPositive () throws InterruptedException {
		driver.navigate().to("http://localhost:8080/skaiciuotuvas");
		
		CalculatorPage cp = new CalculatorPage(driver); // Kvietimas paimti sukurtus metodus iš LoginPage
		cp.LogOutUser();
	}
	
}
