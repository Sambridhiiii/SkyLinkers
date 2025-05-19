package com.Skylinker.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.Skylinker.model.CustomerModel;
import com.Skylinker.service.LoginService;
import com.Skylinker.util.CookiesUtil;
import com.Skylinker.util.RedirectionUtil;
import com.Skylinker.util.SessionUtil;

/**
 * LoginController handles user login requests.
 * It processes authentication, manages sessions and cookies,
 * and redirects users based on their roles.
 * 
 * LMU ID: 23048681  
 * NAME: Sambridhi Shrestha
 */
@WebServlet(asyncSupported = true, name = "LoginController", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private LoginService login;
    
    @Override
    public void init() throws ServletException {
        login = new LoginService();
    }
    
    /**
     * Handles HTTP GET requests.
     * Forwards the request to the login JSP page.
     *
     * @param req  HttpServletRequest containing client request
     * @param resp HttpServletResponse to send response
     * @throws ServletException if servlet-specific error occurs
     * @throws IOException      if I/O error occurs during processing
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        req.getRequestDispatcher(RedirectionUtil.loginUrl).forward(req, resp);
    }

    /**
     * Handles HTTP POST requests.
     * Validates user input and processes login authentication.
     * Sets session attributes and cookies based on user role.
     * Redirects user to appropriate page upon success or failure.
     *
     * @param req  HttpServletRequest containing client request
     * @param resp HttpServletResponse to send response
     * @throws ServletException if servlet-specific error occurs
     * @throws IOException      if I/O error occurs during processing
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Validate inputs
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            req.setAttribute("error", "Email or Password cannot be empty!");
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
            return;
        }

        // Create customer model and attempt login
        CustomerModel customerModel = new CustomerModel(email, password);
        Boolean loginStatus = login.loginUser(customerModel);
        
        if (Boolean.TRUE.equals(loginStatus)) {
            SessionUtil.setAttribute(req, "email", email);

            if ("admin@gmail.com".equals(email)) {
                CookiesUtil.addCookie(resp, "role", "admin", 5 * 30);
                resp.sendRedirect(req.getContextPath() + "/AdminDashboard?login=success");
            } else {
                CookiesUtil.addCookie(resp, "role", "customer", 5 * 30);
                resp.sendRedirect(req.getContextPath() + "/home?login=success");
            }
        } else {
            handleLoginFailure(req, resp, loginStatus);
        }
    }

    /**
     * Handles login failures by setting appropriate error messages,
     * logging the failure, and forwarding back to the login page.
     *
     * @param req         HttpServletRequest containing client request
     * @param resp        HttpServletResponse to send response
     * @param loginStatus Boolean login status (null if server issue)
     * @throws ServletException if servlet-specific error occurs
     * @throws IOException      if I/O error occurs during processing
     */
    private void handleLoginFailure(HttpServletRequest req, HttpServletResponse resp, Boolean loginStatus)
            throws ServletException, IOException {
        String errorMessage = (loginStatus == null)
                ? "Our server is under maintenance. Please try again later!"
                : "User credential mismatch. Please try again!";
        req.setAttribute("error", errorMessage);
        
        // Log failure for debugging
        System.out.println("Login failed for user: " + req.getParameter("email"));
        
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }
}
