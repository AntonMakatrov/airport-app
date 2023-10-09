package org.example.airportapp.dao.factory;

import org.example.airportapp.dao.AircraftDAO;
import org.example.airportapp.dao.api.IAircraftDao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class AircraftDaoFactory {
    private volatile static AircraftDAO instance;

    private AircraftDaoFactory(){
    }

    public static IAircraftDao getInstance()  {
        if (instance == null) {
            synchronized (AircraftDaoFactory.class) {
                if (instance == null) {
                    try {
                        instance = new AircraftDAO();
                    } catch (PropertyVetoException | IOException | SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return instance;
    }
}
