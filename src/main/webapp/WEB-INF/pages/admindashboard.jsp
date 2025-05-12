<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admindashboard.css">
    <jsp:include page="header.jsp"/>
</head>
<body>
   
    <div class="dashboard-container">
    <h1>Admin Dashboard</h1>
        <section class="stats-section">
            <div class="stat-card">
                <div class="stat-icon">
                <img src="${pageContext.request.contextPath}/resources/images/system/sales.png" >
                </div>
                <div class="stat-info">
                    <h3>Total Sales</h3>
                    <p>Rs 38,97,86,000</p>
                    <p class="stat-change up">↑ 12.5% since last month</p>
                </div>
            </div>
            <div class="stat-card">
                <div class="stat-icon">
                <img src="${pageContext.request.contextPath}/resources/images/system/booking.png" >
                </div>
                <div class="stat-info">
                    <h3>Total Bookings</h3>
                    <p>30,452</p>
                    <p class="stat-change up">↑ 8% since last month</p>
                </div>
            </div>
            <div class="stat-card">
                <div class="stat-icon">
                <img src="${pageContext.request.contextPath}/resources/images/system/Active.jpg">
                </div>
                <div class="stat-info">
                    <h3>Active Airlines</h3>
                    <p>38</p>
                    <p class="stat-change up">↑ 3 new since last month</p>
                </div>
            </div>
            <div class="stat-card">
                <div class="stat-icon">
                <img src="${pageContext.request.contextPath}/resources/images/system/Total.png" >
                </div>
                <div class="stat-info">
                    <h3>Total Customers</h3>
                    <p>129,309</p>
                    <p class="stat-change up">↑ 5.9% since last month</p>
                </div>
            </div>
        </section>

       <section class="charts-section">
    <!-- Bar Chart: Monthly Sales by Airline -->
    <div class="chart-card bar-chart-container">
        <h2>Monthly Sales by Airline</h2>
        <div class="bar-chart">
            <div class="bar" style="height: 60%;" title="Rs 60,000"><label>Jan</label></div>
            <div class="bar" style="height: 80%;" title="Rs 80,000"><label>Feb</label></div>
            <div class="bar" style="height: 65%;" title="Rs 65,000"><label>Mar</label></div>
            <div class="bar" style="height: 85%;" title="Rs 85,000"><label>Apr</label></div>
            <div class="bar" style="height: 50%;" title="Rs 50,000"><label>May</label></div>
            <div class="bar" style="height: 80%;" title="Rs 90,000"><label>Jun</label></div>
            <div class="bar" style="height: 100%;" title="Rs 100,000"><label>Jul</label></div>
            <div class="bar" style="height: 95%;" title="Rs 95,000"><label>Aug</label></div>
            <div class="bar" style="height: 70%;" title="Rs 70,000"><label>Sep</label></div>
            <div class="bar" style="height: 75%;" title="Rs 75,000"><label>Oct</label></div>
            <div class="bar" style="height: 65%;" title="Rs 65,000"><label>Nov</label></div>
            <div class="bar" style="height: 80%;" title="Rs 80,000"><label>Dec</label></div>
        </div>
    </div>

    <!-- Pie Chart: Top Performing Airlines -->
    <div class="chart-card pie-chart-container">
        <h2>Top Performing Airlines</h2>
        <div class="pie-chart">
            <div class="slice slice1"></div>
            <div class="slice slice2"></div>
            <div class="slice slice3"></div>
            <div class="slice slice4"></div>
            <div class="slice slice5"></div>
        </div>
        <div class="legend">
            <div class="legend-item"><div class="color-box color1"></div>Shree Airlines</div>
            <div class="legend-item"><div class="color-box color2"></div>Yeti Airines</div>
            <div class="legend-item"><div class="color-box color3"></div>Buddha Air</div>
            <div class="legend-item"><div class="color-box color4"></div>Saurya Airline</div>
            <div class="legend-item"><div class="color-box color5"></div>Tara Air</div>
        </div>
    </div>
</section>

        <!-- Table Section -->
        <section class="table-section">
            <div class="table-header">
                <h2>Skylinker Sales</h2>
            </div>
            <table class="data-table">
                <thead>
                    <tr>
                        <th>Airline</th>
                        <th>Revenue</th>
                        <th>Tickets Sold</th>
                        <th>Routes</th>
                        <th>Status</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Yeti Airines</td>
                        <td>Rs 80,000</td>
                        <td>5,782</td>
                        <td>28</td>
                        <td><div class="status active">Active</div></td>
                        
                    </tr>
                    <tr>
                        <td>Shree Airlines</td>
                        <td>Rs 60,000</td>
                        <td>3,567</td>
                        <td>18</td>
                        <td><div class="status active">Active</div></td>
                        
                    </tr>
                    <tr>
                        <td>Buddha Air</td>
                        <td>Rs 1,00,000</td>
                        <td>6,987</td>
                        <td>26</td>
                        <td><div class="status active">Active</div></td>
                        
                    </tr>
                    <tr>
                        <td>Tara Air</td>
                        <td>Rs 56,000</td>
                        <td>2,789</td>
                        <td>15</td>
                        <td><div class="status active">Active</div></td>
                        
                    </tr>
                    <tr>
                        <td>Saurya Airines</td>
                        <td>Rs 75,000</td>
                        <td>4,876</td>
                        <td>25</td>
                        <td><div class="status active">Active</div></td>
                        
                    </tr>
                    <tr>
                        <td>Sita Air</td>
                        <td>RS 45,000</td>
                        <td>1,923</td>
                        <td>12</td>
                        <td><div class="status maintenance">Maintenance</div></td>
                     
                    </tr>
                    <tr>
                        <td>Guna Airlines</td>
                        <td>Rs 40,000</td>
                        <td>1,845</td>
                        <td>11</td>
                        <td><div class="status active">Active</div></td>
                        
                    </tr>
                </tbody>
            </table>
        </section>
    </div>
</body>
<jsp:include page = "footer.jsp"/>
</html>
