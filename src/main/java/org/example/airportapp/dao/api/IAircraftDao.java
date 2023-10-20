package org.example.airportapp.dao.api;

import org.example.airportapp.dao.entity.AircraftEntity;

import java.util.List;

public interface IAircraftDao {
    List<AircraftEntity> getAll();
}
