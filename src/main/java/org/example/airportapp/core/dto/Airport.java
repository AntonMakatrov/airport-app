package org.example.airportapp.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport {
    private String airportCode;
    private String airportName;
    private String city;
    private String coordinates;
    private String timezone;
}
