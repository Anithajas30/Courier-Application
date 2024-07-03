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

@WebServlet("/ExpressServlet")
public class ExpressServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Express Delivery Form</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
        out.println("header { background-color: #333; color: #fff; padding: 10px 0; text-align: center; }");
        out.println("header h1 { margin: 0; }");
        out.println("form { max-width: 600px; margin: 50px auto; padding: 20px; background-color: #fff; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
        out.println("form input, form select { width: 100%; padding: 10px; margin: 10px 0; border: 1px solid #ccc; border-radius: 5px; }");
        out.println("form input[type='submit'] { background-color: #333; color: #fff; border: none; cursor: pointer; }");
        out.println("form input[type='submit']:hover { background-color: #555; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<header>");
        out.println("<h1>Express Delivery Form</h1>");
        out.println("</header>");
        out.println("<form action='ConnectdbServlet' method='post'>");
        out.println("FROM: <input type='email' name='fromEmail' placeholder='Enter your email' required>");
        out.println("TO: <input type='email' name='toEmail' placeholder='Enter recipient's email' required>");
        out.println("Content: <input type='text' name='content' placeholder='Enter content' required>");
        out.println("Category: <select name='category' multiple>");
        out.println("<option value='electronics'>Electronics</option>");
        out.println("<option value='clothes'>Clothes and Fabrics</option>");
        out.println("<option value='food'>Food</option>");
        out.println("<option value='letters'>Letters</option>");
        out.println("</select>");
        out.println("<input type='submit' value='Send'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

   
    }