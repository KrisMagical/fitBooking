package com.fitness.booking.Model;

import com.fitness.booking.Model.Enums.CourseStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "courses", indexes = @Index(name = "idx_course_coach", columnList = "coachId"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Course extends BaseEntity {
    @Column(nullable = false)
    private Long coachId;

    @Column(length = 128, nullable = false)
    private String title;

    @Column(length = 32)
    private String type;

    @Column(length = 32)
    private String targetLevel;
    private Integer price;
    @Column(length = 1024)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 16, nullable = false)
    private CourseStatus courseStatus;
}
