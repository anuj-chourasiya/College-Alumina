package test;
import java.sql.*;
import javax.servlet.*;
public class LoginDAO {
	public boolean x;
	public boolean validate(String uname,String pword)
	{
		try {
			Connection con=DBConnection.getCon();
			
			PreparedStatement ps=con.prepareStatement("SELECT uname,pword FROM reg UNION ALL SELECT uname,pword from xpdetail where uname=? and pword=?");
			ps.setString(1,uname);
			ps.setString(2,pword);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					x=true;
                                        System.out.println(x);
					
				}	
				
		}catch(Exception e)
		{
		e.printStackTrace();
		}
		return x;
	}
	

}
