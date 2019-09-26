
package test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FileDisplay extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
 String name = (String) session.getAttribute("Name");


       
        System.out.println(name);
     
        byte by[]=null;
        ServletOutputStream sos=null;
         String sql="select photo from contacts where first_name='"+name+"'";
          try{
        Connection con=DBConnection.getCon();
          PreparedStatement ps=con.prepareStatement(sql);
          ResultSet rs=ps.executeQuery();
          if(rs.next())
          {
              by=rs.getBytes(1);
              
          }
          sos=response.getOutputStream();
          sos.write(by);
        
          
            
            
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
     
        
        }
    }

   