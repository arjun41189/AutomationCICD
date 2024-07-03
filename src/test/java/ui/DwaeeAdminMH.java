package ui;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DwaeeAdminMH 
{
	public static String browser = "chrome"; // External configuration - XLS, CSV or DB
	public static  WebDriver driver;
	
	@Test
	public void Dwaee() throws InterruptedException
	{
		if (browser.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if (browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		else
		{
			System.out.println("browser not specified, pls specify a browser");
		}
		
		driver.manage().window().maximize();
		driver.get("https://admin.dev.dwaae.com/login");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("email")).sendKeys("admin@shopizer.com");
		driver.findElement(By.name("password")).sendKeys("Anatomy@1");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		Thread.sleep(3000);
		
		// Create instance of Javascript executor
        JavascriptExecutor je = (JavascriptExecutor) driver;
        //Identify the WebElement which will appear after scrolling down
        WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Management Hub']"));
        // now execute query which actually will scroll until that element is not appeared on page.
        je.executeScript("arguments[0].scrollIntoView(true);",element);
        // Extract the text and verify
        System.out.println(element.getText());
		
		driver.findElement(By.xpath("//span[normalize-space()='Management Hub']")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Insurance")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Fee")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Time")).click();
		Thread.sleep(5000);
				
		driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
		Thread.sleep(2000);
		driver.close();
		
	}

}