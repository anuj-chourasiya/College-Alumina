package test;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class XpDAO {
    public int k;
	public int register(XpBean xp)
	{
		try 
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into xpdetail values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,xp.getUname());
			ps.setString(2,xp.getPword());
			ps.setString(3,xp.getFname());
			ps.setString(4, xp.getLname());
			ps.setString(5,xp.getAddr());
			ps.setLong(6,xp.getPhno());
			ps.setString(7,xp.getMid());
                        ps.setString(8,xp.getBranch());
                        ps.setString(9,xp.getCname());
			ps.setInt(10,xp.getPckg());
			ps.setString(11,xp.getCaddr());
			ps.setString(12, xp.getCdis());
			ps.setInt(13,xp.getGcy());
                        ps.setBlob(14,xp.getIs());
            
			
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
}
}
