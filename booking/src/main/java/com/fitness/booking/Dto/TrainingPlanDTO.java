package com.fitness.booking.Dto;

import com.fitness.booking.Model.Enums.PlanStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingPlanDTO {
    private Long id;
    private Long memberId;
    private Long coachId;
    private String title;
    private String content;
    private PlanStatus planStatus;
}
