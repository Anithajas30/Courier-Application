<%@ page import="java.io.,java.util.,javax.servlet.,javax.servlet.http." %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Here you would typically check the username and password against a database
    // For demonstration purposes, we'll assume any non-empty username and password is valid
    if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
        // Simulate successful login
        out.println("<html><body>");
        out.println("<h2>Login Successful</h2>");
        out.println("<p>Welcome, " + username + "!</p>");
        out.println("<br><button><a href='Explore.jsp'>Explore</a></button>");
        out.println("</body></html>");
    } else {
        // Simulate failed login
        out.println("<html><body>");
        out.println("<h2>Login Failed</h2>");
        out.println("<p>Invalid username or password.</p>");
        out.println("</body></html>");
    }
%>