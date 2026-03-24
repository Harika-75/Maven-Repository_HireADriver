<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hire A Driver</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #d9a7c7, #fffcdc);
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
        margin: 0;
    }

    .container {
        background: rgba(255, 255, 255, 0.9);
        padding: 40px;
        border-radius: 15px;
        box-shadow: 0 15px 35px rgba(0,0,0,0.1);
        text-align: center;
        width: 350px;
        backdrop-filter: blur(5px);
    }

    h1 {
        margin-bottom: 20px;
        color: #444;
    }

    p {
        margin-bottom: 30px;
        font-size: 18px;
        color: #666;
    }

    .btn {
        display: block;
        width: 100%;
        padding: 12px;
        margin: 10px 0;
        border: none;
        border-radius: 8px;
        font-size: 16px;
        cursor: pointer;
        transition: 0.3s ease;
        text-decoration: none;
        color: white;
    }

    .login-btn {
        background-color: #a18cd1;
    }

    .login-btn:hover {
        background-color: #8f7cc3;
    }

    .register-btn {
        background-color: #fbc2eb;
        color: #333;
    }

    .register-btn:hover {
        background-color: #f7a8d7;
    }
</style>
</head>

<body>

<div class="container">
    <h1>Welcome to Hire A Driver</h1>
    <p>Are you an existing user or a new user?</p>

    <a href="login.jsp" class="btn login-btn">Existing User - Login</a>
    <a href="register.jsp" class="btn register-btn">New User - Register</a>
</div>

</body>
</html>