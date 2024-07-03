package com.view;

	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;


	@WebServlet("/LoginController")

	public class LoginController extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        if (validate(username, password)) {
	            response.sendRedirect("/success.jsp");
	        } else {
	            request.setAttribute("message", "Invalid username or password");
	            request.getRequestDispatcher("/index.jsp").forward(request, response);
	        }
	    }

	    private boolean validate(String username, String password) {
	        boolean status = false;
	        Connection conn = null;
	        PreparedStatement pst = null;
	        ResultSet rs = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/courier", "root", "root");
	            pst = conn.prepareStatement("SELECT * FROM Customers WHERE username=? AND password=?");
	            pst.setString(1, username);
	            pst.setString(2, password);

	            rs = pst.executeQuery();
	            status = rs.next();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (pst != null) pst.close();
	                if (conn != null) conn.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return status;
	    }
	}