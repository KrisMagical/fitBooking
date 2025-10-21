package com.fitness.booking.Model;

import com.fitness.booking.Model.Enums.BookingStatus;
import com.fitness.booking.Model.Enums.TargetType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Entity
@Table(name = "bookings", indexes = {
        @Index(name = "idx_booking_member", columnList = "memberId"),
        @Index(name = "idx_booking_target", columnList = "targetType,targetId"),
        @Index(name = "uk_booking_idem", columnList = "idempotencyKey",unique = true)
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Booking extends BaseEntity{
    @Column(nullable = false)
    private Long memberId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 16)
    private TargetType targetType;

    @Column(nullable = false)
    private Long targetId;

    @Column(nullable = false)
    private Instant startTime;
    @Column(nullable = false)
    private Instant endTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 16)
    private BookingStatus bookingStatus;

    private Integer price;

    @Column(length = 16)
    private String paymentStatus;

    @Column(length = 64,unique = true)
    private String idempotencyKey;

    @Column(length = 1024)
    private String auditLog;
}
