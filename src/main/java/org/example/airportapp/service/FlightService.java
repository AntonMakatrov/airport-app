package org.example.airportapp.service;

import org.example.airportapp.core.dto.Flight;
import org.example.airportapp.core.dto.FlightFilter;
import org.example.airportapp.core.dto.Pageable;
import org.example.airportapp.dao.api.IFlightDao;
import org.example.airportapp.service.api.IFlightService;

import java.util.List;

public class FlightService implements IFlightService {
    private final IFlightDao dao;

    public FlightService(IFlightDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Flight> getAll() {
        return this.dao.getAll();
    }

    @Override
    public List<Flight> getPage(Pageable pageable) {
        return this.dao.getPage(pageable);
    }

    @Override
    public List<Flight> getPage(FlightFilter filter, Pageable pageable) {

        return this.dao.getPage(filter, pageable);
    }
}
