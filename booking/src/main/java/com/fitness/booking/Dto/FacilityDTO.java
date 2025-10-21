package com.fitness.booking.Dto;

import com.fitness.booking.Model.Enums.FacilityStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacilityDTO {
    private Long id;
    private String name;
    private String type;
    private Integer capacity;
    private FacilityStatus facilityStatus;
}
