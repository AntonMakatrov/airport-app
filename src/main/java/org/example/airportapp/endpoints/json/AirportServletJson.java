package org.example.airportapp.endpoints.json;

import jakarta.servlet.ServletException;
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

@WebServlet("/json/airport")
public class AirportServletJson extends HttpServlet {
    private IAirportService airportService = AirportServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        writer.println("[");
        try {
            for (Airport airport: airportService.getAllAirports()) {
                writer.println("{");
                writer.println("\"airportCode\": \"" + airport.getAirportCode() + "\",");
                writer.println("\"airportName\": \"" + airport.getAirportName() + "\",");
                writer.println("\"city\": \"" + airport.getCity() + "\",");
                writer.println("\"coordinates\": \"" + airport.getCoordinates() + "\",");
                writer.println("\"timezone\": " + airport.getTimezone());
                writer.println("}");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        writer.println("]");
    }
}

