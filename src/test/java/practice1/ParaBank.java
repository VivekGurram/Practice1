package practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParaBank

{
		
		WebDriver driver = new ChromeDriver();	
		
		@Test(priority=1)
		public void launchurl()
		{
			driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
		}
		
		@Test(priority=2, dependsOnMethods= {"launchurl"})
		public void login()
		{
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("vivek");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("vivek@123");
			driver.findElement(By.xpath("//input[@value='Log In']")).click();
			boolean a = driver.findElement(By.xpath("//p[@class='smallText']")).isDisplayed();
			System.out.println(a); 
			if(a==true)
			{
				Assert.assertTrue(true);
			}
			else {
				Assert.fail();
			}
		}
		
		@Test(priority=3, dependsOnMethods= {"login"})
		public void logout() throws InterruptedException
		{
		 
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='leftPanel']//following-sibling::li)[1]")).click();
		
		//driver.findElement(By.xpath("//div[@id='leftPanel']//following-sibling::li[8]")).click();
		}
		
	}
	

