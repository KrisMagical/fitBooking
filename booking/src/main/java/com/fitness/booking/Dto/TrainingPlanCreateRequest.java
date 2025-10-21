package com.fitness.booking.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingPlanCreateRequest {
    private Long memberId;
    private String title;
    private String content;
}
