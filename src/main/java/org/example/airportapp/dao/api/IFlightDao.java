package org.example.airportapp.dao.api;

import org.example.airportapp.core.dto.Flight;
import org.example.airportapp.core.dto.FlightFilter;
import org.example.airportapp.core.dto.Pageable;
import org.example.airportapp.dao.entity.FlightEntity;

import java.util.List;

public interface IFlightDao {
    List<FlightEntity> getAll();

    List<FlightEntity> getPage(Pageable pageable);

    List<FlightEntity> getPage(FlightFilter filter, Pageable pageable);
}
