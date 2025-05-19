package com.Skylinker.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.Skylinker.util.CookiesUtil;
import com.Skylinker.util.SessionUtil;

/**
 * LogoutController handles user logout functionality.
 * It deletes the user's role cookie, invalidates the session,
 * and redirects to the login page with a logout success message.
 * 
 * LMU ID: 23048681  
 * NAME: Sambridhi Shrestha
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/LogoutController"})
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles HTTP GET requests to perform logout.
     * Deletes the role cookie, invalidates the session,
     * and redirects the user to the login page with a logout success indicator.
     *
     * @param request  HttpServletRequest containing client request
     * @param response HttpServletResponse to send response
     * @throws ServletException if servlet-specific error occurs
     * @throws IOException      if I/O error occurs during processing
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Delete role cookie
        CookiesUtil.deleteCookie(response, "role");

        // Invalidate user session
        SessionUtil.invalidateSession(request);

        // Redirect to login page with logout success parameter
        response.sendRedirect(request.getContextPath() + "/login.jsp?logout=success");
    }
}
