package org.example.airportapp.endpoints.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.airportapp.core.entity.Aircraft;
import org.example.airportapp.service.api.IAircraftService;
import org.example.airportapp.service.factory.AircraftServiceFactory;

import java.io.IOException;
import java.util.List;

@WebServlet("/json/aircraft")
public class AircraftServletJson extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private final IAircraftService service;

    public AircraftServletJson() {
        this.service = AircraftServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Aircraft> data = this.service.getAll();
        objectMapper.writeValue(resp.getWriter(), data);
    }
}
