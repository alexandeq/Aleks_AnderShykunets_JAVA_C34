package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.QuizService;

import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private QuizService service = new QuizService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var all = service.getAll();
        req.setAttribute("quizs", all);

        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var all = service.getAll();
        req.setAttribute("quizs", all);

        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}

