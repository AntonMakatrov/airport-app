package org.example.airportapp.service;

import org.example.airportapp.core.dto.Airport;
import org.example.airportapp.dao.api.IAirportDao;
import org.example.airportapp.service.api.IAirportService;

import java.util.List;
import java.util.stream.Collectors;

public class AirportService implements IAirportService {
    private final IAirportDao dao;

    public AirportService(IAirportDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Airport> getAll() {
        return this.dao.getAll().stream()
                .map(airportEntity -> new Airport(airportEntity.getAirportCode(), airportEntity.getAirportName(),
                        airportEntity.getCity(), airportEntity.getCoordinates(), airportEntity.getTimezone()))
                .collect(Collectors.toList());
    }
}
