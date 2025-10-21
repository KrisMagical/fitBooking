package com.fitness.booking.Dto;

import com.fitness.booking.Model.Enums.SessionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseSessionDTO {
    private Long id;
    private Long courseId;
    private Long facilityId;
    private Instant startTime;
    private Instant endTime;
    private Integer capacity;
    private SessionStatus sessionStatus;
}
