package org.example.airportapp.dao.factory;


import org.example.airportapp.dao.AircraftDao;
import org.example.airportapp.dao.api.IAircraftDao;
import org.example.airportapp.dao.data_source.EMFFactory;

public class AircraftDaoFactory {
    private static volatile IAircraftDao instance;

    private AircraftDaoFactory() {
    }

    public static IAircraftDao getInstance() {
        if(instance == null){
            synchronized (AircraftDaoFactory.class){
                if(instance == null){
                    instance = new AircraftDao(EMFFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
