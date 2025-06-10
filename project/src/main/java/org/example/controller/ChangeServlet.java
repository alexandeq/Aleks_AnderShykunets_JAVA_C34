package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.QuizDto;
import org.example.service.QuizService;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/change")
public class ChangeServlet extends HttpServlet {

    private QuizService service = new QuizService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var allAnswers = service.getAllAnswers();
        req.setAttribute("answers", allAnswers);
        var action = req.getParameter("action");

        if(action.equalsIgnoreCase("Удалить")){
            service.delete(UUID.fromString(req.getParameter("id")));
            req.getRequestDispatcher("/home").forward(req,resp);
        } else {

           var id = UUID.fromString(req.getParameter("id"));
           var quiz = service.getById(id);

           req.setAttribute("quiz", quiz);
           req.getRequestDispatcher("/WEB-INF/change.jsp").forward(req, resp);


        }

    }
}
