package Tests;

import org.testng.annotations.Test;
import Pages.RegistrationPage;

public class RegistrationTest extends TestsParameters {
	
	
	@Test
	public void CreateUserPositive () throws InterruptedException {
		driver.navigate().to("http://localhost:8080/skaiciuotuvas");
		
		RegistrationPage rp = new RegistrationPage(driver); // Kvietimas paimti sukurtus metodus iš LoginPage
		rp.CreateUser();

	}
	
	@Test
	public void CreateUserNegative () throws InterruptedException {
		driver.navigate().to("http://localhost:8080/skaiciuotuvas");
		
		RegistrationPage rp = new RegistrationPage(driver); // Kvietimas paimti sukurtus metodus iš LoginPage
		rp.CreateUserNegtive();
	}

}