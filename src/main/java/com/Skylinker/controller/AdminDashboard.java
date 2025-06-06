package com.Skylinker.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AdminDashboard servlet handles requests to the admin dashboard page.
 * It forwards GET requests to the admindashboard.jsp page.
 * 
 * LMU ID: 23048681  
 * NAME: Sambridhi Shrestha
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AdminDashboard" })
public class AdminDashboard extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public AdminDashboard() {
        super();
    }

    /**
     * Handles HTTP GET requests.
     * Forwards the request to the admin dashboard JSP page.
     *
     * @param request  HttpServletRequest containing the client request
     * @param response HttpServletResponse to send the response
     * @throws ServletException if servlet-specific error occurs
     * @throws IOException      if an I/O error occurs during processing
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/admindashboard.jsp").forward(request, response);
    }

    /**
     * Handles HTTP POST requests by delegating to doGet.
     *
     * @param request  HttpServletRequest containing the client request
     * @param response HttpServletResponse to send the response
     * @throws ServletException if servlet-specific error occurs
     * @throws IOException      if an I/O error occurs during processing
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
