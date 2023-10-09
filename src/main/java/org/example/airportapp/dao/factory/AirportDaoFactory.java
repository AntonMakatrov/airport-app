package org.example.airportapp.dao.factory;

import org.example.airportapp.dao.AirportDAO;
import org.example.airportapp.dao.api.IAirportDao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class AirportDaoFactory {
    private volatile static AirportDAO instance;

    private AirportDaoFactory(){
    }

    public static IAirportDao getInstance()  {
        if (instance == null) {
            synchronized (AirportDaoFactory.class) {
                if (instance == null) {
                    try {
                        instance = new AirportDAO();
                    } catch (PropertyVetoException | SQLException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return instance;
    }
}
