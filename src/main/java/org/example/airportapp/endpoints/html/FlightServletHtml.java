package org.example.airportapp.endpoints.html;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.airportapp.core.entity.Flight;
import org.example.airportapp.service.api.IFlightService;
import org.example.airportapp.service.factory.FlightServiceFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/html/flight")
public class FlightServletHtml extends HttpServlet {
    private IFlightService flightService = FlightServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        PrintWriter writer = resp.getWriter();
        writer.write("<html><body>");
        try {
            for(Flight flight : flightService.getFilteredFlights()){
                writer.write(flight.getFlightId() + "</br>"
                        + flight.getFlightNo() + "</br>"
                        + flight.getScheduledDeparture() + "</br>"
                        + flight.getScheduledArrival() + "</br>"
                        + flight.getDepartureAirport() + "</br>"
                        + flight.getArrivalAirport() + "</br>"
                        + flight.getStatus() + "</br>"
                        + flight.getAircraftCode() + "</br>"
                        + flight.getActualDeparture() + "</br>"
                        + flight.getActualArrival() + "</p>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
