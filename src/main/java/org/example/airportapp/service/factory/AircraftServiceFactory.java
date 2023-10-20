package org.example.airportapp.service.factory;

import org.example.airportapp.dao.factory.AircraftDaoFactory;
import org.example.airportapp.service.AircraftService;
import org.example.airportapp.service.api.IAircraftService;

public class AircraftServiceFactory {
    private static volatile IAircraftService instance;

    private AircraftServiceFactory() {
    }

    public static IAircraftService getInstance() {
        if(instance == null){
            synchronized (AircraftServiceFactory.class){
                if(instance == null){
                    instance = new AircraftService(AircraftDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
