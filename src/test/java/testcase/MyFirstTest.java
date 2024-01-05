package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class MyFirstTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();  //base
		WebDriver driver= new ChromeDriver();     //base
		
		driver.get("https://www.zoho.com/");      //properties 
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in")).click();  //locators - properties
		driver.findElement(By.id("login_id")).sendKeys("suraiyabegum400@gmail.com");
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Happy@2024");
		driver.findElement(By.xpath("//button[@id='nextbtn']//span[contains(text(),'Sign in')]")).click();
		driver.close();
	}

}
