package com.fitness.booking.Mapper;

import com.fitness.booking.Dto.CoachProfileDTO;
import com.fitness.booking.Model.CoachProfile;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CoachMapper {
    CoachProfileDTO toDto(CoachProfile entity);
    CoachProfile toEntity(CoachProfileDTO dto);

    void updateEntity(@MappingTarget CoachProfile entity, CoachProfileDTO dto);
}

