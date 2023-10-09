package org.example.airportapp.endpoints.json;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.airportapp.core.entity.Flight;
import org.example.airportapp.service.api.IFlightService;
import org.example.airportapp.service.factory.FlightServiceFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class FlightServletJson extends HttpServlet {
    private IFlightService flightService = FlightServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        writer.println("[");
        try {
            for (Flight flight: flightService.getAllFlights()) {
                writer.println("{");
                writer.println("\"airportCode\": \"" + flight.getFlightId() + "\",");
                writer.println("\"airportName\": \"" + flight.getFlightNo() + "\",");
                writer.println("\"city\": \"" + flight.getScheduledDeparture() + "\",");
                writer.println("\"coordinates\": \"" + flight.getScheduledArrival() + "\",");
                writer.println("\"city\": \"" + flight.getDepartureAirport() + "\",");
                writer.println("\"city\": \"" + flight.getArrivalAirport() + "\",");
                writer.println("\"city\": \"" + flight.getStatus() + "\",");
                writer.println("\"city\": \"" + flight.getAircraftCode() + "\",");
                writer.println("\"city\": \"" + flight.getActualDeparture() + "\",");
                writer.println("\"timezone\": " + flight.getActualArrival());
                writer.println("}");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        writer.println("]");
    }
}
