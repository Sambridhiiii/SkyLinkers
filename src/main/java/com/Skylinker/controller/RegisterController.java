package com.Skylinker.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.Skylinker.model.CustomerModel;
import com.Skylinker.service.RegisterService;
import com.Skylinker.util.PasswordUtil;

/**
 * Servlet implementation class RegisterControllers
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private RegisterService service;

    public RegisterController() {
        super();
        this.service = new RegisterService(); // Initialize service
    }

    // Handles GET request - displays registration form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(request, response);
    }

    // Handles POST request - processes registration
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Extract user info from form input
            CustomerModel customerModel = extractCustomer(request);
            System.out.println("Extracted Customer: " + customerModel.getEmail());

            // Attempt registration
            Boolean isRegistered = service.registerCustomer(customerModel);
            System.out.println("Registration result: " + isRegistered);

            // Handle outcome
            if (isRegistered == null) {
                handleError(request, response, "Our server is under maintenance. Please try again later!");
            } else if (isRegistered) {
                System.out.println("User registered successfully.");
                handleSuccess(request, response, "Your account is successfully created!", "/WEB-INF/pages/login.jsp");
            } else {
                handleError(request, response, "Could not register your account. Please try again later!");
            }
        } catch (Exception e) {
            handleError(request, response, "An unexpected error occurred. Please try again later!");
            e.printStackTrace();
        }
    }

    /**
     * Extracts and validates customer data from the request
     */
    private CustomerModel extractCustomer(HttpServletRequest request) throws Exception {
        String firstname = request.getParameter("firstName");
        String lastname = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (password == null || !password.equals(confirmPassword)) {
            throw new Exception("Passwords do not match or are invalid.");
        }

        // Encrypt password before storing
        String encryptedPassword = PasswordUtil.encrypt(email, password);

        return new CustomerModel(firstname, lastname, email, phone, encryptedPassword);
    }

    /**
     * Displays success message and forwards to a given page
     */
    private void handleSuccess(HttpServletRequest request, HttpServletResponse response, String message, String redirectPage) throws ServletException, IOException {
        request.setAttribute("success", message);
        request.getRequestDispatcher(redirectPage).forward(request, response);
    }

    /**
     * Displays error message and returns to the registration form
     */
    private void handleError(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("error", message);
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
    }
}
