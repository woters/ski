package com.back;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Sell
 */
@WebServlet("/sell")
public class Sell extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(Sell.class
			.getName());

	InitialContext ctx = null;
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	String sql = "INSERT INTO test.buyt values( ";

	public void init() throws ServletException {
		try {
			// logger.info("init start");
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("jdbc/_My3");
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
			String price = req.getParameter("price");
			String date1 = req.getParameter("date1");
			String date2 = req.getParameter("date2");
			String phone = req.getParameter("phone");
			String name = req.getParameter("name");
			logger.info(date1);
			logger.info(date2);
			int id = (int) System.currentTimeMillis();
			ps = conn.prepareStatement(sql+"Date1 = '"+date1+"'" + "and Date2 = "+"'"+date2+"'");
//			ps = conn.prepareStatement("select * from test.buyt where Date1 = '2001-01-03' and Date2 = '2001-01-04'");
			resp.setContentType("text/html");
			PrintWriter writer = resp.getWriter();
			writer.println("<html><body>");
			rs = ps.executeQuery();
			logger.info("msg");
			while (rs.next()) {
				logger.info(rs.toString());
				writer.println("<p>Name: " + rs.getString("Name") + "</p>");
				writer.println("<p>Phone: " + rs.getString("Phone") + "</p>");
			}
			writer.println("</body></html>");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {

			resp.setContentType("text/html");
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