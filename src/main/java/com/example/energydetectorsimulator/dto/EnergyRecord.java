package com.example.energydetectorsimulator.dto;

import java.time.LocalDateTime;

public record EnergyRecord(int voltage, LocalDateTime dateTime, String address) {
}
