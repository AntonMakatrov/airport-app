package org.example.airportapp.dao.factory;


import org.example.airportapp.dao.AirportDao;
import org.example.airportapp.dao.api.IAirportDao;
import org.example.airportapp.dao.data_source.EMFFactory;

public class AirportDaoFactory {
    private static volatile IAirportDao instance;

    private AirportDaoFactory() {
    }

    public static IAirportDao getInstance() {
        if(instance == null){
            synchronized (AirportDaoFactory.class){
                if(instance == null){
                    instance = new AirportDao(EMFFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
