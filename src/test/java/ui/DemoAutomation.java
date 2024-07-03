package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoAutomation 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		//FirefoxDriver driver = new FirefoxDriver();
		//EdgeDriver driver = new EdgeDriver();
		driver.get("http://www.ebay.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("mobile");
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		driver.close();
	}

}
