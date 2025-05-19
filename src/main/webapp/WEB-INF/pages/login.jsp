<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>
<div class="container">
    <div class="form-container">
        <h2>Login</h2>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <input type="text" name="email" placeholder="Email" required />
            <input type="password" name="password" placeholder="Password" required />
            <a href="#" class="forgot-password">Forget Your Password?</a>
            <button type="submit">Login</button>
        </form>
    </div>
    <div class="image-container">
        <img src="${pageContext.request.contextPath}/resources/images/system/airplane.jpg" alt="Airplane" />
        <div class="image-content">
            <h2>Welcome to Skylinker!</h2>
            <p>Register now to use all of site features</p>
            <form action="${pageContext.request.contextPath}/register" method="get">
                <button type="submit" class="signup-btn">Register Now</button>
            </form>
        </div>
    </div>
</div>

<!-- Error Popup Modal -->
<div id="errorPopup" class="popup-overlay">
    <div class="popup-content">
        <button type="button" id="errorClose" class="popup-close" aria-label="Close popup">&times;</button>
        <h3>Error</h3>
        <p id="errorMessage"></p>
        <button id="errorOkBtn">OK</button>
    </div>
</div>

<!-- Logout Success Popup Modal -->
<div id="logoutPopup" class="popup-overlay">
    <div class="popup-content">
        <button type="button" id="logoutClose" class="popup-close" aria-label="Close popup">&times;</button>
        <h3>Success</h3>
        <p id="logoutMessage">You have successfully logged out!</p>
        <button id="logoutOkBtn">OK</button>
    </div>
</div>

<script>
    // Error Popup Elements
    const errorPopup = document.getElementById('errorPopup');
    const errorClose = document.getElementById('errorClose');
    const errorOkBtn = document.getElementById('errorOkBtn');
    const errorMessage = document.getElementById('errorMessage');

    // Logout Popup Elements
    const logoutPopup = document.getElementById('logoutPopup');
    const logoutClose = document.getElementById('logoutClose');
    const logoutOkBtn = document.getElementById('logoutOkBtn');

    // Close functions
    function closeErrorPopup() {
        errorPopup.style.display = 'none';
    }

    function closeLogoutPopup() {
        logoutPopup.style.display = 'none';
    }

    errorClose.onclick = closeErrorPopup;
    errorOkBtn.onclick = closeErrorPopup;
    logoutClose.onclick = closeLogoutPopup;
    logoutOkBtn.onclick = closeLogoutPopup;

    window.onclick = function(event) {
        if (event.target === errorPopup) {
            closeErrorPopup();
        }
        if (event.target === logoutPopup) {
            closeLogoutPopup();
        }
    };

  
    <% if(request.getAttribute("error") != null) { %>
        errorMessage.innerText = "<%= request.getAttribute("error") %>";
        errorPopup.style.display = 'flex';
    <% } %>

 
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.get('logout') === 'success') {
        logoutPopup.style.display = 'flex';
        // ✅ Clear the URL parameter to avoid repeated popup
        const url = new URL(window.location);
        url.searchParams.delete('logout');
        window.history.replaceState(null, null, url);
        // ✅ Optional: Auto-close after 3 seconds
        setTimeout(() => {
            closeLogoutPopup();
        }, 3000);
    }
</script>

</body>
</html>
