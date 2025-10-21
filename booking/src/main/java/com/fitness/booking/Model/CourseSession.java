package com.fitness.booking.Model;

import com.fitness.booking.Model.Enums.SessionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Entity
@Table(name = "course_sessions", indexes = {
        @Index(name = "idx_session_course", columnList = "courseId"),
        @Index(name = "idx_session_times", columnList = "startTime,endTime")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CourseSession extends BaseEntity {
    @Column(nullable = false)
    private Long courseId;

    private Long facilityId;

    @Column(nullable = false)
    private Instant startTime;
    @Column(nullable = false)
    private Instant endTime;

    @Column(nullable = false)
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @Column(length = 16, nullable = false)
    private SessionStatus sessionStatus;
}
