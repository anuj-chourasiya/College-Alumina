package test;
import java.io.*;
import javax.servlet.*;
import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/RegServlet1")
public class RegServlet1 extends GenericServlet {
	public RegBean rb;
	public ServletContext sct;
	public void init() throws ServletException {
		rb=new RegBean();
		sct=this.getServletContext();
		
		
	}

	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	String uname=req.getParameter("uname");
	String pword=req.getParameter("pword");
	String fname=req.getParameter("fname");
	String lname=req.getParameter("lname");
     rb.setUname(uname);
	rb.setPword(pword);
	rb.setFname(fname);
	rb.setLname(lname);
	sct.setAttribute("beanRef",rb);
	RequestDispatcher rd=req.getRequestDispatcher("Register2.html");
	rd.forward(req,res);
	
	
	
     
	
	
	}

}
