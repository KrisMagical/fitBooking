package com.fitness.booking.Model;

import com.fitness.booking.Model.Enums.EquipmentStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "equipment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Equipment extends BaseEntity {
    @Column(length = 64, nullable = false)
    private String name;

    @Column(length = 32, nullable = false)
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(length = 16, nullable = false)
    private EquipmentStatus equipmentStatus;

    @Column(length = 64)
    private String location;

    @Column(length = 64)
    private String maintainStatus;
}
