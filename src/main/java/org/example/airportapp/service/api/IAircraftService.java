package org.example.airportapp.service.api;

import org.example.airportapp.core.dto.Aircraft;

import java.util.List;

public interface IAircraftService {
    List<Aircraft> getAll();
}
