package com.fitness.booking.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "facility_availability")
public class FacilityAvailability extends BaseEntity {

    private Long facilityId;

    private Integer dayOfWeek; // 0-6

    private LocalTime startTime;

    private LocalTime endTime;

    private Integer maxBooking;

    private Boolean isDefault = true;
}

