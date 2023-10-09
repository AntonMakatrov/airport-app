package org.example.airportapp.service.factory;

import org.example.airportapp.dao.factory.FlightDaoFactory;
import org.example.airportapp.service.FlightService;
import org.example.airportapp.service.api.IFlightService;

public class FlightServiceFactory {
    private volatile static FlightService instance;

    private FlightServiceFactory() {
    }

    public static IFlightService getInstance() {
        if (instance == null) {
            synchronized (FlightServiceFactory.class) {
                if (instance == null) {
                    instance = new FlightService(FlightDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
