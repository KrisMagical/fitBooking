package com.fitness.booking.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "staff")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Staff extends BaseEntity {
    @Column(length = 64, nullable = false)
    private String name;

    @Column(length = 16)
    private String gender;

    @Column(length = 24, nullable = false)
    private String phone;

    @Column(length = 128)
    private String email;

    @Column(length = 32, nullable = false)
    private String roleType;

    @Column(length = 16, nullable = false)
    private String status;

    private Instant hireDate;
    private Instant departDate;
    @Column(length = 512)
    private String notes;
}
