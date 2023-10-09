package org.example.airportapp.dao.api;

import org.example.airportapp.core.entity.Aircraft;

import java.sql.SQLException;
import java.util.List;

public interface IAircraftDao {
    List<Aircraft> getAllAircrafts() throws SQLException;
}
