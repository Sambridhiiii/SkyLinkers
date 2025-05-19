package com.Skylinker.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.Skylinker.model.CustomerModel;
import com.Skylinker.service.RegisterService;
import com.Skylinker.util.ValidationUtil;

/**
 * RegisterController handles user registration requests.
 * It validates input data, registers customers, and forwards to appropriate JSP pages.
 * 
 * LMU ID: 23048681  
 * NAME: Sambridhi Shrestha
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles HTTP GET requests.
     * Forwards the request to the registration JSP page.
     *
     * @param request  the HttpServletRequest containing client request
     * @param response the HttpServletResponse to send response to client
     * @throws ServletException if servlet-specific error occurs
     * @throws IOException      if an I/O error occurs during processing
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(request, response);
    }

    /**
     * Handles HTTP POST requests.
     * Validates customer registration form data and attempts registration.
     * On success, forwards to login page with success message.
     * On failure, forwards back to registration page with error messages.
     *
     * @param request  the HttpServletRequest containing client request
     * @param response the HttpServletResponse to send response to client
     * @throws ServletException if servlet-specific error occurs
     * @throws IOException      if an I/O error occurs during processing
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            // First validate the form
            String validationErrors = validateCustomerForm(request);
            if (validationErrors != null) {
                throw new IllegalArgumentException(validationErrors);
            }
            
            // If validation passed, proceed with registration
            CustomerModel customerModel = extractCustomer(request);
            RegisterService service = new RegisterService();
            
            if (service.registerCustomer(customerModel)) {
                request.setAttribute("success", "Registration successful! Please login.");
                request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
            } else {
                throw new Exception("Registration failed");
            }
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Registration failed. Please try again.");
            request.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(request, response);
        }
    }

    /**
     * Validates the customer registration form inputs.
     * Checks for null or empty values and validates format of each field.
     *
     * @param req the HttpServletRequest containing form parameters
     * @return a concatenated string of error messages if any validation fails, null otherwise
     */
    private String validateCustomerForm(HttpServletRequest req) {
        StringBuilder errors = new StringBuilder();
        
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        if (ValidationUtil.isNullOrEmpty(firstName))
            errors.append("First name is required.<br>");
        else if (!ValidationUtil.isValidFirstName(firstName))
            errors.append("First name must contain only letters (2-50 characters).<br>");
        
        if (ValidationUtil.isNullOrEmpty(lastName))
            errors.append("Last name is required.<br>");
        else if (!ValidationUtil.isValidLastName(lastName))
            errors.append("Last name must contain only letters (2-50 characters).<br>");
        
        if (ValidationUtil.isNullOrEmpty(email))
            errors.append("Email address is required.<br>");
        else if (!ValidationUtil.isValidEmail(email))
            errors.append("Invalid email format.<br>");
        
        if (ValidationUtil.isNullOrEmpty(phone))
            errors.append("Phone number is required.<br>");
        else if (!ValidationUtil.isValidPhoneNumber(phone))
            errors.append("Phone number must be 10 digits.<br>");
        
        if (ValidationUtil.isNullOrEmpty(password))
            errors.append("Password is required.<br>");
        else if (!ValidationUtil.isValidPassword(password))
            errors.append("Password must be at least 8 characters with 1 uppercase, 1 lowercase, 1 number and 1 special character.<br>");
        
        if (ValidationUtil.isNullOrEmpty(confirmPassword))
            errors.append("Please confirm your password.<br>");
        else if (!ValidationUtil.doPasswordsMatch(password, confirmPassword))
            errors.append("Passwords do not match.<br>");
        
        return errors.length() == 0 ? null : errors.toString();
    }

    /**
     * Extracts customer information from the request and creates a CustomerModel.
     *
     * @param request the HttpServletRequest containing form parameters
     * @return a CustomerModel object populated with form data
     * @throws IllegalArgumentException if required fields are missing
     */
    private CustomerModel extractCustomer(HttpServletRequest request) throws IllegalArgumentException {
        String firstname = request.getParameter("firstName");
        String lastname = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        return new CustomerModel(firstname, lastname, email, phone, password);
    }
}
