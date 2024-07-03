package com.cont;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConnectdbServlet
 */
@WebServlet("/ConnectdbServlet")
public class ConnectdbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
		 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        // Handle form submission and process the delivery request
		        response.setContentType("text/html");
		        PrintWriter out = response.getWriter();

		        String fromEmail = request.getParameter("fromEmail");
		        String toEmail = request.getParameter("toEmail");
		        String content = request.getParameter("content");
		        String[] categories = request.getParameterValues("category");
		      

		        ArrayList<String> errors = new ArrayList<String>();
		        if(fromEmail.length()==0) {
		            errors.add("Enter the proper email ID");
		        }
		        if(toEmail.length()==0) {
		            errors.add("Enter the proper email ID");
		        }
		        if(content.length()==0) {
		            errors.add("Enter the proper content");
		        }
		        if(categories.length==0) {
		            errors.add("Select at least one category");
		        }

		        if(!errors.isEmpty()) {
		            request.setAttribute("content", errors);
		            RequestDispatcher rd = request.getRequestDispatcher("ExpressServlet");
		            rd.forward(request, response);
		            return;
		        } else {
		        	for(String s:categories) {
		        		System.out.println(s);
		        	}
		        	
		        	  String deliveryType = "Standard";
		              String requestURI = request.getRequestURI();
		              if (requestURI.contains("ExpressServlet")) {
		                  deliveryType = "Express";
		              } else if (requestURI.contains("InternationalServlet")) {
		                  deliveryType = "International";
		              }
		            // JDBC code to insert data into the database
		            String jdbcURL = "jdbc:mysql://localhost:3306/express_delivery";
		            String jdbcUsername = "root"; 
		            String jdbcPassword = "root";

		            Connection connection = null;
		            PreparedStatement statement = null;

		            try {
		                Class.forName("com.mysql.cj.jdbc.Driver");
		                connection = DriverManager.getConnection(jdbcURL , jdbcUsername, jdbcPassword);

		                String sql = "INSERT INTO deliveries (fromEmail, toEmail, content, categories,deliveryType) VALUES (?, ?, ?, ? ,?)";
		                statement = connection.prepareStatement(sql);
		                statement.setString(1, fromEmail);
		                statement.setString(2, toEmail);
		                statement.setString(3, content);
		                StringBuilder categoriesStr = new StringBuilder();
		                for (String s : categories) {
		                    categoriesStr.append(s).append(",");
		                }
		                statement.setString(4, categoriesStr.toString());
		                statement.setString(5, deliveryType);
		                int rowsInserted = statement.executeUpdate();
		                if (rowsInserted > 0) {
		                    
		                	RequestDispatcher rd1 = request.getRequestDispatcher("/Success1.jsp");
		                    rd1.forward(request, response);
		                }
		            } catch (SQLException e) {
		                e.printStackTrace();
		                out.println("An error occurred while processing your request.");
		            } catch (ClassNotFoundException e) {
		                e.printStackTrace();
		                out.println("JDBC Driver not found.");
		            } finally {
		                try {
		                    if (statement != null) {
		                        statement.close();
		                    }
		                    if (connection != null) {
		                        connection.close();
		                    }
		                } catch (SQLException e) {
		                    e.printStackTrace();
		                }
		            }
		        }
	}

}