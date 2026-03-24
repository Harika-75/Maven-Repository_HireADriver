<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f6f9;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
        margin: 0;
    }

    h1 {
        margin-bottom: 12px;
        font-size: 20px;
        color: #333;
    }

    form {
        background-color:   #cceeff;
        padding: 18px 45px 18px 30px;
        width: 300px;
        border-radius: 6px;
        box-shadow: 0 3px 8px rgba(0, 0, 0, 0.1);
    }

    label {
        display: block;
        margin-top: 8px;
        font-size: 13px;
        font-weight: bold;
        color: #333;
    }

    input, select, textarea {
        width: 100%;
        padding: 6px 8px;
        margin-top: 4px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 13px;
    }

    textarea {
        resize: none;
        height: 55px;
    }

    input[type="submit"] {
        margin-top: 15px;
        background: #4a90e2;
        color: white;
        border: none;
        padding: 8px;
        font-size: 14px;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background: #357abd;
    }
</style>
</head>
<body>
<h1>Registration For Hire A Driver</h1>

<form action="Register" method="post">

    <label>First Name</label>
    <input type="text" name="firstname" required>

    <label>Last Name</label>
    <input type="text" name="lastname" required>

    <label>Username</label>
    <input type="text" name="username" required>

    <label>Password</label>
    <input type="password" name="password" required>

    <label>Phone Number</label>
    <input type="text" name="phone" required>

    <label>Email</label>
    <input type="text" name="email" required>
    
    <label>Date of Birth</label>
    <input type="date" name="dob" required>
    
    <label>User Type</label>
    <select name="userType" required>
        <option value="">-- Select User Type --</option>
        <option value="CUSTOMER">Customer</option>
        <option value="DRIVER">Driver</option>
    </select>
    
  

    <label>Gender</label>
    <select name="gender" required>
        <option value="">-- Select Gender --</option>
        <option value="MALE">Male</option>
        <option value="FEMALE">Female</option>
        <option value="OTHER">Other</option>
    </select>

    
    <label>Address</label>
    <textarea name="address" required></textarea>

    <input type="submit" value="Register">
</form>

</body>
</html>