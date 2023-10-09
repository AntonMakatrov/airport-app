package org.example.airportapp.dao.api;

import org.example.airportapp.core.entity.Flight;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface IFlightDao {
    List<Flight> getAllFlights() throws SQLException;

    List<Flight> getFilteredFlights(Timestamp fromDate,
                                    Timestamp toDate,
                                    String departureAirport,
                                    String arrivalAirport,
                                    String status) throws SQLException;
}
