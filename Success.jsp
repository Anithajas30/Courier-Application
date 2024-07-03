<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>	Login Page</title>
<link rel="stylesheet" href="Signup.css">
</head>
<body><header>
  <div class="menu-toggle">&#9776;</div> <!-- Menu toggle button for mobile -->
  <nav class="navbar">
    <ul>
      <li><a href="#">HOME</a></li>
      <li><a href="#">SERVICES</a></li>
      <li><a href="#">LOCATION</a></li>
      <li><a href="#">CONTACT US</a></li>
      <li><a href="#">ABOUT</a></li>
    </ul>
  </nav>
</header>

<center>
<br><br><br><br>
  <h2>Customer and Employee</h2><br>
  <div class="form-container">
    <form>
      <h2>PORTAL LOGIN</h2>
  <br>
  <br>
  <br>

      <label for="email">Email</label>
      <input type="email" id="email" name="email" required>

      <label for="password">Password</label>
      <input type="password" id="password" name="password" required>
      
      <button type="submit">Login</button>
    </form>
  </div>
</center>


<script>
// JavaScript for handling menu toggle
document.querySelector('.menu-toggle').addEventListener('click', function() {
  document.querySelector('.navbar').classList.toggle('active');
});
</script> <!-- JavaScript for menu functionality -->
<footer>
  <p>&copy; 2024 courier Website. All rights reserved.</p>
</footer>

</body>
</html>