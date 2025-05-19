<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <title>SkyLinker Customer Header</title>
    
</head>
<body>
    <header class="main-header">
        <div class="header-container">
            <!-- Logo Section -->
            <div class="logo-section">
                <a href="${pageContext.request.contextPath}/Home" class="logo">Sky<span>Linker</span></a>
                <div class="tagline">Connecting the skies</div>
            </div>

            <!-- Navigation Section -->          
            <nav class="nav-links">
               <ul>
                   <li><a href="${pageContext.request.contextPath}/Home">HOME</a></li>
                   <li><a href="${pageContext.request.contextPath}/CustomerBooking">BOOKING</a></li>
                   <li><a href="${pageContext.request.contextPath}/AboutUs">ABOUT US</a></li>
                   <li><a href="${pageContext.request.contextPath}/Contact">CONTACT US</a></li>
               </ul>
            </nav>

            <!-- Search + Profile Section -->
            <div class="extras">
			    <div class="search-box">
			        <i class="fa fa-search"></i>
			        <input type="text" placeholder="Search...">
			    </div>
			    <a href="${pageContext.request.contextPath}/Customer" class="profile-link">
			        <i class="fa fa-user"></i>
			    </a>
			</div>
        </div>
    </header>
</body>
</html>
