package com.fitness.booking.Mapper;

import com.fitness.booking.Dto.FacilityExceptionDTO;
import com.fitness.booking.Model.FacilityException;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FacilityExceptionMapper {

    FacilityExceptionDTO toDto(FacilityException entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    FacilityException fromDto(FacilityExceptionDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget FacilityException entity, FacilityExceptionDTO dto);
}

