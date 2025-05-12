<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact SkyLinker</title>
    <!-- Link to external CSS files -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/contact.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&family=Open+Sans:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
    <jsp:include page="header.jsp"/>
    <main>
        <h1>Contact SkyLinker Airlines</h1>
        <p class="intro-text">We value your feedback and are here to assist you with any inquiries or concerns.</p>

        <div class="contact-container">
            <!-- Contact Information -->
            <div class="contact-info">
                <h2>Get In Touch</h2>
                <div class="contact-method">
                    <h3><img src="${pageContext.request.contextPath}/resources/images/system/Customer.png" alt="Phone" class="contact-icon"> Customer Service</h3>
                    <p>Phone: +977 01986537 SKY-LINE</p>
                    <p>Email: skylinker7@gmail.com</p>
                    <p>Hours: 24/7 Service</p>
                </div>
                <div class="contact-method">
                    <h3><img src="${pageContext.request.contextPath}/resources/images/system/headq.png" alt="Location" class="contact-icon"> Headquarters</h3>
                    <p>SkyLinker Tower</p>
                    <p>123 Aviation Way</p>
                    <p>Balaju, Kathmandu</p>
                </div>
                <div class="contact-method">
                    <h3><img src="${pageContext.request.contextPath}/resources/images/system/SocialM.jpg" alt="Social Media" class="contact-icon"> Social Media</h3>
                    <p>Follow us for latest updates:</p>
                    <div class="social-links">
                        <p><img src="${pageContext.request.contextPath}/resources/images/system/twitter.png" alt="Twitter" class="social-icon"> Twitter: @SkyLinkerAir</p>
                        <p><img src="${pageContext.request.contextPath}/resources/images/system/face.png" alt="Facebook" class="social-icon"> Facebook: SkyLinkerAirlines</p>
                        <p><img src="${pageContext.request.contextPath}/resources/images/system/insta.png" alt="Instagram" class="social-icon"> Instagram: @skylinker</p>
                    </div>
                </div>
            </div>

            <!-- Contact Form -->
            <div class="contact-form">
                <h2>Send Us A Message</h2>
                <form>
                    <div class="form-group">
                        <label for="name">Full Name</label>
                        <input type="text" id="name" name="name" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email Address</label>
                        <input type="email" id="email" name="email" required>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone Number</label>
                        <input type="tel" id="phone" name="phone">
                    </div>
                    <div class="form-group">
                        <label for="subject">Subject</label>
                        <select id="subject" name="subject" required>
                            <option value="" disabled selected>Select a subject</option>
                            <option value="booking">Reservation Inquiry</option>
                            <option value="feedback">Feedback</option>
                            <option value="support">Customer Support</option>
                            <option value="career">Career Opportunities</option>
                            <option value="other">Other</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="message">Message</label>
                        <textarea id="message" name="message" rows="6" required placeholder="Your message here..."></textarea>
                    </div>
                    <button type="submit" class="submit-btn">Submit Message</button>
                </form>
            </div>
        </div>
    </main>
</body>
</html>
