package org.example.airportapp.service;

import org.example.airportapp.core.entity.Airport;
import org.example.airportapp.dao.api.IAirportDao;
import org.example.airportapp.service.api.IAirportService;

import java.sql.SQLException;
import java.util.List;

public class AirportService implements IAirportService {
    IAirportDao airportDao;
    public AirportService(IAirportDao instance) {
        this.airportDao = instance;
    }

    @Override
    public List<Airport> getAllAirports() throws SQLException {
        return airportDao.getAllAirports();
    }
}
