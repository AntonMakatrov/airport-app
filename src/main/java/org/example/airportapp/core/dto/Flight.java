package org.example.airportapp.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    private String flightId;
    private String flightNo;
    private LocalDate scheduledDeparture;
    private LocalDate scheduledDepartureLocal;
    private LocalDate scheduledArrival;
    private LocalDate scheduledArrivalLocal;
    private String scheduledDuration;
    private String departureAirport;
    private String departureAirportName;
    private String departureCity;
    private String arrivalAirport;
    private String arrivalAirportName;
    private String arrivalCity;
    private String status;
    private String aircraftCode;
    private LocalDate actualDeparture;
    private LocalDate actualDepartureLocal;
    private LocalDate actualArrival;
    private LocalDate actualArrivalLocal;
    private String actualDuration;
}
