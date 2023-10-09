package org.example.airportapp.service.api;


import org.example.airportapp.core.entity.Flight;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface IFlightService {
    List<Flight> getAllFlights() throws SQLException;

    List<Flight> getFilteredFlights(Timestamp fromDate,
                                    Timestamp toDate,
                                    String departureAirport,
                                    String arrivalAirport,
                                    String status) throws SQLException;
}
