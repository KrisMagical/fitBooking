package com.fitness.booking.Dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class FacilityExceptionDTO {

    private Long id;

    private Long facilityId;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private String reason;

    private Long version;
}

