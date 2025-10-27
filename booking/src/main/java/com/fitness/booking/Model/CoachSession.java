package com.fitness.booking.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coach_sessions", indexes = {
        @Index(name = "idx_coach_sessions_coach", columnList = "coachId"),
        @Index(name = "idx_coach_sessions_status", columnList = "status")
})
public class CoachSession extends BaseEntity {

    @Column(nullable = false)
    private Long coachId; // 对应 User.id 且 role=COACH

    @Column(nullable = false)
    private Instant startTime;

    @Column(nullable = false)
    private Instant endTime;

    @Column(nullable = false)
    private Integer capacity; // 一对一 = 1，可扩展团课

    @Column(nullable = false)
    private BigDecimal price;

    @Column(length = 32, nullable = false)
    private String status; // OPEN, FULL, CANCELLED

    private Long facilityId; // 可选：使用的场地

    @Column(length = 512)
    private String description;
}
