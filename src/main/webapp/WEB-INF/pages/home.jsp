<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    
    </head>
<body >
<jsp:include page="${headerToInclude}" />
    <section class="hero-section">
        <div class="hero-content">
            <p class="pre-title">PREMIUM TRAVEL EXPERIENCE</p>
            <h1>Elevate Your Journey With Skylinker</h1>
            <div class="hero-divider"></div>
            <p class="hero-description">Where luxury meets convenience. Book with us for exclusive cabin upgrades, priority check-in and personalized service at 30,000 feet.</p>
            <button class="cta-button">
                <span class="btn-text">Book Now</span>
            </button>
        </div>
    </section>
    <!-- Flight Deals Section -->
<section class="deals-section">
        <h1 class="deals-heading"> LATEST FLIGHT DEALS </h1>
    
    <div class="deals-container">
        <!-- Card 1 -->
        <div class="deal-card">
        
            <div class="deal-image" style="background-image: url('${pageContext.request.contextPath}/resources/images/system/Yeti.jpg')"></div>
            <div class="deal-content">
                <h2>Kathmandu to Pokhara</h2>
                <p class="airlines">Airline:- Yeti Airlines</p>
                <p class="travel-dates">14 June, 2025 - 20 June, 2025</p>
                <h3 class="price-tag">First Class Rs 15,000</h3>
                <button class="booking-btn">BOOK NOW</button>
            </div>
        </div>
        
        <!-- Card 2 -->
        <div class="deal-card">
            <div class="deal-image" style="background-image: url('${pageContext.request.contextPath}/resources/images/system/Shree.jpg')"></div>
            <div class="deal-content">
                <h2>Dang to Itahari</h2>
                <p class="airlines">Airline:- Shree Airline</p>
                <p class="travel-dates">16 June, 2025 - 22 June, 2025</p>
                <h3 class="price-tag">Economy Class Rs 5,000</h3>
                <button class="booking-btn">BOOK NOW</button>
            </div>
        </div>
        
        <!-- Card 3 -->
        <div class="deal-card">
            <div class="deal-image" style="background-image: url('${pageContext.request.contextPath}/resources/images/system/Buddha.jpg')"></div>
            <div class="deal-content">
                <h2>Butwal to Pokhara</h2>
                <p class="airlines">Airline:- Buddha Air</p>
                <p class="travel-dates">15 June, 2025 - 20 June 2025</p>
                <h3 class="price-tag">Economy Class Rs 4,000</h3>
                <button class="booking-btn">BOOK NOW</button>
            </div>
        </div>
         <!-- Card 4 -->
        <div class="deal-card">
            <div class="deal-image" style="background-image: url('${pageContext.request.contextPath}/resources/images/system/Saurya.jpg')"></div>
            <div class="deal-content">
                <h2>Kathmandu to Janakpur</h2>
                <p class="airlines">Airline:- Saurya Airlines</p>
                <p class="travel-dates">14 June, 2025 - 20 June 2025</p>
                <h3 class="price-tag">First Class Rs 10,000</h3>
                <button class="booking-btn">BOOK NOW</button>
            </div>
        </div>
        
    </div>
</section>

</body>
<jsp:include page = "footer.jsp"/>
</html>