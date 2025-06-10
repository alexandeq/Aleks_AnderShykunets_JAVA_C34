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
//@WebServlet("/change")
//public class ChangeServlet extends HttpServlet   {
//
//    private GoodService service = new GoodService();
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        var action = req.getParameter("action");
//
//        if(action.equalsIgnoreCase("delete")){
//            service.delete(UUID.fromString(req.getParameter("id")));
//            req.getRequestDispatcher("/home").forward(req,resp);
//        } else {
//
//            var id = UUID.fromString(req.getParameter("id"));
//            var good = service.getById(id);
//
//            req.setAttribute("good",good);
//            req.getRequestDispatcher("/WEB-INF/change.jsp").forward(req,resp);
//
//        }
//
//
//    }
//}
