package com.fitness.booking.Mapper;

import com.fitness.booking.Dto.TrainingPlanCreateRequest;
import com.fitness.booking.Dto.TrainingPlanDTO;
import com.fitness.booking.Dto.TrainingPlanUpdateRequest;
import com.fitness.booking.Model.TrainingPlan;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TrainingPlanMapper {
    TrainingPlanDTO toDto(TrainingPlan entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "coachId",ignore = true)
    @Mapping(target = "planStatus",ignore = true)
    @Mapping(target = "lastUpdateBy",ignore = true)
    TrainingPlan fromCreate(TrainingPlanCreateRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget TrainingPlan entity, TrainingPlanUpdateRequest request);
}
