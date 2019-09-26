package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             PrintWriter pw=response.getWriter();
             response.setContentType("text/html");
             String user=request.getParameter("uname");
             String pass=request.getParameter("pword");
                  LoginDAO ld=new LoginDAO();
        boolean k=ld.validate(user,pass);
        if(k)
        {
            Cookie ck=new Cookie("UName",user);
            response.addCookie(ck);
            pw.println("Welcome User:"+user+"<br>");
            RequestDispatcher rd=request.getRequestDispatcher("Filter.html");
            rd.include(request,response);
        }
        else
        {
            pw.println("Invalid username or Password<br>");
            RequestDispatcher rd=request.getRequestDispatcher("Login.html");
            rd.include(request,response);
        }
        
        }
    }

 
