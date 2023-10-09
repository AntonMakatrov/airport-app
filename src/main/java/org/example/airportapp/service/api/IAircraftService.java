package org.example.airportapp.service.api;

import org.example.airportapp.core.entity.Aircraft;

import java.sql.SQLException;
import java.util.List;

public interface IAircraftService {
    List<Aircraft> getAllAircrafts() throws SQLException;
}
