package advance;

import java.io.BufferedReader;
import java.io.FileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task5 {

	void task5()
	{
		Task4 t2=new Task4();
		WebDriver driver= t2.task4();
		System.out.println("Task 5");
	    driver.findElement(By.linkText("Download File")).click();
	    String line = "",s="";  
	    try{
	    	FileReader fileReader = new FileReader("/home/hitasheesil/Downloads/file_handle_test.dat");  
	        BufferedReader bufferedReader = new BufferedReader(fileReader);  
	        while ((line = bufferedReader.readLine()) != null)   
	        {  
	            s=line; 
	        }  
	        String strng1 = s.substring(11);
		    System.out.println(strng1);
	        driver.findElement(By.id("signature")).sendKeys(strng1);
	        driver.findElement(By.className("submit")).click();
	        bufferedReader.close();
	    }
	    catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
