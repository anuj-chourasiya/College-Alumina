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

@WebServlet("/DisServlet")
public class DisServlet extends GenericServlet {
	public RegBean rb;
	public ServletContext sct;
	public void init() throws ServletException {
		sct=this.getServletContext();
		rb=(RegBean)sct.getAttribute("beanRef");
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		pw.println("-----RegDetails-------");
		pw.println("UserName:"+rb.getUname());
		pw.println("<br>PassWord:"+rb.getPword());
		pw.println("<br>FirstName:"+rb.getFname());
		pw.println("<br>LastName:"+rb.getLname());
		pw.println("<br>Address:"+rb.getAddr());
		pw.println("<br>PhoneNo:"+rb.getPhno());
		pw.println("<br>MailId:"+rb.getMid());
                pw.println("<br>Branch:"+rb.getBranch());
		pw.println("<br>");
		pw.println("<form action='final' method='post'>");
		pw.println("<input type='submit' value='Register'>");
		pw.println("</form>");
		
	}

}
