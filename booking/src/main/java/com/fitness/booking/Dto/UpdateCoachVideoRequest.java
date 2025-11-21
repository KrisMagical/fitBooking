package com.fitness.booking.Dto;

import com.fitness.booking.Model.Enums.VideoStatus;
import lombok.Data;

@Data
public class UpdateCoachVideoRequest {

    private String title;

    private String thumbnailUrl;

    private Integer duration;

    private String description;

    private VideoStatus status;

    private Integer sortOrder;

    private Long version;
}

