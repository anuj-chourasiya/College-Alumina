package test;
import java.sql.*;

public class DBConnection {
	private static Connection con;
	
		static {
			try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","anuj","Anuj@oo7");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	           }
		public static Connection getCon()
		{
			return con;
		}
	

}
