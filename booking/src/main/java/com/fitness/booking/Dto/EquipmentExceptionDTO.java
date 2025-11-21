package com.fitness.booking.Dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class EquipmentExceptionDTO {
    private Long id;

    private Long equipmentId;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private String reason;

    private Long version;
}
