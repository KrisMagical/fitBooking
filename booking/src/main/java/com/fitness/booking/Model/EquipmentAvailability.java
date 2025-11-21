package com.fitness.booking.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "equipment_availability")
public class EquipmentAvailability extends BaseEntity {

    private Long equipmentId;

    private Integer dayOfWeek;

    private LocalTime startTime;

    private LocalTime endTime;

    private Integer maxBooking;

    private Boolean isDefault = true;
}

