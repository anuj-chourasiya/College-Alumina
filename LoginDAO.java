package test;
import java.sql.*;
import javax.servlet.*;
public class LoginDAO {
	public boolean x;
	public boolean validate(String user,String pass)
	{
		try {
			Connection con=DBConnection.getCon();
			
			PreparedStatement ps=con.prepareStatement("select * from reg where uname=? and pword=?");
			ps.setString(1,user);
			ps.setString(2,pass);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					x=true;
					
				}	
				
		}catch(Exception e)
		{
		e.printStackTrace();
		}
		return x;
	}
	

}
