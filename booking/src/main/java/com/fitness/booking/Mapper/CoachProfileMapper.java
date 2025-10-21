package com.fitness.booking.Mapper;

import com.fitness.booking.Dto.CoachProfileDTO;
import com.fitness.booking.Model.CoachProfile;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CoachProfileMapper {

    CoachProfileDTO toDto(CoachProfile entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CoachProfile toEntity(CoachProfileDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget CoachProfile entity, CoachProfileDTO dto);
}
