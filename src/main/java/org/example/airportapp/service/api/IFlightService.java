package org.example.airportapp.service.api;

import org.example.airportapp.core.entity.Flight;
import org.example.airportapp.core.entity.FlightFilter;
import org.example.airportapp.core.entity.Pageable;

import java.util.List;

public interface IFlightService {
    List<Flight> getAll();

    List<Flight> getPage(Pageable pageable);

    List<Flight> getPage(FlightFilter filter, Pageable pageable);
}
