package org.example.airportapp.endpoints.html;

import jakarta.servlet.ServletException;
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
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/html/flight")
public class FlightServletHtml extends HttpServlet {
    private IFlightService flightService = FlightServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Параметры фильтрации
        Timestamp fromDate = Timestamp.valueOf(req.getParameter("fromDate"));
        Timestamp toDate = Timestamp.valueOf(req.getParameter("toDate"));
        String departureAirport = req.getParameter("departureAirport");
        String arrivalAirport = req.getParameter("arrivalAirport");
        String status = req.getParameter("status");

        // Параметры пагинации
        int page = 1;
        int recordsPerPage = 10;

        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }

        try {
            // Получите отфильтрованный список полетов
            List<Flight> filteredFlights = flightService.getFilteredFlights(
                    fromDate, toDate, departureAirport, arrivalAirport, status);

            int totalRecords = filteredFlights.size();
            int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);

            int startIdx = (page - 1) * recordsPerPage;
            int endIdx = Math.min(startIdx + recordsPerPage, totalRecords);

            List<Flight> currentPageFlights = filteredFlights.subList(startIdx, endIdx);

            req.setAttribute("flightList", currentPageFlights);
            req.setAttribute("totalPages", totalPages);
            req.setAttribute("currentPage", page);

            req.getRequestDispatcher("/views/flights.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
