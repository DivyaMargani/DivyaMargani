package hospitalAdmin;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HospitalAdmin {
	WebDriver driver;

	@BeforeTest
	public void launch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://ambulance.genamplifysol.com/");
		driver.navigate().refresh();
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).sendKeys("hospital@test.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("hospital@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}

	@Test(dependsOnMethods = "login")
	public void dashboard() throws InterruptedException {
		
		WebElement dashboard=driver.findElement(By.xpath("//span[text()='Dashboard']"));
		if(dashboard.isDisplayed()) {
			dashboard.click();
			System.out.println("Dashboard page ia appeared");
			
		}
		WebElement hospitalAdminlogo=driver.findElement(By.xpath("//p[text()='Hospital Admin']"));
		if(hospitalAdminlogo.isDisplayed()) {
			System.out.println("HOSPITAL ADMIN IS VISIBLE");
		}
		Thread.sleep(2000);
		System.out.println("==============Dashboard Content==============");
			WebElement hospitaDashboard=	driver.findElement(By.xpath("//div[@class='stats']"));
	System.out.println(hospitaDashboard.isDisplayed());
	System.out.println(hospitaDashboard.getText());
	
		
	}
	@Test(priority=2)
	public void ambulanceManage() throws InterruptedException {
		System.out.println("========Ambulance management=================");
		driver.findElement(By.xpath("//span[text()='Ambulance management']")).click();
		Thread.sleep(2000);
		
		WebElement ambulanceManagement=driver.findElement(By.xpath("//*[text()='Ambulance Management']"));
		String ActualTitle=ambulanceManagement.getText();
		String expectedTitle="Ambulance Management";
	    Assert.assertEquals(ActualTitle,expectedTitle);
	    WebElement logo=driver.findElement(By.xpath("//img[@class='ambulancemanagement-icon']"));
	    if(logo.isDisplayed()) {
	    	System.out.println("Logo is visible");
	    }
	    else {
	    	System.out.println("Logo is not displayed");
	    }
	    driver.findElement(By.xpath("//button[text()='+ Add new']")).click();
	    driver.navigate().back();
	   
	}
	
	@Test(priority = 3)
	public void drivermanagement() throws InterruptedException {
		System.out.println("==================Driver Management============");
		driver.findElement(By.xpath("//span[text()='Driver management']")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='+ Add New']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("name")).sendKeys("divyavani");
		Thread.sleep(2000);
		driver.findElement(By.id("phoneNumber")).sendKeys("8987654324");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("admin@test.com");
		Thread.sleep(2000);
		Select select = new Select((driver.findElement(By.id("bloodGroup"))));
		select.selectByValue("A-");
		driver.findElement(By.id("dob")).sendKeys("14/08/1997");
		Thread.sleep(2000);
		driver.findElement(By.id("adhaarNumber")).sendKeys("123454326789");
		Thread.sleep(2000);
		driver.findElement(By.id("dlNumber")).sendKeys("12345678998765432");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
       // driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String alertMessage= driver.switchTo().alert().getText(); // capture alert message

		System.out.println(alertMessage);
		driver.switchTo().alert().accept();
		driver.navigate().refresh();
		driver.navigate().back();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void tableOfDriverManagemnt() {
		// table header contents
		System.out.println("TABLE HEADER");
		System.out.println("===========================");
		List<WebElement> listheader = driver.findElements(By.xpath("//table[@class='data-table']/thead/tr/th"));

		for (WebElement element1 : listheader) {
			System.out.println(element1.getText());
		}
		System.out.println("TABLE CONTENT");
		System.out.println("===========================");
		List<WebElement> listbody = driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr/td"));

		for (WebElement ele : listbody) {
			System.out.println(ele.getText());
		}

	}

	@AfterTest
	public void logout() {
		try {
			driver.findElement(By.xpath("//button[text()='Logout']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
