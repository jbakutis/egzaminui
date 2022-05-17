package Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// extends nurodymas reikalingas, kad trauktume parametrus iš PageParameters puslapio

public class RegistrationPage extends PageParameters {

	//1. Lokatoriai
	
	By selectionRegister = By.xpath("//a[contains(text(),'Sukurti naują paskyrą')]");
	By inputUserName = By.cssSelector("#username");
	By inputPsw = By.cssSelector("#password");
	By inputPswConfirm = By.cssSelector("#passwordConfirm");
	By buttonSubmitUser = By.cssSelector("button[type='submit']");

	
	
	//2. Konstruktorius
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3. Metodai
	
	// Sėkminga registracija su patikrinimu. Darant testa atnaujint duomenis.
	
	public void CreateUser() throws InterruptedException {
		driver.findElement(selectionRegister).click();
		Thread.sleep(2000);
		driver.findElement(inputUserName).sendKeys("labadiena4"); //atnauujint darant testa
		Thread.sleep(2000);
		driver.findElement(inputPsw).sendKeys("justinas2");
		Thread.sleep(2000);
		driver.findElement(inputPswConfirm).sendKeys("justinas2");
		Thread.sleep(2000);
		driver.findElement(buttonSubmitUser).click();
		Thread.sleep(2000);
		String actualMessage = driver.findElement(By.xpath("/html/body/nav/div/ul[2]/a")).getText();
		System.out.println(actualMessage); // Išiprintinam, koks username uzsiregistravus
		Thread.sleep(2000);
		String expectedMessage = "Logout, labadiena4"; // Atnaujint darant testa
		assertEquals(expectedMessage,actualMessage);
		System.out.println("Prisijungimo tekstas yra: " +actualMessage);
	}
		
	
	// Nesėkminga registracija su patikrinimu. 
	
		public void CreateUserNegtive() throws InterruptedException {
			driver.findElement(selectionRegister).click();
			Thread.sleep(2000);
			driver.findElement(inputUserName).sendKeys("labas1");
			Thread.sleep(2000);
			driver.findElement(inputPsw).sendKeys("labas");
			Thread.sleep(2000);
			driver.findElement(inputPswConfirm).sendKeys("labas");
			Thread.sleep(2000);
			driver.findElement(buttonSubmitUser).click();
			Thread.sleep(2000);
			String actualMessage = driver.findElement(By.id("username.errors")).getText();
			System.out.println(actualMessage); // Išsiprintinam, koks username užsiregistravus
			Thread.sleep(2000);
			String expectedMessage = "Toks vartotojo vardas jau egzistuoja";
			assertEquals(expectedMessage,actualMessage);
			System.out.println("Klaidos pranešimas yra: " +actualMessage);
		}
}

