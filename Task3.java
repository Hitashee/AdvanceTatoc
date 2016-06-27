package advance;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Task3 {

	WebDriver task3()
	{
		Task2 t2=new Task2();
		WebDriver driver= t2.task2();
		System.out.println("Task 3");
	       try{
	    	   	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	   	js .executeScript("player.play()");
	    	   	System.out.println("Video Playing");
	    	   	Thread.sleep(30000);
	    	   	driver.findElement(By.linkText("Proceed")).click();
	       }
	       catch(Exception e)
	       {
	    	   e.printStackTrace();
	    	   
	       }
	       return driver;
	}
}
