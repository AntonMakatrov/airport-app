package org.example.airportapp.endpoints.html;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.airportapp.core.entity.Aircraft;
import org.example.airportapp.service.api.IAircraftService;
import org.example.airportapp.service.factory.AircraftServiceFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/html/aircraft")
public class AircraftServletHtml extends HttpServlet {
    private final IAircraftService service;

    public AircraftServletHtml() {
        this.service = AircraftServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Aircraft> data = this.service.getAll();
        req.setAttribute("data", data);
        req.getRequestDispatcher("/view/aircraft.jsp").forward(req, resp);
    }
}
