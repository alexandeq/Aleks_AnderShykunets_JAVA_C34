package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.QuizDto;
import org.example.service.QuizService;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    private QuizService service = new QuizService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var id = UUID.fromString(req.getParameter("id"));
        String question = req.getParameter("question");
        String answer = req.getParameter("answer");
        QuizDto quizDto = new QuizDto(question, answer);
        service.update(id,quizDto);
        req.getRequestDispatcher("/home").forward(req,resp);



    }
}
