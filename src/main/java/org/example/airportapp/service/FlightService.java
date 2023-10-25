package org.example.airportapp.service;

import org.example.airportapp.core.dto.Flight;
import org.example.airportapp.core.dto.FlightFilter;
import org.example.airportapp.core.dto.Pageable;
import org.example.airportapp.dao.api.IFlightDao;
import org.example.airportapp.service.api.IFlightService;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService implements IFlightService {
    private final IFlightDao dao;

    public FlightService(IFlightDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Flight> getAll() {
        return this.dao.getAll().stream()
                .map(flightEntity -> new Flight(flightEntity.getFlightId(),
                        flightEntity.getFlightNo(), flightEntity.getScheduledDeparture(),
                        flightEntity.getScheduledDepartureLocal(),
                        flightEntity.getScheduledArrival(), flightEntity.getScheduledArrivalLocal(),
                        flightEntity.getScheduledDuration(), flightEntity.getDepartureAirport(),
                        flightEntity.getDepartureAirportName(), flightEntity.getDepartureCity(),
                        flightEntity.getArrivalAirport(), flightEntity.getArrivalAirportName(),
                        flightEntity.getArrivalCity(), flightEntity.getStatus(),
                        flightEntity.getAircraftCode(), flightEntity.getActualDeparture(),
                        flightEntity.getActualDepartureLocal(), flightEntity.getActualArrival(),
                        flightEntity.getActualArrivalLocal(), flightEntity.getActualDuration()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> getPage(Pageable pageable) {
        return this.dao.getPage(pageable).stream()
                .map(flightEntity -> new Flight(flightEntity.getFlightId(),
                        flightEntity.getFlightNo(), flightEntity.getScheduledDeparture(),
                        flightEntity.getScheduledDepartureLocal(),
                        flightEntity.getScheduledArrival(), flightEntity.getScheduledArrivalLocal(),
                        flightEntity.getScheduledDuration(), flightEntity.getDepartureAirport(),
                        flightEntity.getDepartureAirportName(), flightEntity.getDepartureCity(),
                        flightEntity.getArrivalAirport(), flightEntity.getArrivalAirportName(),
                        flightEntity.getArrivalCity(), flightEntity.getStatus(),
                        flightEntity.getAircraftCode(), flightEntity.getActualDeparture(),
                        flightEntity.getActualDepartureLocal(), flightEntity.getActualArrival(),
                        flightEntity.getActualArrivalLocal(), flightEntity.getActualDuration()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> getPage(FlightFilter filter, Pageable pageable) {

        return this.dao.getPage(filter, pageable).stream()
                .map(flightEntity -> new Flight(flightEntity.getFlightId(),
                        flightEntity.getFlightNo(), flightEntity.getScheduledDeparture(),
                        flightEntity.getScheduledDepartureLocal(),
                        flightEntity.getScheduledArrival(), flightEntity.getScheduledArrivalLocal(),
                        flightEntity.getScheduledDuration(), flightEntity.getDepartureAirport(),
                        flightEntity.getDepartureAirportName(), flightEntity.getDepartureCity(),
                        flightEntity.getArrivalAirport(), flightEntity.getArrivalAirportName(),
                        flightEntity.getArrivalCity(), flightEntity.getStatus(),
                        flightEntity.getAircraftCode(), flightEntity.getActualDeparture(),
                        flightEntity.getActualDepartureLocal(), flightEntity.getActualArrival(),
                        flightEntity.getActualArrivalLocal(), flightEntity.getActualDuration()))
                .collect(Collectors.toList());
    }
}
