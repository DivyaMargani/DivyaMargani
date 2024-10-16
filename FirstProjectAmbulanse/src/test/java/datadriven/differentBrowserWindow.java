package datadriven;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class differentBrowserWindow {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		String firsttab=driver.getWindowHandle();
		System.out.println(firsttab);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.bing.com/");
		Set<String> allwindows=driver.getWindowHandles();
		for(String handle:allwindows) {
			if(!handle.equals(firsttab)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();
        driver.switchTo().window(firsttab);
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("Selenium WebDriver");
        googleSearchBox.submit();
        driver.quit();
		

	}

}
