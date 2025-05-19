<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register | Skylinker</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/error-popup.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600;700;800&family=Open+Sans&display=swap" rel="stylesheet">
</head>
<body>
		<%
		    String error = (String) request.getAttribute("error");
		    if (error != null && !error.trim().isEmpty()) {
		%>
		<div id="errorPopup" class="error-popup-overlay">
		    <div class="error-popup-container">
		        <div class="error-popup-header">
		            <h3>Registration Error</h3>
		        </div>
		        <div class="error-popup-body">
		            <%= error.replaceAll("<br>", "<br/>") %>
		        </div>
		        <div class="error-popup-footer">
		            <button onclick="document.getElementById('errorPopup').remove()" 
		                    style="padding: 8px 16px; background: #1A73E8; color: white; border: none; border-radius: 4px; cursor: pointer;">
		                OK
		            </button>
		        </div>
		    </div>
		</div>
		<% } %>
    <div class="page-center-wrapper">
        <div class="register-container">
            <div class="register-welcome">
                <img src="${pageContext.request.contextPath}/resources/images/system/airplane.jpg" alt="Welcome Image">
                <div class="register-welcome-content">
                    <h2>Hello!</h2>
                    <p>Join our community today and unlock exclusive features and benefits.</p>
                </div>
            </div>
            <div class="register-form">
                <h1>CREATE ACCOUNT</h1>
                <form action="register" method="post">
                    <input type="text" name="firstName" placeholder="First Name" required>
                    <input type="text" name="lastName" placeholder="Last Name" required>
                    <input type="email" name="email" placeholder="Email Address" required>
                    <input type="tel" name="phone" placeholder="Phone Number" required>
                    <input type="password" name="password" placeholder="Create Password" required>
                    <input type="password" name="confirmPassword" placeholder="Confirm Password" required>
                    <button type="submit" class="register-btn">REGISTER</button>
                    <div class="login-prompt">
                        <span>Already have an account?</span>
                        <a href="${pageContext.request.contextPath}/login">Login here</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
