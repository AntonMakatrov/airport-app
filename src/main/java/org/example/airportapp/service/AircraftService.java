package org.example.airportapp.service;

import org.example.airportapp.core.dto.Aircraft;
import org.example.airportapp.dao.api.IAircraftDao;
import org.example.airportapp.service.api.IAircraftService;

import java.util.List;
import java.util.stream.Collectors;

public class AircraftService implements IAircraftService {
    private final IAircraftDao dao;

    public AircraftService(IAircraftDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Aircraft> getAll() {
        return this.dao.getAll().stream()
                .map(aircraftEntity -> new Aircraft(aircraftEntity.getAircraftCode(), aircraftEntity.getModel(), aircraftEntity.getRange()))
                .collect(Collectors.toList());
    }
}
