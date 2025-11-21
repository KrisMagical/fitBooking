package com.fitness.booking.Dto;

import com.fitness.booking.Model.Enums.VideoStatus;
import lombok.Data;

@Data
public class CoachVideoDTO {

    private Long id;

    private Long coachId;

    private String title;

    private String url;

    private String thumbnailUrl;

    private Integer duration;

    private String description;

    private VideoStatus status;

    private Integer sortOrder;

    private Long version;
}

