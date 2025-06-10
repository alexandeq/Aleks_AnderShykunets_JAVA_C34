//package org.example.srevlets;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.example.dto.Good;
//import org.example.service.GoodService;
//
//import java.io.IOException;
//import java.util.UUID;
//
//@WebServlet("/edit")
//public class EditServlet extends HttpServlet {
//
//    private GoodService service = new GoodService();
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        var id = UUID.fromString(req.getParameter("id"));
//        String title = req.getParameter("title");
//        String description = req.getParameter("description");
//        Long price = Long.parseLong(req.getParameter("price"));
//
//        Good good = new Good(title, description, price);
//
//        service.update(id,good);
//
//        req.getRequestDispatcher("/home").forward(req,resp);
//    }
//}
