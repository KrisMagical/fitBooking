package com.fitness.booking.Mapper;

import com.fitness.booking.Dto.FacilityAvailabilityDTO;
import com.fitness.booking.Model.FacilityAvailability;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FacilityAvailabilityMapper {

    FacilityAvailabilityDTO toDto(FacilityAvailability entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    FacilityAvailability fromDto(FacilityAvailabilityDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget FacilityAvailability entity, FacilityAvailabilityDTO dto);
}

