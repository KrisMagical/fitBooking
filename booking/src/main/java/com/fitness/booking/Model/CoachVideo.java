package com.fitness.booking.Model;

import com.fitness.booking.Model.Enums.VideoStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "coach_videos")
public class CoachVideo extends BaseEntity {

    @Column(nullable = false)
    private Long coachId;

    @Column(nullable = false, length = 128)
    private String title;

    @Column(nullable = false, length = 512)
    private String url;

    @Column(length = 512)
    private String thumbnailUrl;

    private Integer duration; // 秒

    @Column(length = 1024)
    private String description;

    @Enumerated(EnumType.STRING)
    private VideoStatus status = VideoStatus.ENABLED;

    private Integer sortOrder = 0;
}

