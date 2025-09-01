package org.example.web;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/admin")
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String role = servletRequest.getParameter("role");

        if (role == null) {
            throw new ServletException("role parameter is required");
        }

        if ("ADMIN".equals(role)){
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}

