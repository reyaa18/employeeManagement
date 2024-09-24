package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	 public static Connection connectWithDb(){
		 Connection con=null;
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db3","username","password");
				return con;
			 }
			 catch(ClassNotFoundException e) {
				 System.out.println(e);
			 }
			 	
			catch(SQLException e) {
				System.out.println(e);
			}
		 	return con;
	 } 

}