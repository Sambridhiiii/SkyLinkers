package com.Skylinker.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CustomerBooking servlet handles requests related to customer flight bookings.
 * It forwards GET requests to the customerbooking.jsp page.
 * 
 * LMU ID: 23048681  
 * NAME: Sambridhi Shrestha
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/CustomerBooking" })
public class CustomerBooking extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public CustomerBooking() {
        super();
    }

    /**
     * Handles HTTP GET requests.
     * Forwards the request to the customer booking JSP page.
     *
     * @param request  the HttpServletRequest containing client request
     * @param response the HttpServletResponse to send response to client
     * @throws ServletException if servlet-specific error occurs
     * @throws IOException      if an I/O error occurs during processing
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/customerbooking.jsp").forward(request, response);
    }

    /**
     * Handles HTTP POST requests by delegating to doGet.
     *
     * @param request  the HttpServletRequest containing client request
     * @param response the HttpServletResponse to send response to client
     * @throws ServletException if servlet-specific error occurs
     * @throws IOException      if an I/O error occurs during processing
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
