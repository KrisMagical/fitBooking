package com.fitness.booking.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "coach_profiles",
        indexes = @Index(name = "idx_coach_user", columnList = "userId", unique = true))
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CoachProfile extends BaseEntity {
    @Column(nullable = false)
    private Long userId;
    private Integer years;
    @Column(length = 256)
    private String certs;
    @Column(length = 256)
    private String specialties;

    private Integer price;
    @Column(length = 1024)
    private String bio;
    @Column(length = 16)
    private String gender;
    @Column(length = 128)
    private String location;
}
