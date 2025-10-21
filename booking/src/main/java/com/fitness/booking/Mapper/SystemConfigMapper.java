package com.fitness.booking.Mapper;

import com.fitness.booking.Dto.SystemConfigDTO;
import com.fitness.booking.Model.SystemConfig;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SystemConfigMapper {
    SystemConfigDTO toDto(SystemConfig entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    SystemConfig toEntity(SystemConfigDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget SystemConfig entity, SystemConfigDTO dto);
}
