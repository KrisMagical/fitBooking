package com.fitness.booking.Mapper;

import com.fitness.booking.Dto.FacilityDTO;
import com.fitness.booking.Dto.StaffDTO;
import com.fitness.booking.Model.Facility;
import com.fitness.booking.Model.Staff;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FacilityMapper {
    FacilityDTO toDto(Facility entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Facility toEntity(FacilityDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget Facility entity, FacilityDTO dto);
}
