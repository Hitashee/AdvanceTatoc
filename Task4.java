package advance;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Task4 {
	WebDriver task4()
	{
		Task3 t2=new Task3();
		WebDriver driver= t2.task3();
		System.out.println("Task 4");
		String string=driver.findElement(By.id("session_id")).getText();
	    string=string.substring(12, string.length());
	   
	   
	    System.out.println(string);
	    try{
	    URL url = new URL("http://10.0.1.86/tatoc/advanced/rest/service/token/"+string);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		System.out.println(response.toString());
		String ssss=new String(response);
		
		JSONObject obj=new JSONObject(ssss);
		ssss=(String) obj.get("token");

		System.out.println(ssss);
		
		//post
		
		URL url1 = new URL("http://10.0.1.86/tatoc/advanced/rest/service/register");
		HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
		

		conn1.setRequestMethod("POST");
		
		conn1.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "id="+string+"&signature="+ssss+"&allow_access=1";
		
		// Send post request
		conn1.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(conn1.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = conn1.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		
		conn1.disconnect();
		driver.findElement(By.cssSelector(".page a")).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return driver;
	}

}
