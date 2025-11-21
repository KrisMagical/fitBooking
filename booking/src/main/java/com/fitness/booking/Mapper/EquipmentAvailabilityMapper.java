package com.fitness.booking.Mapper;

import com.fitness.booking.Dto.EquipmentAvailabilityDTO;
import com.fitness.booking.Model.EquipmentAvailability;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EquipmentAvailabilityMapper {

    EquipmentAvailabilityDTO toDto(EquipmentAvailability entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    EquipmentAvailability fromDto(EquipmentAvailabilityDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget EquipmentAvailability entity, EquipmentAvailabilityDTO dto);
}
