package com.fitness.booking.Model;

import com.fitness.booking.Model.Enums.PlanStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@Table(name = "training_plans", indexes = {
        @Index(name = "idx_plan_member", columnList = "memberId"),
        @Index(name = "idx_plan_coach", columnList = "coachId")
})
@NoArgsConstructor
@AllArgsConstructor
public class TrainingPlan extends BaseEntity {
    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private Long coachId;

    @Column(length = 128, nullable = false)
    private String title;

    @Lob
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(length = 16, nullable = false)
    private PlanStatus planStatus;

    private Long lastUpdateBy;
}
