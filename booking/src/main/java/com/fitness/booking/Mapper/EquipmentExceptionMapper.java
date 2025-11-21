package com.fitness.booking.Mapper;

import com.fitness.booking.Dto.EquipmentExceptionDTO;
import com.fitness.booking.Model.EquipmentException;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EquipmentExceptionMapper {

    EquipmentExceptionDTO toDto(EquipmentException entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    EquipmentException fromDto(EquipmentExceptionDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget EquipmentException entity, EquipmentExceptionDTO dto);
}
