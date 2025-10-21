package com.fitness.booking.Dto;

import com.fitness.booking.Model.Enums.EquipmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentDTO {
    private Long id;
    private String name;
    private String type;
    private EquipmentStatus equipmentStatus;
    private String location;
    private String maintainStatus;
}
