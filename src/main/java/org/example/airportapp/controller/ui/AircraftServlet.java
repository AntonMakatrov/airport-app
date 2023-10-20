package org.example.airportapp.controller.ui;

import org.example.airportapp.core.dto.Aircraft;
import org.example.airportapp.service.api.IAircraftService;
import org.example.airportapp.service.factory.AircraftServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/aircrafts")
public class AircraftServlet extends HttpServlet {

    private final IAircraftService service;

    public AircraftServlet() {
        this.service = AircraftServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Aircraft> data = this.service.getAll();
        req.setAttribute("data", data);
        req.getRequestDispatcher("/views/aircrafts.jsp").forward(req, resp);
    }
}
