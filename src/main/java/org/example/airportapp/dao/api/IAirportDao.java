package org.example.airportapp.dao.api;

import org.example.airportapp.core.entity.Airport;

import java.sql.SQLException;
import java.util.List;

public interface IAirportDao {
    List<Airport> getAllAirports() throws SQLException;
}
