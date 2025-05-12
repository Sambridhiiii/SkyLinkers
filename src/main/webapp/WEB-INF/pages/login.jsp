<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<div class="container">
    <div class="form-container">
        <h2>Login </h2>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <input type="text" name="username" placeholder="Username" required />
            <input type="password" name="password" placeholder="Password" required />
            <a href="#">Forget Your Password?</a>
            <button type="submit">Login </button>
        </form>
    </div>
    <div class="image-container">
        <img src="${pageContext.request.contextPath}/resources/images/system/airplane.jpg" >
        <div class="image-content">
            <h2>Welcome to Skylinker! </h2>
            <p>Register now to use all of site features</p>
            <form action="${pageContext.request.contextPath}/register" method="get">
                <button type="submit" class="signup-btn">Register Now</button>
            </form>
        </div>
    </div>
</div>

</body>

</html>