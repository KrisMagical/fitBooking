package com.fitness.booking.Mapper;

import com.fitness.booking.Dto.*;
import com.fitness.booking.Model.CoachVideo;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CoachVideoMapper {

    CoachVideoDTO toDto(CoachVideo entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CoachVideo fromCreate(CreateCoachVideoRequest req);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget CoachVideo entity, UpdateCoachVideoRequest req);
}

