package com.Skylinker.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * FlightController handles requests related to flight information.
 * It forwards GET requests to the flight.jsp page.
 * 
 * LMU ID: 23048681  
 * NAME: Sambridhi Shrestha
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Flight" })
public class FlightController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public FlightController() {
        super();
    }

    /**
     * Handles HTTP GET requests.
     * Forwards the request to the flight JSP page.
     *
     * @param request  the HttpServletRequest containing client request
     * @param response the HttpServletResponse to send response to client
     * @throws ServletException if servlet-specific error occurs
     * @throws IOException      if I/O error occurs during processing
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/flight.jsp").forward(request, response);
    }

    /**
     * Handles HTTP POST requests by delegating to doGet.
     *
     * @param request  the HttpServletRequest containing client request
     * @param response the HttpServletResponse to send response to client
     * @throws ServletException if servlet-specific error occurs
     * @throws IOException      if I/O error occurs during processing
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
