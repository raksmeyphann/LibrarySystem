package ckccmaven.library;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String jdbcUrl = "jdbc:mysql://localhost:3306/library?useSSL=false";
        String user ="root";
        String pwd="";
        try {
			System.out.println("connect to database:"+jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pwd);
			System.out.println("Connection Successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
