package com.fitness.booking.Dto;

import com.fitness.booking.Model.Enums.ExperienceLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    private String phone;
    private String password;
    private String fullName;
    private String gender;
    private Integer age;
    private ExperienceLevel experienceLevel;
    private String city;
    private String idempotencyKey;
}
