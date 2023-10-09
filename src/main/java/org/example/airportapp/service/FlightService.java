package org.example.airportapp.service;

import org.example.airportapp.core.entity.Airport;
import org.example.airportapp.core.entity.Flight;
import org.example.airportapp.dao.api.IAirportDao;
import org.example.airportapp.dao.api.IFlightDao;
import org.example.airportapp.service.api.IFlightService;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class FlightService implements IFlightService {
    IFlightDao flightDao;
    public FlightService(IFlightDao instance) {
        this.flightDao = instance;
    }

    @Override
    public List<Flight> getAllFlights() throws SQLException {
        return flightDao.getAllFlights();
    }

    @Override
    public List<Flight> getFilteredFlights(Timestamp fromDate,
                                           Timestamp toDate,
                                           String departureAirport,
                                           String arrivalAirport,
                                           String status) throws SQLException{
        return flightDao.getFilteredFlights(fromDate,toDate,departureAirport,arrivalAirport,status);
    }
}
