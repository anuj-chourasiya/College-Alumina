package test;
import javax.servlet.*;



import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/FinalRegServlet")
public class FinalRegServlet extends GenericServlet {
	

	public RegBean rb;
	public ServletContext sct;
	public void init() throws ServletException {
		sct=this.getServletContext();
		rb=(RegBean)sct.getAttribute("beanRef");
		
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		RegisterDAO rd=new RegisterDAO();
	int k=rd.register(rb);
	if(k>0)
	{
		pw.println("User Registered Successfully!!!!");
		RequestDispatcher rds=request.getRequestDispatcher("Login.html");
		rds.include(request,response);
	}
        else
        {
            pw.println("not added in db");
        }
	}

}
