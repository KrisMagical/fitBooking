package com.fitness.booking.Model;

import com.fitness.booking.Model.Enums.FacilityStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "facilities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Facility extends BaseEntity {
    @Column(length = 64, nullable = false)
    private String name;
    @Column(length = 32, nullable = false)
    private String type;
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @Column(length = 16, nullable = false)
    private FacilityStatus facilityStatus;
}
