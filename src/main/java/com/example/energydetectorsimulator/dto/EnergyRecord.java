package com.example.energydetectorsimulator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EnergyRecord {

    private double voltage;
    private LocalDateTime dateTime;
}
