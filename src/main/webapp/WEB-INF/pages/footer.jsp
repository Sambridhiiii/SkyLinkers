<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <title>SkyLinker Footer</title>
</head>
<body>
    <footer class="main-footer">
        <div class="footer-container">
            <!-- Copyright Section -->
            <div class="copyright-section">
                <div class="footer-logo">Sky<span>Linker</span></div>
                <div class="copyright-text">© 2025 SkyLinker. All rights reserved.</div>
            </div>

            <!-- Logout Section -->
            <div class="logout-section">
                <a href="logout.jsp" class="logout-btn">
                    <i class="fas fa-sign-out-alt"></i> Logout
                </a>
            </div>
        </div>
    </footer>
</body>
</html>