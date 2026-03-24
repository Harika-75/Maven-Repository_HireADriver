<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hire a Driver - Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
 <div class="login-container">
     <h1>Hire a Driver Login Page</h1>

     <form action="http://localhost:8082/HireADriver/login" method="post">
         <label>USERNAME :</label>
         <input type="text" name="user_name"/>

         <label>PASSWORD :</label>
         <input type="password" name="password"/>

         <input type="submit" value="Login"/>
     </form>
 </div>
</body>
</html>