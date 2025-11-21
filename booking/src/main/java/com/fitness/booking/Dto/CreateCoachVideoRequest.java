package com.fitness.booking.Dto;

import lombok.Data;

@Data
public class CreateCoachVideoRequest {

    private Long coachId;

    private String title;

    private String url;

    private String thumbnailUrl;

    private Integer duration;

    private String description;
}

