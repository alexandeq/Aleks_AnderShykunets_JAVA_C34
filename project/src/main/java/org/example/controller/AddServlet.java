package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.QuizDto;
import org.example.service.QuizService;

import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    private QuizService service= new QuizService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String question = req.getParameter("question");
        String answer = req.getParameter("answer");

        QuizDto quizDto = new QuizDto(question,answer);

        service.save(quizDto);

        req.getRequestDispatcher("/home").forward(req,resp);



    }
}
