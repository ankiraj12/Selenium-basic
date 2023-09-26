import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flightbooking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
     
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//1.Select Static Dropdown
		
		WebElement staticDrop=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropDown=new Select(staticDrop);
		dropDown.selectByIndex(3);
		System.out.println(dropDown.getFirstSelectedOption().getText());
		
		//2.Handling Updated dropDown
		
		driver.findElement(By.cssSelector(".paxinfo")).click();
		Thread.sleep(3000);
		for(int i=0;i<3;i++)
		{
			driver.findElement(By.cssSelector("#hrefIncChd")).click();
		}
		
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		System.out.println(driver.findElement(By.cssSelector(".paxinfo")).getText());
		
		//3.Handling Dynamic dropdown
		
		driver.findElement(By.xpath("//input[contains(@id,'originStation1')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(@id,originStation1)] //a[@value='PNQ']")).click();
		driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click();
		
		//4.Handling Autosuggestive dropdown
		
		driver.findElement(By.id("autosuggest")).sendKeys("IND");
		List<WebElement> options=driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
			option.click();
			break;
			}
		}
		
		//5.Handling checkbox
		
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		driver.findElement(By.xpath("//input[contains(@id,'Student')]")).click();
		
		//6.Handling Radio button
		driver.findElement(By.xpath("//input[@value='RoundTrip']")).click();
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("it's enabled");
		}
		
		//7.Handling Calendar
		//driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		driver.close();
		
	}

}
