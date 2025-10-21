package com.fitness.booking.Dto;

import com.fitness.booking.Model.Enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingSearchRequest {
    private BookingStatus bookingStatus;
    private Instant from;
    private Instant to;
    private String keyword;
    private Integer page;
    private Integer size;
}
