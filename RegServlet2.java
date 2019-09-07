package test;

import java.io.IOException;
import java.io.*;
import javax.servlet.*;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class RegServlet2
 */
@WebServlet("/RegServlet2")
public class RegServlet2 extends GenericServlet {
	public RegBean rb;
	public ServletContext sct;


	
	public void init() throws ServletException {
		sct=this.getServletContext();
		rb=(RegBean)sct.getAttribute("beanRef");
	
	}

	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String addr=req.getParameter("addr");
		Long phno=Long.parseLong(req.getParameter("phno"));
		String mid=req.getParameter("mid");
                String branch=req.getParameter("branch");
		rb.setAddr(addr);
		rb.setPhno(phno);
		rb.setMid(mid);
                rb.setBranch(branch);
		pw.println("your registration details are valid <br>");
		pw.println("<a href='dis'>CLICK</a>");
		pw.println("to view registration details");
		
		
	}

}
