package org.example.airportapp.dao.factory;

import org.example.airportapp.dao.AirportDAO;
import org.example.airportapp.dao.FlightDAO;
import org.example.airportapp.dao.api.IAirportDao;
import org.example.airportapp.dao.api.IFlightDao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class FlightDaoFactory {
    private volatile static FlightDAO instance;

    private FlightDaoFactory(){
    }

    public static IFlightDao getInstance()  {
        if (instance == null) {
            synchronized (FlightDaoFactory.class) {
                if (instance == null) {
                    try {
                        instance = new FlightDAO();
                    } catch (PropertyVetoException | SQLException | IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return instance;
    }
}
