package com.Skylinker.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AboutUsController handles requests for the About Us page.
 * It forwards GET requests to the aboutus.jsp page.
 * 
 * LMU ID: 23048681  
 * NAME: Sambridhi Shrestha
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AboutUs" })
public class AboutUsController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public AboutUsController() {
        super();
    }

    /**
     * Handles the HTTP GET method.
     * Forwards the request to the About Us JSP page.
     *
     * @param request  the HttpServletRequest object containing client request
     * @param response the HttpServletResponse object to send response to client
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs during processing
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/aboutus.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP POST method.
     * Forwards POST requests to the GET handler.
     *
     * @param request  the HttpServletRequest object containing client request
     * @param response the HttpServletResponse object to send response to client
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs during processing
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
