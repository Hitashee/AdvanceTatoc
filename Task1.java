package advance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task1 extends GetDriver{
	WebDriver task1()
	{
		WebDriver driver=getDriver();
		System.out.println("Task 1");
		driver.get("http://10.0.1.86/tatoc/advanced/hover/menu");
		WebElement menu=driver.findElement(By.className("menutop"));
		Actions builder = new Actions(driver);   
		builder.moveToElement(menu).build().perform();
		System.out.println("Action performed on Menu");
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div[2]/span[5]")));  
		if(driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/span[5]")).getText().contains("Go Next"))
		{
			driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/span[5]")).click();
			System.out.println("Proceed to next");
			
		}
		return driver;
	}

}
