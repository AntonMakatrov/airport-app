package org.example.airportapp.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightFilter {
    private LocalDate scheduledDeparture;
    private LocalDate scheduledArrival;
    private String departureAirport;
    private String arrivalAirport;
    private String status;
}
