package org.example.airportapp.endpoints.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.airportapp.core.entity.Aircraft;
import org.example.airportapp.core.entity.Airport;
import org.example.airportapp.service.api.IAircraftService;
import org.example.airportapp.service.api.IAirportService;
import org.example.airportapp.service.factory.AircraftServiceFactory;
import org.example.airportapp.service.factory.AirportServiceFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/json/airport")
public class AirportServletJson extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private final IAirportService service;

    public AirportServletJson() {
        this.service = AirportServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Airport> data = this.service.getAll();
        objectMapper.writeValue(resp.getWriter(), data);
    }
}

