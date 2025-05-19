<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customerprofile.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <jsp:include page="${headerToInclude}" />
</head>
<body>
<div class="container">
    <section class="customer-profile">
        <div class="profile-image-container">
            <img src="${pageContext.request.contextPath}/resources/images/system/Customer1.jpg" class="profile-image" id="profileImage">
            <label for="fileUpload" class="image-upload" title="Upload Profile Picture">
                <i class="fas fa-camera"></i>
            </label>
            <input type="file" id="fileUpload" class="file-upload" accept="image/*" />
        </div>
        <div class="customer-info">
            <h1>Customer Profile</h1>
            <p class="customer-role">Valued Customer</p>
        </div>
    </section>

    <div class="profile-form">
        <h2 class="form-title">Profile Information</h2>
        <form id="profileForm" method="post" enctype="multipart/form-data" action="yourProfileUpdateServlet">
            <div class="form-row">
                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <input type="text" id="firstName" name="firstName" class="form-control" required>
                    <div class="error-message" id="firstName-error"></div>
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input type="text" id="lastName" name="lastName" class="form-control" required>
                    <div class="error-message" id="lastName-error"></div>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" id="email" name="email" class="form-control" required>
                    <div class="error-message" id="email-error"></div>
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" id="address" name="address" class="form-control" required>
                    <div class="error-message" id="address-error"></div>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" class="form-control" required>
                    <div class="error-message" id="password-error"></div>
                </div>
                <div class="form-group">
                    <label for="confirmPassword">Confirm Password</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" required>
                    <div class="error-message" id="confirmPassword-error"></div>
                </div>
            </div>

            <div class="form-group">
                <label for="aboutMe">About Me</label>
                <textarea id="aboutMe" name="aboutMe" class="form-control" rows="4" placeholder="Tell us about yourself..."></textarea>
                <div class="error-message" id="aboutMe-error"></div>
            </div>

            <div class="buttons">
                <button type="reset" class="btn btn-secondary">Cancel</button>
                <button type="submit" class="btn">Save Changes</button>
            </div>
        </form>
    </div>
</div>
</body>
<jsp:include page = "footer.jsp"/>
</html>
