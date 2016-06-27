package advance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static Connection con = null;
    static String DB_URL = "jdbc:mysql://10.0.1.86:3306/tatoc";
    static String DB_USER = "tatocuser";
    static String DB_PASSWORD = "tatoc01";
    Connection dbConn() throws ClassNotFoundException, SQLException
    {
    	Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        System.out.println("Database Coonection successful");
        return con;
    }

}
