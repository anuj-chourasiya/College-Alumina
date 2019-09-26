package test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215)
public class XpDetailsServlet extends HttpServlet {

public XpBean xp;
	public ServletContext sct;
	public void init() throws ServletException {
		sct=this.getServletContext();
		xp=(XpBean)sct.getAttribute("beanRef");
		
		
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
      	
        PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
        String cname=request.getParameter("cname");
        System.out.println(cname);
         Integer pckg=Integer.parseInt(request.getParameter("pckg"));
          String caddr=request.getParameter("caddr");
           String cdis=request.getParameter("cdis");
            Integer gcy=Integer.parseInt(request.getParameter("gcy"));
               InputStream inputStream = null;
        Part filePart = request.getPart("photo");
         if(filePart != null) {
           System.out.println(filePart.getName());
             System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
           inputStream = filePart.getInputStream();
        }
   xp.setCname(cname);
          xp.setPckg(pckg);
          xp.setCaddr(caddr);
          xp.setCdis(cdis);
          xp.setGcy(gcy);
          xp.setIs(inputStream);
      
         	XpDAO rd=new XpDAO();
	int k=rd.register(xp);
        System.out.println(k);
	if(k>0)
	{
	pw.println("User Registered Successfully!!!!");
		RequestDispatcher rds=request.getRequestDispatcher("Login.html");
		rds.include(request,response);
		
	}
        else
        {
            pw.println("not added in ");
        }
        }
    }


