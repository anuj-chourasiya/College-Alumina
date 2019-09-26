
package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TempServlet extends HttpServlet {

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String name=request.getParameter("param");
      
       HttpSession session = request.getSession();
      session.setAttribute("Name",name);
      RequestDispatcher rds=request.getRequestDispatcher("dp.jsp");
      rds.forward(request, response);

      
        }
    }


