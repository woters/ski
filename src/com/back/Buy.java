package com.back;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.google.gson.Gson;

//import net.sf.json.JSONArray;

@WebServlet("/buy")
public class Buy extends HttpServlet {
	static final Logger logger = Logger.getLogger(Buy.class
			.getName());

	InitialContext ctx = null;
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	String sql = "SELECT Name, Phone, price, Date1, Date2, SkiNum FROM test.buyT1 where ";

	public void init() throws ServletException {
		try {
			// logger.info("init start");
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("jdbc/_my");
			// logger.info("init end");
		}
		catch (NamingException ne) {
			logger.info("NamingException: " + ne.getMessage());
		}
	}

	public void destroy() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
			if (ctx != null)
				ctx.close();
		} catch (SQLException se) {
			System.out.println("SQLException: " + se.getMessage());
		} catch (NamingException ne) {
			System.out.println("NamingException: " + ne.getMessage());
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			logger.info("msg");
			conn = ds.getConnection();
			String date1 = req.getParameter("date1");
			String date2 = req.getParameter("date2");
			logger.info(date1);
			logger.info(date2);
			ps = conn.prepareStatement(sql+"Date1 <= '"+date1+"'" + "and Date2 >= "+"'"+date2+"'");
//			ps = conn.prepareStatement("select * from test.buyt where Date1 = '2001-01-03' and Date2 = '2001-01-04'");
			resp.setContentType("application/json; charset=UTF-8");
//			
			Gson gson = new Gson();
			rs = ps.executeQuery();
			logger.info("msg");
			String response = "{ \"AvaleiblePasses\": [";
			int i = 0;
			while (rs.next()) {
				if (i != 0)  response = response + ", ";
				i++;
				logger.info(rs.toString());
				response = response + "{ \"Name\":\""+rs.getString("Name")+"\", \"Phone\":\""+rs.getString("Phone")+
						"\", \"price\":\""+rs.getString("price")+
						"\", \"Date1\":\""+rs.getString("Date1")+
						"\", \"Date2\":\""+rs.getString("Date2")+"\"}";
			}
			response = response +"]}";
			logger.info(date1 + " "+ date2 + "  "+response);
			PrintWriter writer = resp.getWriter();
			writer.write(response);
		//	writer.print(response);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {

//			resp.setContentType("text/html");
			resp.setContentType("application/json; charset=UTF-8");
			logger.info("after post");
			PrintWriter writer = resp.getWriter();
			this.doPost(req, resp);
			logger.info("after post");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}