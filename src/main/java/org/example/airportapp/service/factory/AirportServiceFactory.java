package org.example.airportapp.service.factory;

import org.example.airportapp.dao.factory.AirportDaoFactory;
import org.example.airportapp.service.AirportService;
import org.example.airportapp.service.api.IAirportService;

public class AirportServiceFactory {
    private volatile static AirportService instance;

    private AirportServiceFactory() {
    }

    public static IAirportService getInstance() {
        if (instance == null) {
            synchronized (AirportServiceFactory.class) {
                if (instance == null) {
                    instance = new AirportService(AirportDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
