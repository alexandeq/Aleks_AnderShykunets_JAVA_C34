package org.example.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        PrintWriter writer = resp.getWriter();
        writer.println("<body>Local date is: " + localDate + "<br/>Local time is: " + localTime + "</body>");

    }
}