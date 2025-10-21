package com.fitness.booking.Dto;

import com.fitness.booking.Model.Enums.TargetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingCreateRequest {
    private TargetType targetType;
    private Long targetId;
    private Instant startTime;
    private Instant endTime;
    private String idempotencyKey;
}
