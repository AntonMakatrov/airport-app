package org.example.airportapp.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.airportapp.core.dto.Airport;
import org.example.airportapp.service.api.IAirportService;
import org.example.airportapp.service.factory.AirportServiceFactory;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/api/aircrafts")
public class AirportServletJson extends HttpServlet {

    private final IAirportService service;
    private static final ObjectMapper mapper = new ObjectMapper();
    public AirportServletJson() {
        this.service = AirportServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Airport> data = this.service.getAll();
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(mapper.writeValueAsString(data));
    }
}