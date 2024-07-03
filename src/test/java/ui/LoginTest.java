package ui;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest 
{
	public static String browser = "chrome"; // External configuration - XLS, CSV or DB
	public static  WebDriver driver;
	
	@Test
	public void LoginDashboard() throws InterruptedException, IOException
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
		Thread.sleep(5000);
		driver.findElement(By.linkText("Stores")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Customer")).click();
		Thread.sleep(5000);
		
		Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();    //Page Down
        //System.out.println("Scroll down performed");
        
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
//        TakesScreenshot ts = (TakesScreenshot)driver;
//        File srcFile = (File)ts.getScreenshotAs(OutputType.FILE);
//        String timeStamp = (new SimpleDateFormat("_ddMMyyyy_hhmmss")).format(new Date());
        //        String fileName = "IMG" + timeStamp + ".png";
//        FileUtils.copyFile(srcFile, new File("C:\\Users\\arjun\\Downloads\\selenium_workshop\\screenshots\\" + fileName));

        // Create instance of Javascript executor
        JavascriptExecutor je = (JavascriptExecutor) driver;
        //Identify the WebElement which will appear after scrolling down
        WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Orders']"));
        // now execute query which actually will scroll until that element is not appeared on page.
        je.executeScript("arguments[0].scrollIntoView(true);",element);
        // Extract the text and verify
        //System.out.println(element.getText());
		
		driver.findElement(By.xpath("//span[normalize-space()='Orders']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[normalize-space()='Prescription']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/div/div[2]/div/div[1]/div[2]/div/div/div/div/nav/ul/li[8]/a")).click();
		Thread.sleep(5000);
		
		act.sendKeys(Keys.PAGE_UP).build().perform();        //Page Up
		//System.out.println("Scroll up performed");
        
		// Create instance of Javascript executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Identify the WebElement which will appear after scrolling down
        WebElement element1 = driver.findElement(By.xpath("//span[normalize-space()='Dashboard']"));
        // now execute query which actually will scroll until that element is not appeared on page.
        js.executeScript("arguments[0].scrollIntoView(true);",element1);
        // Extract the text and verify
        //System.out.println(element1.getText());
		
		driver.findElement(By.xpath("//span[normalize-space()='Dashboard']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
		Thread.sleep(2000);
		
		driver.close();
		
	}

}