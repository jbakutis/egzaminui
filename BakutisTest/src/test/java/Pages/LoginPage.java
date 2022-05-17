package Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// extends nurodymas reikalingas, kad trauktume parametrus iš PageParameters puslapio

public class LoginPage extends PageParameters {

	//1. Lokatoriai
	
	By inputLoginUserName = By.cssSelector("input[placeholder='Prisijungimo vardas']");
	By inputLoginPsw = By.cssSelector("input[placeholder='Slaptažodis']");
	By buttonLogin = By.xpath("//button[normalize-space()='Prisijungti']");
	By buttonLogout = By.xpath("//a[normalize-space()='Logout, labas1']");	

	
	//2. Konstruktorius
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3. Metodai
	
	
	// Sėkmingas loginas su patikrinimu
	
	public void LoginUser() throws InterruptedException {
		driver.findElement(inputLoginUserName).sendKeys("labas1");
		Thread.sleep(2000);
		driver.findElement(inputLoginPsw).sendKeys("labas1");
		Thread.sleep(2000);
		driver.findElement(buttonLogin).click();
		Thread.sleep(2000);
		//driver.findElement(buttonLogout).click();
		String actualMessage = driver.findElement(By.linkText("Logout, labas1")).getText();
		Thread.sleep(2000);
		System.out.println(actualMessage); // Išsiprintinam, koks username prisijungus
		String expectedMessage = "Logout, labas1";
		assertEquals(expectedMessage,actualMessage); // Sulyginam ar atitinka 
		System.out.println("Prisijungimo tekstas yra: " +actualMessage);
		driver.findElement(buttonLogout).click();

	}
	
	// Nesėkmingas loginas su patikrinimu. Įvedamas neteisingas slaptažodis
	
	public void LoginUserNegative() throws InterruptedException {
		driver.findElement(inputLoginUserName).sendKeys("labas1");
		Thread.sleep(2000);
		driver.findElement(inputLoginPsw).sendKeys("labas");
		Thread.sleep(2000);
		driver.findElement(buttonLogin).click();
		Thread.sleep(2000);
		String actualMessage = driver.findElement(By.xpath("//span[contains(text(),'prisijungimo vardas')]")).getText();
		System.out.println(actualMessage); // Išsiprintinam klaidos pranešimą
		Thread.sleep(2000);
		String expectedMessage = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";
		assertEquals(expectedMessage,actualMessage); // Sulyginam ar atitinka 
		System.out.println("Klaidos tekstas yra: " +actualMessage);
	}
}