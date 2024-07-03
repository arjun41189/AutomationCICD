package ui;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DwaeeAdminUsers 
{
	public static String browser = "chrome"; // External configuration - XLS, CSV or DB
	public static  WebDriver driver;
	
	@Test
	public void Users() throws InterruptedException, IOException
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
		
		driver.findElement(By.linkText("Users")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("firstName")).sendKeys("arjun");
		driver.findElement(By.name("lastName")).sendKeys("gowda");
		driver.findElement(By.name("emailAddress")).sendKeys("arjun.p@mindstacksolutions.com");
		
		
		WebElement dropdown = driver.findElement(By.xpath("//div[@class='flex gap-4']//button[@title='Open']//*[name()='svg']//*[name()='path' and contains(@d,'M7 10l5 5 ')]"));
	    dropdown.click();
	    driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/input[1]")).sendKeys("Dwaee");
	    
	    driver.findElement(By.name("password")).sendKeys("Anatomy@1");
		driver.findElement(By.name("repeatPassword")).sendKeys("Anatomy@1");
	    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	    driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/input[1]")).sendKeys("English");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
	    
//		driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
//		Thread.sleep(2000);
//		
//		driver.close();
		
	}

}