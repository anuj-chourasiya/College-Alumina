package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FilterServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           PrintWriter pw=response.getWriter();
          pw.println("<style>"
                  + "#heading\n" +
"	{\n" +
"	 background:#0080FF;\n" +
"	 color:white;\n" +
"	 padding:50px;\n" +
"	 font-size:60px;\n" +
"	 text-shadow: 8px 8px 20px black;\n" +
"	\n" +
"	 }\n" +
" #logo\n" +
"	 {\n" +
"	  \n" +
"	  }\n" +
"  #navigation\n" +
"		 {\n" +
"		  position:relative;\n" +
"		  right:20px;\n" +
"		  bottom:100px;\n" +
"		  }\n" +
"#subhead\n" +
"		{\n" +
"		 background:#6ACFFF;\n" +
"		 width:100%;\n" +
"		 padding:10px;\n" +
"		 font-size:30px;\n" +
"		 text-align:center;\n" +
"		 \n" +
"		 }\n" +
"ul{\n" +
"	  	 margin:0px;\n" +
"		 padding:0px;\n" +
"		 list-style:none;\n" +
"	   }\n" +
"	 ul li{\n" +
"	 	float:left;\n" +
"		width:260px;\n" +
"		height:40px;\n" +
"		background-color:#0080FF;\n" +
"		opacity:10;\n" +
"		line-height:40px;\n" +
"		text-align:center;\n" +
"		font-size:20px;\n" +
"		margin-right:2px;\n" +
"	  }\n" +
"	  ul li a{\n" +
"	  	 text-decoration:none;\n" +
"		 color:white;\n" +
"		 display:block;\n" +
"		 overflow:hidden;\n" +
"	   }\n" +
"	  ul li a:hover{\n" +
"	  	 background:white;\n" +
"		 color:#0080FF;\n" +
"		 \n" +
"		 \n" +
"		 \n" +
"	   }\n" +
"	   ul li ul li{\n" +
"	   display:none;\n" +
"	    }\n" +
"		ul li:hover ul li{\n" +
"		display:block;\n" +
"        \n" +
"		\n" +
"		 }</style>");
           response.setContentType("text/html");
           pw.println(" <body> <section>\n" +
"  <header id=\"header\">\n" +
"  <h1 align=\"left\" id=\"heading\"> Indira Gandhi Engineering College\n" +
"  <img id=\"logo\" align=\"right\" src=\"collegelogo\" /></h1>\n" +
"  <h3 id=\"subhead\" ><b>College Alumni Management </h3>\n" +
"  <div id=\"navigaton\" role=\"navigation\">\n" +
"  <ul>\n" +
"  <li><a href=\"home.html\">HOME</a></li>\n" +
"  <li><a href=\"profile filter.html\">PROFILE</a></li>\n" +
"  <li><a href=\".html\">CONTACT</a></li>\n" +
"  <li><a href=\".html\">ABOUT US</a></li>\n" +
"  <li><a href=\"Login.html\">LOGIN</a></li>\n" +
"  \n" +
"  </li>\n" +
"  </ul>\n" +
"  </div>\n" +
"  </header>\n" +
" \n" +
" </section> </body>");
           pw.println("<style> .footer {\n" +
"    position: fixed;\n" +
"   left: 0;\n" +
"   bottom: 0;\n" +
"   width: 100%;\n" +
"   height: 7%;\n" +
"   background-color:rgba(128,128,128,0.9);\n" +
"   color: white;\n" +
"   text-align: center;\n" +
"   font-size:25px;\n" +
"   padding: 10px;\n" +
"            }</style>");
           pw.println("<body>  <div class=\"footer\">\n" +
"  <p><em>Copyrights &copy; 2019</em></p>\n" +
"</div></body>");
           int gcy=Integer.parseInt(request.getParameter("gcy"));
           String branch=request.getParameter("branch");
           Connection con=DBConnection.getCon();
           try{
               PreparedStatement ps=con.prepareStatement("select fname,lname,gcy,branch from xpdetail where gcy='"+gcy+"'and branch='"+branch+"'");
               ResultSet rs=ps.executeQuery();
               while( rs.next())
               {
                 pw.println("<br>");
                  pw.println(rs.getString(1)+"\t"
                   +rs.getString(2)+"\t"
                   +rs.getInt(3)+"\t"
                   +rs.getString(4));
             pw.println("<a href='http://localhost:8084/College_Alumina/temp?param="+rs.getString(1)+"'>view profile</a>");
               }
              
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }
    }
}

 