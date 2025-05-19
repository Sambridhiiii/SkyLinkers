package com.Skylinker.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Utility class for managing common page redirection and setting request attributes.
 * Contains predefined JSP paths for convenient use throughout the application.
 * 
 * LMU ID: 23048681  
 * NAME: Sambridhi Shrestha
 */
public class RedirectionUtil {

    private static final String baseUrl = "/WEB-INF/pages/";
    public static final String registerUrl = baseUrl + "register.jsp";
    public static final String loginUrl = baseUrl + "login.jsp";
    public static final String homeUrl = baseUrl + "home.jsp";
    public static final String adminUrl = baseUrl + "admindashboard.jsp";

    /**
     * Sets a message attribute on the request.
     *
     * @param req     the HttpServletRequest
     * @param msgType the attribute key (e.g., "error", "success")
     * @param msg     the message content
     */
    public static void setMsgAttribute(HttpServletRequest req, String msgType, String msg) {
        req.setAttribute(msgType, msg);
    }

    /**
     * Forwards the request to the specified JSP page.
     *
     * @param req  the HttpServletRequest
     * @param resp the HttpServletResponse
     * @param page the JSP page path to forward to
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs during forwarding
     */
    public static void redirectToPage(HttpServletRequest req, HttpServletResponse resp, String page)
            throws ServletException, IOException {
        req.getRequestDispatcher(page).forward(req, resp);
    }

    /**
     * Sets a message attribute on the request and forwards to the specified page.
     *
     * @param req     the HttpServletRequest
     * @param resp    the HttpServletResponse
     * @param msgType the attribute key
     * @param msg     the message content
     * @param page    the JSP page path to forward to
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs during forwarding
     */
    public static void setMsgAndRedirect(HttpServletRequest req, HttpServletResponse resp, String msgType, String msg,
            String page) throws ServletException, IOException {
        setMsgAttribute(req, msgType, msg);
        redirectToPage(req, resp, page);
    }
}
