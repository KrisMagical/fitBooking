package com.fitness.booking.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoachProfileDTO {
    private Long id;
    private Long userId;
    private Integer years;
    private String certs;
    private String specialties;
    private Integer price;
    private String bio;
    private String gender;
    private String location;
}
