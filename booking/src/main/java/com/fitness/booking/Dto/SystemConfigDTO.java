package com.fitness.booking.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemConfigDTO {
    private Long id;
    private String cfgkey;
    private String value;
}
