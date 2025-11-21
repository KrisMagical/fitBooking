package com.fitness.booking.Dto;

import lombok.Data;
import java.time.LocalTime;

@Data
public class FacilityAvailabilityDTO {

    private Long id;

    private Long facilityId;

    private Integer dayOfWeek;

    private LocalTime startTime;

    private LocalTime endTime;

    private Integer maxBooking;

    private Boolean isDefault;

    private Long version;
}

