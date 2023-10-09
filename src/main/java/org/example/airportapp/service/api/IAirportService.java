package org.example.airportapp.service.api;

import org.example.airportapp.core.entity.Airport;

import java.sql.SQLException;
import java.util.List;

public interface IAirportService {
    List<Airport> getAllAirports() throws SQLException;
}
