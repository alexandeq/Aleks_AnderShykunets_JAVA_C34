package controller;

import domain.Car;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/rdct")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var cars = List.of(
                new Car(1, "Mercedes-benz",180000),
                new Car(2, "Porsche",200000),
                new Car(3, "Volkswagen",140000),
                new Car(4, "BMW",100000));


        req.setAttribute("cars", cars);

        req.getRequestDispatcher("/file.jsp").forward(req, resp);

    }
}