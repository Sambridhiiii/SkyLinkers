package com.Skylinker.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.Skylinker.util.CookiesUtil;
import com.Skylinker.util.SessionUtil;

/**
 * AuthenticationFilter intercepts all incoming HTTP requests to enforce
 * access control based on user login status and role.
 * It redirects users appropriately if they attempt unauthorized access.
 * It also sets the appropriate header JSP based on user role.
 * 
 * LMU ID: 23048681  
 * NAME: Sambridhi Shrestha
 */
@WebFilter(asyncSupported = true, urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

    private static final String LOGIN = "/login";
    private static final String REGISTER = "/register";
    private static final String HOME = "/Home";
    private static final String ROOT = "/";
    private static final String BOOKING = "/CustomerBooking";
    private static final String ADMIN_DASHBOARD = "/AdminDashboard";
    private static final String FLIGHT = "/Flight";
    private static final String CUSTOMER_PROFILE = "/Customer";
    private static final String ADMIN_PROFILE = "/AdminProfile";
    private static final String ABOUT_US = "/AboutUs";
    private static final String CONTACT = "/Contact";
    private static final String LOGOUT = "/LogoutController";

    /**
     * Initializes the filter.
     *
     * @param filterConfig the configuration object provided by the servlet container
     * @throws ServletException if an error occurs during filter initialization
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if required
    }

    /**
     * Performs filtering of incoming requests, enforcing authentication and role-based access control.
     * Allows free access to static resources and login/registration pages.
     * Redirects users attempting to access unauthorized resources based on their login status and role.
     *
     * @param request  the ServletRequest object containing the client request
     * @param response the ServletResponse object to send response to the client
     * @param chain    the FilterChain for invoking the next filter or resource
     * @throws IOException      if an I/O error occurs during processing
     * @throws ServletException if a servlet-specific error occurs during processing
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        // Allow access to static resources and logout without authentication
        if (uri.endsWith(".png") || uri.endsWith(".jpg") || uri.endsWith(".css") ||
                uri.endsWith(LOGOUT)) {
            chain.doFilter(request, response);
            return;
        }

        boolean isLoggedIn = SessionUtil.getAttribute(req, "email") != null;
        String userRole = CookiesUtil.getCookie(req, "role") != null 
                ? CookiesUtil.getCookie(req, "role").getValue() : null;

        // Set the header to include based on user role
        if ("admin".equals(userRole)) {
            request.setAttribute("headerToInclude", "/WEB-INF/pages/header.jsp");
        } else if ("customer".equals(userRole)) {
            request.setAttribute("headerToInclude", "/WEB-INF/pages/customerheader.jsp");
        }

        if (isLoggedIn) {
            if ("admin".equals(userRole)) {
                // Admin-specific access control
                if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER)) {
                    res.sendRedirect(req.getContextPath() + ADMIN_DASHBOARD);
                } else if (uri.endsWith(ADMIN_DASHBOARD) || uri.endsWith(FLIGHT)
                        || uri.endsWith(ADMIN_PROFILE) || uri.endsWith(ABOUT_US) || uri.endsWith(CONTACT)
                        || uri.endsWith(HOME) || uri.endsWith(LOGOUT) || uri.endsWith(ROOT)) {
                    chain.doFilter(request, response);
                } else {
                    res.sendRedirect(req.getContextPath() + ADMIN_DASHBOARD);
                }
            } else if ("customer".equals(userRole)) {
                // Customer-specific access control
                if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER)) {
                    res.sendRedirect(req.getContextPath() + HOME);
                    return;
                }
                if (uri.endsWith(HOME) || uri.endsWith(ROOT) || uri.endsWith(ABOUT_US) || uri.endsWith(BOOKING)
                        || uri.endsWith(CONTACT) || uri.endsWith(CUSTOMER_PROFILE) || uri.endsWith(LOGOUT)) {
                    chain.doFilter(request, response);
                } else {
                    res.sendRedirect(req.getContextPath() + HOME);
                }
            }
        } else {
            // Not logged in: allow only login, register, and root
            if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER) || uri.endsWith(ROOT)) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect(req.getContextPath() + LOGIN);
            }
        }
    }

    // Implement destroy if needed
    @Override
    public void destroy() {
        // Cleanup code if necessary
    }
}
