package org.example.airportapp.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aircraft {
    private String aircraftCode;
    private String model;
    private Integer range;
}
