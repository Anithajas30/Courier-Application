<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Wind-Way Courier Service</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 10px 0;
            text-align: center;
        }

        header h1 {
            margin: 0;
        }

        nav ul {
            list-style: none;
            padding: 0;
        }

        nav ul li {
            display: inline;
            margin-right: 10px;
        }

        nav ul li a {
            color: #fff;
            text-decoration: none;
        }

        .hero {
            background-color: #fff;
            padding: 50px 20px;
            text-align: center;
        }

        .hero h2 {
            margin-top: 0;
        }

        .hero p {
            font-size: 18px;
        }

        .services {
            display: flex;
            justify-content: space-around;
            padding: 20px;
            background-color: #eaeaea;
        }

        .service {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            text-align: center;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .service h3 {
            margin-top: 0;
        }

        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px 0;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>
<body>
    <header>
        <h1>Wind-Way Courier Service</h1>
        <nav>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="/login.jsp">Services</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <section class="hero">
            <h2>Fast and Reliable Courier Service</h2>
            <p>We deliver your packages with utmost care and speed.</p>
        </section>
        <section class="services">
            <div class="service">
               <button><h3><a href="ExpressServlet">Express Delivery</h3></a></button>
                <p>Get your packages delivered within the same day.</p>
            </div>
            <div class="service">
              <button><h3><a href="StandardServlet">Standard Delivery</a></h3></button>
                <p>Affordable delivery within 3-5 business days.</p>
            </div>
            <div class="service">
               <button><h3><a href="InternationalServlet">International Delivery</a></h3></button> 
                <p>We deliver to over 200 countries worldwide.</p>
            </div>
        </section>
    </main>
    <footer>
        <p>&copy; 2024 Courier Service. All rights reserved.</p>
    </footer>
</body>
</html>