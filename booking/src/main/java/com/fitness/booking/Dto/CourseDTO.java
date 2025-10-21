package com.fitness.booking.Dto;

import com.fitness.booking.Model.Enums.CourseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO {
    private Long id;
    private Long coachId;
    private String title;
    private String type;
    private String targetLevel;
    private Integer price;
    private String description;
    private CourseStatus courseStatus;
}
