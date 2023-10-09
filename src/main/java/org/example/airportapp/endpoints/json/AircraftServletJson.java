package org.example.airportapp.endpoints.json;

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

@WebServlet("/json/aircraft")
public class AircraftServletJson extends HttpServlet {
    private IAircraftService aircraftService = AircraftServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        writer.println("[");
        try {
            for (Aircraft aircraft: aircraftService.getAllAircrafts()) {
                writer.println("{");
                writer.println("\"aircraftCode\": \"" + aircraft.getAircraftCode() + "\",");
                writer.println("\"model\": \"" + aircraft.getModel() + "\",");
                writer.println("\"range\": " + aircraft.getRange());
                writer.println("}");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        writer.println("]");
    }
}
