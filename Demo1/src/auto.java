import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class auto {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("inputUsername")).sendKeys("ankit");
		driver.findElement(By.name("inputPassword")).sendKeys("raj");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.name("chkboxTwo")).click();
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector(".error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("rahul@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("987898");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.cssSelector("button[class*='go-to-login']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@id,'Username')]")).sendKeys("rahul");
		driver.findElement(By.xpath("//input[contains(@name,'Password')]")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".signInBtn")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.close();
	}

}
