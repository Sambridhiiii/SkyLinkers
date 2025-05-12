<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Flight Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/flight.css">
    <jsp:include page = "header.jsp"/>
</head>
<body>
<div class="container">
    <div class="flight-form">
        <h2>Add Flight</h2>
        <form id="flightForm">
            <input type="hidden" id="flightId">
            <div class="form-row">
                <div class="form-group">
                    <label for="flightNumber">Flight Number</label>
                    <input type="text" id="flightNumber" >
                </div>
                <div class="form-group">
                    <label for="airline">Airline</label>
                    <input type="text" id="airline" >
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="From">From</label>
                    <input type="text" id="from" >
                </div>
                <div class="form-group">
                    <label for="To">To</label>
                    <input type="text" id="to" >
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="departureDate">Departure Date</label>
                    <input type="date" id="departureDate" >
                </div>
                <div class="form-group">
                    <label for="departureTime">Departure Time</label>
                    <input type="time" id="departureTime">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="arrivalDate">Arrival Date</label>
                    <input type="date" id="arrivalDate" >
                </div>
                <div class="form-group">
                    <label for="arrivalTime">Arrival Time</label>
                    <input type="time" id="arrivalTime">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="status">Status</label>
                    <select id="status" required>
                        <option value="On Time">On Time</option>
                        <option value="Delayed">Delayed</option>
                        <option value="Cancelled">Cancelled</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="aircraft">Aircraft Type</label>
                    <input type="text" id="aircraft" >
                </div>
            </div>

            <div class="form-row action-button-row">
                <button type="submit" id="submitBtn">Create Flight</button>
                <button type="button" id="updateBtn" style="background-color: #FFA500;">Update Flight</button>
                <button type="button" id="deleteBtn" style="background-color: #F44336;">Delete Flight</button>
                <button type="button" id="resetBtn" style="background-color: #666;">Reset Form</button>
           </div>
        </form>
    </div>

    <div class="search-bar">
        <input type="text" id="searchInput" placeholder="Search flights by number,destination.......">
    </div>

    <h2>Flight Schedule</h2>
    <table class="flight-table">
        <thead>
            <tr>
                <th>Flight No</th>
                <th>Airline</th>
                <th>From</th>
                <th>To</th>
                <th>Departure Time</th>
                <th>Arrival Time</th>
                <th>Aircraft</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody id="flightTableBody">
            <tr>
                        <td>SL 098</td>
                        <td>Yeti Airines</td>
                        <td>Birjung</td>
                        <td>Kathmandu</td>
                        <td>11:00AM</td>
                        <td>1:00PM</td>
                        <td>Delayed</td>
                        <td>Boeing-08</td>
                        <td><div class="status">Active</div></td>
                        
                    </tr>
                    <tr>
                        <td>SL 018</td>
                        <td>Buddha Air</td>
                        <td>Kathmandu</td>
                        <td>Dang</td>
                        <td>1:00PM</td>
                        <td>2:00PM</td>
                        <td>On time</td>
                        <td>AirBus-77</td>
                        <td><div class="status">Active</div></td>
                    </tr>
        </tbody>
    </table>
</div>
</body>
<jsp:include page = "footer.jsp"/>
</html>
