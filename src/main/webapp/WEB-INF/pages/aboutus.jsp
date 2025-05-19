<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>About Us </title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/aboutus.css"/>
</head>
<body>
<jsp:include page="${headerToInclude}" />
  <div class="container">
    <section class="hero">
      <h1>About SkyLinker</h1>
      <p>We're a team of passionate aviation professionals dedicated to making air travel safer, more efficient, and more enjoyable for everyone. Since 2005, we've been connecting people, businesses, and cultures across the globe.</p>
    </section>
    
    <section class="section team-photo">
      <div class="team-photo-content">
        <div class="team-photo-text">
          <h2>Our Team</h2>
          <p>At SkyLinker, our greatest asset is our people. Our diverse team of professionals brings together expertise from across the aviation industry, technology sector, and customer service fields.</p>
          <p>We share a common passion for excellence and innovation, working together to transform the way people experience air travel. From our pilots and engineers to our customer service representatives, everyone plays a crucial role in our success.</p>
        </div>
        <div class="team-photo-image">
          <img src="${pageContext.request.contextPath}/resources/images/system/Team.jpg">
        </div>
       </div>
    </section>
    
    <section class="section mission">
      <div class="mission-content">
        <div class="mission-text">
          <h2>Our Mission</h2>
          <p>SkyLinker's mission is to revolutionize air travel by providing safe, efficient, and memorable experiences that exceed our customers' expectations while maintaining the highest standards of service excellence.</p>
          <p>We believe that air travel should be more than just transportation—it should be an experience that enriches lives, connects communities, and opens up a world of possibilities. That's why we're committed to innovation, sustainability, and customer satisfaction in everything we do.</p>
        </div>
        <div class="mission-image">
          <img src="${pageContext.request.contextPath}/resources/images/system/mission.jpg">
        </div>
      </div>
    </section>
    
    <section class="section story">
      <div class="story-content">
        <div class="story-text">
          <h2>Our Story</h2>
          <p>SkyLinker was founded in 2005 by aviation enthusiasts Sambridhi Shrestha and Aaditi Ghimire who shared a vision for a different kind of airline—one that combines cutting-edge technology with a deeply human approach to service.</p>
          <p>Starting with just three aircraft and a handful of routes, we've grown steadily over the years, expanding our fleet, our destinations, and our team. Today, we operate over 150 modern aircraft serving more than 120 destinations.</p>
          <p>Throughout our growth, we've remained true to our founding principles: safety first, customer-centricity and continuous innovation. These principles have guided us through industry changes, global challenges, and exciting opportunities.</p>
        </div>
        <div class="story-image">
          <img src="${pageContext.request.contextPath}/resources/images/system/oldplane.jpg">
        </div>
      </div>
    </section>
    
    <section class="section values">
      <h2>Our Core Values</h2>
      <div class="values-grid">
        <div class="value-item">
          <h3>Safety</h3>
          <p>Safety is our top priority in every decision we make and action we take. We maintain the highest standards of training, equipment, and procedures.</p>
        </div>
        <div class="value-item">
          <h3>Excellence</h3>
          <p>We strive for excellence in every aspect of our operations, from the technical performance of our aircraft to the warmth of our customer service.</p>
        </div>
        <div class="value-item">
          <h3>Innovation</h3>
          <p>We embrace new technologies, ideas, and approaches that can improve the air travel experience and make our operations more efficient and sustainable.</p>
        </div>
        
      </div>
    </section>
    
    <section class="section cta">
      <h2>Fly Better with SkyLinker</h2>
      <p>Join millions of satisfied travelers who choose SkyLinker for reliable, comfortable, and exceptional air travel experiences.</p>
      <a href="#" class="cta-button">Book Your Flight Today</a>
    </section>
  </div>
  
</body>
<jsp:include page="footer.jsp"/>
</html>