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
public class StaffDTO {
    private Long id;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String roleType;
    private String status;
    private Instant hireDate;
    private Instant departDate;
    private String notes;
}
