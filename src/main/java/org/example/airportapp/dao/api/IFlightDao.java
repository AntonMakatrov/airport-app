package org.example.airportapp.dao.api;

import org.example.airportapp.core.dto.Flight;
import org.example.airportapp.core.dto.FlightFilter;
import org.example.airportapp.core.dto.Pageable;

import java.util.List;

public interface IFlightDao {
    List<Flight> getAll();

    List<Flight> getPage(Pageable pageable);

    List<Flight> getPage(FlightFilter filter, Pageable pageable);
}
