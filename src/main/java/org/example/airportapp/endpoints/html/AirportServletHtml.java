package org.example.airportapp.endpoints.html;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.airportapp.core.entity.Airport;
import org.example.airportapp.service.api.IAirportService;
import org.example.airportapp.service.factory.AirportServiceFactory;

import java.io.IOException;
import java.util.List;

@WebServlet("/html/airport")
public class AirportServletHtml extends HttpServlet {
    private final IAirportService service;

    public AirportServletHtml() {
        this.service = AirportServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Airport> data = this.service.getAll();
        req.setAttribute("data", data);
        req.getRequestDispatcher("/view/airport.jsp").forward(req, resp);
    }
}
