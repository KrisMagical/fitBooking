package com.fitness.booking.Mapper;

import com.fitness.booking.Dto.CoachSessionDTO;
import com.fitness.booking.Model.CoachSession;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CoachSessionMapper {
    CoachSessionDTO toDto(CoachSession entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CoachSession toEntity(CoachSessionDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget CoachSession entity, CoachSessionDTO dto);
}
