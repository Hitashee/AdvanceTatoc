package advance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task2 {
	WebDriver task2()
	{
		Task1 t1=new Task1();
		WebDriver driver= t1.task1();
		System.out.println("Task2");
		String symbol= driver.findElement(By.cssSelector("#symboldisplay")).getText();
		PreparedStatement pstmt= null;
		String id=null;
		String name=null;
		String passkey= null;
		try{
				DBConnection db= new DBConnection();
				Connection con=db.dbConn();
		        pstmt= con.prepareStatement("select id from identity where symbol=?;");
		        pstmt.setString(1, symbol);
		        ResultSet rs=pstmt.executeQuery();  
		        while(rs.next()){  
		        	id=rs.getString("id");
		        	System.out.println(id);
		         }  
		         int identity= Integer.parseInt(id);
				 rs.close();
				 pstmt.close();
				 pstmt= con.prepareStatement("select name,passkey from credentials where id=?;");
				 pstmt.setInt(1, identity);
				 rs= pstmt.executeQuery();
				 if(rs.next()){
						name= rs.getString("name");
						passkey= rs.getString("passkey");
						System.out.println("Name="+name+"  Passkey="+passkey);
		    	 }
		                if (con != null) {
		          		con.close();
		                }
		
		   }
			catch(Exception e){  e.printStackTrace();}
		    driver.findElement(By.id("name")).sendKeys(name);
		    driver.findElement(By.id("passkey")).sendKeys(passkey);
		    driver.findElement(By.cssSelector("#submit")).click();
		    
		return driver;
	}
		

}
