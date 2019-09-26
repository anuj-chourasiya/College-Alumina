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
	public XpBean xp;
        public RegBean rb;
	public ServletContext sct;
	public void init() throws ServletException {
		xp=new XpBean();
                 rb=new RegBean();
		sct=this.getServletContext();
		
		
	}

	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
            PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
	String uname=req.getParameter("uname");
	String pword=req.getParameter("pword");
	String fname=req.getParameter("fname");
	String lname=req.getParameter("lname");
        String addr=req.getParameter("addr");
	Long phno=Long.parseLong(req.getParameter("phno"));
	String mid=req.getParameter("mid");
        String branch=req.getParameter("branch");
     rb.setUname(uname);
	rb.setPword(pword);
	rb.setFname(fname);
	rb.setLname(lname);
        rb.setAddr(addr);
        rb.setPhno(phno);
		rb.setMid(mid);
                rb.setBranch(branch);
        xp.setUname(uname);
	xp.setPword(pword);
	xp.setFname(fname);
	xp.setLname(lname);
        xp.setAddr(addr);
        xp.setPhno(phno);
        xp.setMid(mid);
        xp.setBranch(branch);
          
		
                  String a=req.getParameter("Graduated");
          System.out.println(a);
          String x="YES";
          if(a.equals(x))
          {
              sct.setAttribute("beanRef",xp);
              RequestDispatcher rd=req.getRequestDispatcher("xp.html");
              rd.forward(req, res);
          }
          else{
               
                         RegisterDAO rdss=new RegisterDAO();
	int k=rdss.register(rb);
	if(k>0)
	{
		pw.println("User Registered Successfully!!!!");
		RequestDispatcher rds=req.getRequestDispatcher("Login.html");
		rds.include(req,res);
	}
         else
        {
            pw.println("not added in db");
        }
            
          }
    
       
	
     
	
	
	}

}
