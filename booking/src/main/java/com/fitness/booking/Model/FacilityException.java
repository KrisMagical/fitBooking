package com.fitness.booking.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;
import java.time.LocalTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "facility_exception")
public class FacilityException extends BaseEntity {

    private Long facilityId;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private String reason;
}

