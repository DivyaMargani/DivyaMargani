package datadriven;

import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class CrossBrowserTesting {
   WebDriver driver;
	@BeforeTest
	@org.testng.annotations.Parameters("browser")
	public void launch(String browser) {
		
		if(browser.equals("Chrome")) {
			driver=new ChromeDriver();
		}
		if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		
	
	}
	@Test
	public void login() {
		driver.get("https://www.facebook.com/login/");
		
		WebElement un=driver.findElement(By.id("email"));
		un.sendKeys("divyavani@gmail.com");
		
		WebElement pass=driver.findElement(By.id("pass"));
		pass.sendKeys("Heshu@123");
		
		WebElement loginbutton=driver.findElement(By.id("loginbutton"));
	}
	
	
	@AfterTest
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
}
