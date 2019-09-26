<%@page import="java.sql.PreparedStatement"%>
<%@page import="test.DBConnection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java"  session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 
 
 Connection con=DBConnection.getCon();


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
               <style>
                         .footer {
   
   left: 0;
   bottom: 0;
   width: 100%;
   background-color:rgba(128,128,128,0.9);
   color: white;
   text-align: center;
   font-size:25px;
   
            }
img {
  border: 1px solid #ddd;
  border-radius: 4px;
  padding: 5px;
  width: 150px;
  height:100px;
}

img:hover {
  box-shadow: 0 0 2px 1px rgba(0, 140, 186, 0.5);
}
#heading
	{
	 background:#0080FF;
	 color:white;
	 padding:50px;
	 font-size:60px;
	 text-shadow: 8px 8px 20px black;
	
	 }
 #logo
	 {
	  
	  }
  #navigation
		 {
		  position:relative;
		  right:20px;
		  bottom:100px;
		  }
#subhead
		{
		 background:#6ACFFF;
		 width:100%;
		 padding:10px;
		 font-size:30px;
		 text-align:center;
		 
		 }
ul{
	  	 margin:0px;
		 padding:0px;
		 list-style:none;
	   }
	 ul li{
	 	float:left;
		width:260px;
		height:40px;
		background-color:#0080FF;
		opacity:10;
		line-height:40px;
		text-align:center;
		font-size:20px;
		margin-right:2px;
	  }
	  ul li a{
	  	 text-decoration:none;
		 color:white;
		 display:block;
		 overflow:hidden;
	   }
	  ul li a:hover{
	  	 background:white;
		 color:#0080FF;
		 
		 
		 
	   }
	   ul li ul li{
	   display:none;
	    }
		ul li:hover ul li{
		display:block;
        
		
		 }
</style>
    </head>
      <section>
  <header id="header">
  <h1 align="left" id="heading"> Indira Gandhi Engineering College
  <img id="logo" align="right" src="img.jpg"  /></h1>
  <h3 id="subhead" ><b>College Alumni Management </h3>
  <div id="navigaton" role="navigation">
  <ul>
  <li><a href="home.html">HOME</a></li>
  <li><a href="profile filter.html">PROFILE</a></li>
  <li><a href=".html">CONTACT</a></li>
  <li><a href=".html">ABOUT US</a></li>
  <li><a href="Login.html">LOGIN</a></li>
  
  </li>
  </ul>
  </div>
  </header>
 
 </section>  
    <body>
        
    <center>
     
        <img src="./profile" style="width:150px" align="left"/>
        <% 
        String name=(String) session.getAttribute("Name");
         PreparedStatement ps=con.prepareStatement("select mid,cname,pckg,cdis,phno from xpdetail where fname='"+name+"'");
               ResultSet rs=ps.executeQuery();
            
                 rs.next();
                  out.println("<br>MailID:"+rs.getString(1)+"\t<br><br>Company Name :"
                   +rs.getString(2)+"\t<br><br>Package(annual) :"
                   +rs.getInt(3)+"\t<br><br>Company Discription: "
                   +rs.getString(4)+"\t<br><br>Phone no: "
                   +rs.getInt(5)
                  );
            
               
        %>

   
          
    </center>
     <div class="footer">
  <p><em>Copyrights &copy; 2019</em></p>
</div>
    </body>
</html>
