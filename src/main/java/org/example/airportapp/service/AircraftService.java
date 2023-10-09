package org.example.airportapp.service;

import org.example.airportapp.core.entity.Aircraft;
import org.example.airportapp.dao.api.IAircraftDao;
import org.example.airportapp.dao.factory.AircraftDaoFactory;
import org.example.airportapp.service.api.IAircraftService;

import java.sql.SQLException;
import java.util.List;

public class AircraftService implements IAircraftService {
    private IAircraftDao airplaneDao =  AircraftDaoFactory.getInstance();


    public AircraftService(IAircraftDao instance)  {
        this.airplaneDao = instance;
    }

    @Override
    public List<Aircraft> getAllAircrafts() throws SQLException{
        return airplaneDao.getAllAircrafts();
    }
}
