package com.fitness.booking.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCoachSessionRequest {
    private Instant startTime;
    private Instant endTime;
    private Integer capacity;
    private BigDecimal price;
    private Long facilityId;
    private String description;
}
