package org.example.airportapp.dao.factory;


import org.example.airportapp.dao.FlightDao;
import org.example.airportapp.dao.api.IFlightDao;
import org.example.airportapp.dao.data_source.EMFFactory;

public class FlightDaoFactory {
    private static volatile IFlightDao instance;

    private FlightDaoFactory() {
    }

    public static IFlightDao getInstance() {
        if(instance == null){
            synchronized (FlightDaoFactory.class){
                if(instance == null){
                    instance = new FlightDao(EMFFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
