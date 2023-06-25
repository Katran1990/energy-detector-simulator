package com.example.energydetectorsimulator;

import com.example.energydetectorsimulator.dto.EnergyRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class EnergyDetectorSimulatorJob {

    private final Queue detectorQueue;
    private final RabbitTemplate template;

    @Value("${energydetector.address}")
    private String address;

    @Async
    @Scheduled(fixedRate = 10000)
    public void simulateMetering() {
        var voltage = new Random().ints(200, 240)
                .findFirst()
                .getAsInt();
        template.convertAndSend(detectorQueue.getName(), new EnergyRecord(voltage, LocalDateTime.now(), address));
    }
}
