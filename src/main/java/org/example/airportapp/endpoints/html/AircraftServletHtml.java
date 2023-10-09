package org.example.airportapp.endpoints.html;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.airportapp.core.entity.Aircraft;
import org.example.airportapp.service.api.IAircraftService;
import org.example.airportapp.service.factory.AircraftServiceFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/html/aircraft")
public class AircraftServletHtml extends HttpServlet {
    private IAircraftService aircraftService = AircraftServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("<html><body>");
        try {
            for(Aircraft airCraft : aircraftService.getAllAircrafts()){
                writer.write(airCraft.getAircraftCode() + "</br>"
                        + airCraft.getModel() + "</br>"
                        + airCraft.getRange() + "</p>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        writer.write("</body></html>");
    }
}
