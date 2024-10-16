package hospitalAdmin;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RidelistDetails {

	static WebDriver driver;
	
	@BeforeTest
	public void launch() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://ambulance.genamplifysol.com/");
		driver.navigate().refresh();
	}
	@Test(priority=1)
	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).sendKeys("hospital@test.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("hospital@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	
	WebElement dashboard=	driver.findElement(By.xpath("//span[text()='dashboard']"));
		if(dashboard.isDisplayed()) {
			System.out.println("Login is successfull");
		}
		else {
			System.out.println("login is failure");
		}
		
	}
	@Test(dependsOnMethods = "login")
	public void ride() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Ride list']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@placeholder='Search by username or driver']")).sendKeys("sam");
		//table header details
		List<WebElement> list1=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/thead/tr/th"));
		for(WebElement element1:list1) {
			System.out.println(element1.getText());
		}
		//table body details
		List<WebElement> list2=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr/td"));
		for(WebElement elements:list2) {
			System.out.println(elements.getText());
		}
		driver.navigate().back();
		Thread.sleep(3000);
		
	}
	
	
	@AfterTest
	public void teardown() {
		driver.findElement(By.xpath("//button[text()='Logout']")).click();
		driver.quit();
	}
	
}
