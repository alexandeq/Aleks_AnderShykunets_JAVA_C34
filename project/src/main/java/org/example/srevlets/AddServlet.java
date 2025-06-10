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
//
//@WebServlet("/add")
//public class AddServlet extends HttpServlet {
//
//    private GoodService service = new GoodService();
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String title = req.getParameter("title");
//        String description = req.getParameter("description");
//        Long price = Long.parseLong(req.getParameter("price"));
//
//        Good good = new Good(title, description, price);
//        service.save(good);
//
//        req.getRequestDispatcher("/home").forward(req,resp);
//
//
//    }
//}