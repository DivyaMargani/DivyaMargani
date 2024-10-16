package superadmin;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminLoginUM {
	private static final String String = null;
	static WebDriver driver;

	@BeforeTest
	public void launch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.get("https://ambulance.genamplifysol.com/");
	}

	@Test()
	public void login() throws InterruptedException {

		driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).sendKeys("admin@test.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("admin@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	}

	@Test(dependsOnMethods = "login")
	public void actions() {
		System.out.println("-------------------------------------");

		List<WebElement> list = driver.findElements(By.xpath(
				"//span[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-10hburv-MuiTypography-root']"));
		System.out.println(list.size());
		for (WebElement ele1 : list) {
			System.out.println(ele1.getText());

		}

	}

	@Test(dependsOnMethods = "actions")
	public void getUMtabledata() {
		WebElement uM = driver.findElement(By.xpath("//span[text()='User Management']"));
		// driver.navigate().refresh();
		boolean b1 = uM.isDisplayed();
		if (b1 == true) {
			uM.click();
		}
		System.out.println("--------headerdata-----------------------------");

		List<WebElement> headerlist = driver.findElements(By.xpath("//table[@class='data-table1']/thead/tr/th"));
		for (WebElement eles1 : headerlist) {
			System.out.println(eles1.getText());
		}
		System.out.println("--------contentdata-----------------------------");

		List<WebElement> contentlist = driver.findElements(By.xpath("//table[@class='data-table1']/tbody/tr/td"));
		for (WebElement eles2 : contentlist) {
			System.out.println(eles2.getText());
		}

	}

	@Test(dependsOnMethods = "getUMtabledata")
	public void editdata() throws InterruptedException {
		// driver.findElement(By.id("search")).sendKeys("java");

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//*[@data-icon='pen-to-square'])[5]"))).click().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//button[text()='Yes, edit it!']"))).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("divyavani");
		
		driver.findElement(By.xpath("(//input[@type='email'])")).sendKeys("admin@test.com");
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("345");
		Thread.sleep(2000);

		action.moveToElement(driver.findElement(By.xpath("//button[@type='submit']"))).click().perform();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		// action.moveToElement(driver.findElement(By.xpath("//button[text()='Cancel']"))).click().perform();

		// Thread.sleep(2000);
		// driver.navigate().back();
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = "editdata")
	public void blocknddelete() throws InterruptedException {
		driver.findElement(By.xpath("(//*[@class='svg-inline--fa fa-ban block'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		// driver.findElement(By.xpath("//button[text()='No, cancel!']")).click();
		System.out.println("successfully blocked");
		System.out.println("=============================");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Delete'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click();
		WebElement delete = driver.findElement(By.xpath("//button[text()='OK']"));
		// driver.findElement(By.xpath("//button[text()='No, cancel!']")).click();

		if (delete.isDisplayed()) {
			delete.click();
			System.out.println("successfully deleted");
			System.out.println("===============================");

		}

	}

	@Test(dependsOnMethods = "blocknddelete")
	public void details() throws InterruptedException {
		driver.findElement(By.xpath("(//a[@class='user-details'])[1]")).click();
		Thread.sleep(2000);
		WebElement image = driver.findElement(By.xpath("//img[@class='sidebar-image']"));
		if (image.isDisplayed()) {
			System.out.println("image is visible");
			System.out.println("============================");
		}
		Thread.sleep(2000);
		Actions acting = new Actions(driver);

		WebElement upload = driver.findElement(By.xpath("//label[@class='sidebar-camera-icon']"));
	System.out.println(	upload.isDisplayed());
	System.out.println("----------------------------");
		//upload.sendKeys("C:\\\\Users\\\\user\\\\Pictures\\\\Screenshots");
		System.out.println("Details menu list");
		System.out.println("===================================");
		List<WebElement> detailsmenulist = driver.findElements(By.xpath("//div[@class='sidebar-menu']"));
		for (WebElement ele11 : detailsmenulist) {
			System.out.println(ele11.getText());
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='menu-item active']")).click();
		Thread.sleep(2000);
		WebElement profile=driver.findElement(By.xpath("//*[text()=' Payments']"));
		profile.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()=' Ride History']")).click();
		Thread.sleep(2000);
		System.out.println("=============================");

		List<WebElement> ridetable=driver.findElements(By.xpath("//table[@class='ride-details-table']/thead/tr/th"));

		for(WebElement header:ridetable) {
			System.out.println(header.getText());
		}
		List<WebElement> ridetablecontent=driver.findElements(By.xpath("//table[@class='ride-details-table']/tbody/tr/td"));

		for(WebElement headercontent:ridetablecontent) {
			System.out.println(headercontent.getText());
		}
		
		driver.findElement(By.xpath("//*[text()=' Ratings']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()=' Options']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()=' Complaints']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("")).click();

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
