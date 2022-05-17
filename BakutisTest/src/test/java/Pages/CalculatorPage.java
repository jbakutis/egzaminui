package Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorPage extends PageParameters {

		//1. Lokatoriai
		
		By inputLoginUserName = By.cssSelector("input[placeholder='Prisijungimo vardas']");
		By inputLoginPsw = By.cssSelector("input[placeholder='Slaptažodis']");
		By buttonLogin = By.xpath("//button[normalize-space()='Prisijungti']");
		By buttonLogout = By.xpath("//a[normalize-space()='Logout, labas1']");	
		
		//2. Konstruktorius
		
		public CalculatorPage(WebDriver driver) {
			this.driver=driver;
		}
		
		//3. Metodai
		
		//sekmingas vartotojo atsijungimas su patikrinimu
		public void LogOutUser() throws InterruptedException {
			driver.findElement(inputLoginUserName).sendKeys("labas1");
			Thread.sleep(2000);
			driver.findElement(inputLoginPsw).sendKeys("labas1");
			Thread.sleep(2000);
			driver.findElement(buttonLogin).click();
			Thread.sleep(2000);
			driver.findElement(buttonLogout).click();
			Thread.sleep(2000);
			String actualMessage = driver.findElement(By.cssSelector("span:nth-child(1)")).getText();
			System.out.println(actualMessage); // Išsiprintinam sekmingo atsijungimo zinute
			Thread.sleep(2000);
			String expectedMessage = "Sėkmingai atsijungėte";
			assertEquals(expectedMessage,actualMessage); // Palyginam žinutes
			System.out.println("Sekmingo atsijungimo žinutė yra: " +actualMessage);
		}
}

