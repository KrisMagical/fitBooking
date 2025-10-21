package com.fitness.booking.Mapper;

import com.fitness.booking.Dto.BookingCreateRequest;
import com.fitness.booking.Dto.BookingDTO;
import com.fitness.booking.Model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookingMapper {
    @Mapping(target = "memberId", source = "memberId")
    @Mapping(target = "targetType", source = "targetType")
    @Mapping(target = "targetId", source = "targetId")
    @Mapping(target = "bookingStatus", source = "bookingStatus")
    BookingDTO toDto(Booking entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "memberId", ignore = true)
    @Mapping(target = "bookingStatus", ignore = true)
    @Mapping(target = "price", ignore = true)
    @Mapping(target = "paymentStatus", ignore = true)
    @Mapping(target = "auditLog", ignore = true)
    Booking fromCreate(BookingCreateRequest request);

    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@org.mapstruct.MappingTarget Booking entity, BookingDTO dto);
}
