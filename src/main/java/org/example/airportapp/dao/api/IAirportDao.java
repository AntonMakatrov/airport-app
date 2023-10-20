package org.example.airportapp.dao.api;

import org.example.airportapp.dao.entity.AirportEntity;

import java.util.List;

public interface IAirportDao {
    List<AirportEntity> getAll();
}
