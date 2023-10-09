package org.example.airportapp.endpoints.html;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.airportapp.core.entity.Airport;
import org.example.airportapp.service.api.IAirportService;
import org.example.airportapp.service.factory.AirportServiceFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/html/airport")
public class AirportServletHtml extends HttpServlet {
    private IAirportService airportService = AirportServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("<html><body>");
        try {
            for(Airport airport : airportService.getAllAirports()){
                writer.write(airport.getAirportCode() + "</br>"
                        + airport.getAirportName() + "</br>"
                        + airport.getCity() + "</br>"
                        + airport.getCoordinates() + "</br>"
                        + airport.getTimezone() + "</p>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
