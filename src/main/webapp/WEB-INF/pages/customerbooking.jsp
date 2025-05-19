<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Book Flights</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customerbooking.css">
</head>
<jsp:include page="${headerToInclude}" />
<body>
  <div class="container">
    <div class="feature-container">
      <div class="feature-box blue">
        <img src="${pageContext.request.contextPath}/resources/images/system/Comfortable.jpg">
        <h3>Comfortable Flights</h3>
        <p>Enjoy our modern fleet with premium services</p>
      </div>
      <div class="feature-box orange">
        <img src="${pageContext.request.contextPath}/resources/images/system/reliable.jpg">
        <h3>Reliable Service</h3>
        <p>On-time departures with excellent safety record</p>
      </div>
      <div class="feature-box blue">
        <img src="${pageContext.request.contextPath}/resources/images/system/Easy.jpg">
        <h3>Easy Booking</h3>
        <p>Simple and convenient reservation process</p>
      </div>
    </div>
    <h2>Available Flights</h2>
    <table class="flight-table">
      <thead>
        <tr>
          <th>Flight No</th>
          <th>Airline</th>
          <th>From</th>
          <th>To</th>
          <th>Departure Time</th>
          <th>Arrival Time</th>
          <th>Status</th>
          <th>Aircraft</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>SL 098</td>
          <td>Yeti Airlines</td>
          <td>Birjung</td>
          <td>Kathmandu</td>
          <td>11:00AM</td>
          <td>1:00PM</td>
          <td><span class="status delayed">Delayed</span></td>
          <td>Boeing-08</td>
          <td><button class="book-btn">Book Now</button></td>
        </tr>
        <tr>
          <td>SL 018</td>
          <td>Buddha Air</td>
          <td>Kathmandu</td>
          <td>Dang</td>
          <td>1:00PM</td>
          <td>2:00PM</td>
          <td><span class="status on-time">On time</span></td>
          <td>AirBus-77</td>
          <td><button class="book-btn">Book Now</button></td>
        </tr>
        <tr>
          <td>SL 048</td>
          <td>Tara Air</td>
          <td>Pokhara</td>
          <td>Mustang</td>
          <td>3:00PM</td>
          <td>4:00PM</td>
          <td><span class="status delayed">On time</span></td>
          <td>AirBus-77</td>
          <td><button class="book-btn">Book Now</button></td>
        </tr>
        <tr>
          <td>SL 998</td>
          <td>Saurya Air</td>
          <td>Kathmandu</td>
          <td>Nepalgunj</td>
          <td>7:00AM</td>
          <td>8:00AM</td>
          <td><span class="status on-time">On time</span></td>
          <td>AirBus-77</td>
          <td><button class="book-btn">Book Now</button></td>
        </tr>
        <tr>
          <td>SL 675</td>
          <td>Shree Airlines</td>
          <td>Butwal</td>
          <td>Jhapa</td>
          <td>5:00AM</td>
          <td>5:45AM</td>
          <td><span class="status on-time">On time</span></td>
          <td>AirBus-77</td>
          <td><button class="book-btn">Book Now</button></td>
        </tr>
      </tbody>
    </table>
  </div>
</body>
<jsp:include page = "footer.jsp"/>
</html>