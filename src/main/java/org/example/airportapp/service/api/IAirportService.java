package org.example.airportapp.service.api;

import org.example.airportapp.core.dto.Airport;

import java.util.List;

public interface IAirportService {
    List<Airport> getAll();
}
