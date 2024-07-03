package com.cont;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");

	        
	        String firstName = request.getParameter("first-name");
	        String lastName = request.getParameter("last-name");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        Connection conn = null;
	        PreparedStatement stmt = null;

	        try {
	          
	            Class.forName("com.mysql.cj.jdbc.Driver");

	           
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");

	          
	            String sql = "INSERT INTO users (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
	            stmt = conn.prepareStatement(sql);

	          
	            stmt.setString(1, firstName);
	            stmt.setString(2, lastName);
	            stmt.setString(3, email);
	            stmt.setString(4, password);

	     
	            int rowsAffected = stmt.executeUpdate();

	            // Dummy response for demonstration
	            PrintWriter out = response.getWriter();
	            out.println("<html>");
	            out.println("<head><title>Sign Up Result</title></head>");
	            out.println("<body>");
	            out.println("<h2>Sign Up Successful</h2>");
	            out.println("<p>First Name: " + firstName + "</p>");
	            out.println("<p>Last Name: " + lastName + "</p>");
	            out.println("<p>Email: " + email + "</p>");
	            out.println("</body>");
	            out.println("</html>");

	        } catch (SQLException | ClassNotFoundException ex) {
	            ex.printStackTrace();
	            // Handle errors
	            // For simplicity, in a real application, you would redirect to an error page or handle appropriately
	        } finally {
	            // Clean-up resources
	            try {
	                if (stmt != null) stmt.close();
	                if (conn != null) conn.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
}