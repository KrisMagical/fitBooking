package com.fitness.booking.Dto;

import com.fitness.booking.Model.Enums.ExperienceLevel;
import com.fitness.booking.Model.Enums.Role;
import com.fitness.booking.Model.Enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String phone;
    private String email;
    private Role role;
    private UserStatus userStatus;
    private String fullName;
    private String gender;
    private Integer age;
    private ExperienceLevel experienceLevel;
    private String city;
    private String bio;
}
