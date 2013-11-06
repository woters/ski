package com.back;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.sql.*;

import javax.sql.*;
import javax.naming.*;

/**
 * Servlet implementation class Connection
 */
@WebServlet("/Conn")
public class Conn extends HttpServlet {
	
//	 public void doGet(HttpServletRequest request,
//             HttpServletResponse response)
//throws ServletException, IOException {
//PrintWriter out = response.getWriter();
//out.println("Hello World");
//}
	InitialContext ctx = null;
	  DataSource ds = null;
	  Connection conn = null;
	  PreparedStatement ps = null;
	  ResultSet rs = null;
	  Statement stmt = null;

	  String sql = "Select * from test.BuyT;";

	  public void init () throws ServletException {
	   
	  }

	  public void destroy () {
	    try {
	      if (rs != null)
	        rs.close();
	      if (ps != null)
	        ps.close();
	      if (conn != null)
	        conn.close();
	      if (ctx != null)
	        ctx.close(); 
	    }     
	    catch (SQLException se) {
	      System.out.println("SQLException: "+se.getMessage());
	    }
	    catch (NamingException ne) {
	      System.out.println("NamingException: "+ne.getMessage());  
	    }  
	  }

	  public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		  
		  
	   
	
		  
		  
		  
		  
	   
	//    } 
	    /*	String name1 = null;
		    Statement stmt = null;
		    String query = "select * from test.BuyT";
		    try {
		    	ctx = new InitialContext();
			      ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysqltest");
			      conn = ds.getConnection();
		        stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery(query);
		        while (rs.next()) {
		            //String coffeeName = rs.getString("COF_NAME");
		            int idBuyT = rs.getInt("idBuyT");
		            //float price = rs.getFloat("PRICE");
		            //int sales = rs.getInt("SALES");
		            //int total = rs.getInt("TOTAL");
		            String Phone = rs.getString("Phone");
		            name1 = name1 + idBuyT + " " + Phone + "/n";
		        }
		    } catch (SQLException e ) {
		    	System.out.println("SQLException: "+e.getMessage());
		    } catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
		        if (stmt != null) { try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} }
		    }
		    resp.setContentType("text/html");
		      PrintWriter writer = resp.getWriter();
		      writer.println(name1);*/
		    //out.name1;	

	    	
	 }

	  public void doGet(HttpServletRequest req, HttpServletResponse resp){
		  
		  try {  
		    String name1 = null;
		  resp.setContentType("text/html");
	      PrintWriter writer = resp.getWriter();
		  InitialContext ctx = new InitialContext();
          //The JDBC Data source that we just created
          DataSource ds = (DataSource) ctx.lookup("mysqltest");
          Connection connection = ds.getConnection();

          if (connection == null)
          {
              throw new SQLException("Error establishing connection!");
          }
          String query = "SELECT * FROM test.BuyT";

          PreparedStatement statement = connection.prepareStatement(query);
          ResultSet rs = statement.executeQuery();

          while (rs.next())
          {
              name1=name1+rs.getString("name");
          }
		   
          writer.println("<html><body>");
	      writer.println("<p>Hello from servlet doGet()</p>"+name1);
	      writer.println("</body></html>");
	      
	      writer.close(); 
		  
		  
		  
		  
		  
		  
		  
		  
		  
	
		/*  try { 
	    	
	    	 try {
	   	      ctx = new InitialContext();
	   	      ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysqltest");
	   	      conn = ds.getConnection();
	   	      stmt = conn.createStatement();
	   	//      ps = conn.prepareStatement(sql);
	   	    }
	   	    catch (SQLException se) {
	   	      System.out.println("SQLException: "+se.getMessage());
	   	    }
	   	    catch (NamingException ne) {
	   	      System.out.println("NamingException: "+ne.getMessage());  
	   	    }  
	    	
	    	 ResultSet rs = stmt.executeQuery(sql);
		        while (rs.next()) {
		            //String coffeeName = rs.getString("COF_NAME");
		            int idBuyT = rs.getInt("idBuyT");
		            //float price = rs.getFloat("PRICE");
		            //int sales = rs.getInt("SALES");
		            //int total = rs.getInt("TOTAL");
		            String Phone = rs.getString("Phone");
		            name1 = name1 + idBuyT + " " + Phone + "/n";
	    	
	    	
	    	 
	    	 
	    	 
	    	 
	    	 
	    	
	    	
	    	
	    	
	     
	      this.init();
	      this.doPost(req, resp);
	    
		        }*/
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }  
	  }
}
