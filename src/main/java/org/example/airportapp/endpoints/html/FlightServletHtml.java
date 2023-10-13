package org.example.airportapp.endpoints.html;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.airportapp.core.entity.Airport;
import org.example.airportapp.core.entity.Flight;
import org.example.airportapp.service.api.IFlightService;
import org.example.airportapp.service.factory.FlightServiceFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/html/flight")
public class FlightServletHtml extends HttpServlet {
    private IFlightService flightService = FlightServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pageRaw = req.getParameter("page");
        int page = (pageRaw != null && !pageRaw.isEmpty()) ? Integer.parseInt(pageRaw) : 1;
        String sizeRaw = req.getParameter("size");
        int size = (sizeRaw != null && !sizeRaw.isEmpty()) ? Integer.parseInt(sizeRaw) : 50;
        String fromDateString = req.getParameter("fromDate");
        String toDateString = req.getParameter("toDate");
        String departureAirport = req.getParameter("departureAirport");
        String arrivalAirport = req.getParameter("arrivalAirport");
        String status = req.getParameter("status");

        Timestamp fromDate = (fromDateString == null || fromDateString.isEmpty()) ? null : Timestamp.valueOf(fromDateString);
        Timestamp toDate = (toDateString == null || toDateString.isEmpty()) ? null : Timestamp.valueOf(toDateString);



        try {
            List<Flight> data = this.flightService.getFilteredFlights(fromDate,toDate,departureAirport,arrivalAirport,
                        status,page,size);
            req.setAttribute("data", data);
            req.getRequestDispatcher("/views/flights.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}